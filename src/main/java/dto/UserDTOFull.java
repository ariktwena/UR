package dto;

import entities.Role;
import entities.User;
import java.util.ArrayList;
import java.util.List;

public class UserDTOFull {
  private int id;
  private String firstName;
  private String lastName;
  private DepartmentDTOSmall departmentDTOSmall;
  private ArrayList<RoleDTO> roles;

  public UserDTOFull() {
  }

  public UserDTOFull(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.departmentDTOSmall = user.getDepartment() == null ? null : new DepartmentDTOSmall(user.getDepartment());
    this.roles = user.getRoleList() == null ? null : convertToDto(user.getRoleList());
  }

  public UserDTOFull(int id) {
    this.id = id;
    this.firstName = "";
    this.lastName = "";
    this.departmentDTOSmall = null;
    this.roles = new ArrayList<>();
  }

  public UserDTOFull(String firstName, String lastName) {
    this.id = -1;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = null;
    this.roles = new ArrayList<>();
  }

  public UserDTOFull(String firstName, String lastName, String departmentName) {
    this.id = -1;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = new DepartmentDTOSmall(departmentName);
    this.roles = new ArrayList<>();
  }

  public UserDTOFull(String firstName, String lastName, String departmentName, ArrayList<RoleDTO> roles) {
    this.id = -1;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = new DepartmentDTOSmall(departmentName);
    this.roles = roles;
  }

  public UserDTOFull(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = null;
    this.roles = new ArrayList<>();
  }

  public UserDTOFull(int id, String firstName, String lastName, String departmentName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = new DepartmentDTOSmall(departmentName);
  }

  private ArrayList<RoleDTO> convertToDto(List<Role> roles){
    ArrayList<RoleDTO> roleDTOS = new ArrayList<>();
    for(Role role : roles){
      RoleDTO roleDTO = new RoleDTO(role);
      roleDTOS.add(roleDTO);
    }
    return roleDTOS;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public DepartmentDTOSmall getDepartmentDTOSmall() {
    return departmentDTOSmall;
  }

  public void setDepartmentDTOSmall(DepartmentDTOSmall departmentDTOSmall) {
    this.departmentDTOSmall = departmentDTOSmall;
  }

  public ArrayList<RoleDTO> getRoles() {
    return roles;
  }

  public void setRoles(ArrayList<RoleDTO> roles) {
    this.roles = roles;
  }

  @Override
  public String toString() {
    return "UserDTOFull{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", departmentDTOSmall=" + departmentDTOSmall +
        ", roles=" + roles +
        '}';
  }
}
