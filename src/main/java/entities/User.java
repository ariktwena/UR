package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.mindrot.jbcrypt.BCrypt;

@Entity
@Table(name = "users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int id;
    @Column(name = "user_name", length = 25)
    private String userName;
    @Column(name = "first_name", length = 125)
    private String firstName;
    @Column(name = "last_name", length = 25)
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_pass")
    private String userPass;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "user_salt")
    private String userSalt;
    @Column(name = "active")
    private int active;
    @JoinTable(name = "user_roles", joinColumns = {
        @JoinColumn(name = "user_id", referencedColumnName = "user_id")}, inverseJoinColumns = {
        @JoinColumn(name = "role_id", referencedColumnName = "role_id")})
    @ManyToMany
    private List<Role> roleList = new ArrayList<>();

    public List<String> getRolesAsStrings() {
        if (roleList.isEmpty()) {
            return null;
        }
        List<String> rolesAsStrings = new ArrayList<>();
        roleList.forEach((role) -> {
            rolesAsStrings.add(role.getRoleName());
        });
        return rolesAsStrings;
    }

    //***************Many to One****************
    @ManyToOne
    private Department department;

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
    //***************************************************************

    //***************One to Many****************
    @OneToMany(mappedBy = "user", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ArrayList<Project> projects;

    public void addProject(Project project) {
        if (project != null) {
            project.setUser(this);
            this.projects.add(project);
        }
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }
    //*****************************************

    public User() {
    }

    //TODO Change when password is hashed
    public boolean verifyPassword(String enteredPassword) {
        return BCrypt.checkpw(enteredPassword, this.userPass);
        //return(pw.equals(userPass));
    }

    public User(String firstName, String lastName, String userName, String userPass) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.userSalt = BCrypt.gensalt(10);
        this.userPass = encrypt(userPass);
        this.department = null;
        this.projects = new ArrayList<>();
        this.active = 1;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPass() {
        return this.userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = encrypt(userPass);
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public void addRole(Role userRole) {
        roleList.add(userRole);
    }

    public void removeRole(Role userRole) {
        if(userRole != null){
            this.roleList.remove(userRole);
            userRole.getUserList().remove(this);
        }
    }

    public String encrypt(String password) {
        return BCrypt.hashpw(password, this.userSalt);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserSalt() {
        this.userSalt = BCrypt.gensalt(10);
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", userPass='" + userPass + '\'' +
            ", userSalt='" + userSalt + '\'' +
            ", active=" + active +
            ", roleList=" + roleList +
            ", department=" + department +
            ", projects=" + projects +
            '}';
    }
}
