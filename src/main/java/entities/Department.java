package entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
@NamedQueries({
    @NamedQuery(name = "Department.deleteAllRows", query = "DELETE from Department "),})
public class Department implements Serializable {

  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name", length = 255, nullable = false, unique = true)
  private String departmentName;

  //***************One to Many****************
  @OneToMany(mappedBy = "department", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ArrayList<User> users;

  public void addUser(User user) {
    if (user != null) {
      user.setDepartment(this);
      this.users.add(user);
    }
  }

  public ArrayList<User> getUsers() {
    return users;
  }
  //*****************************************

  /* Variables here */

  public Department() {
  }

  public Department(String departmentName) {
    this.departmentName = departmentName;
    this.users = new ArrayList<>();
  }

  /* Constructor here */

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDepartmentName() {
    return departmentName;
  }

  public void setDepartmentName(String departmentName) {
    this.departmentName = departmentName;
  }
}