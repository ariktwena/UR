package dto;

import entities.User;

public class UserDTOFull {
  private int id;
  private String firstName;
  private String lastName;
  private DepartmentDTOSmall departmentDTOSmall;

  public UserDTOFull() {
  }

  public UserDTOFull(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.departmentDTOSmall = user.getDepartment() == null ? null : new DepartmentDTOSmall(user.getDepartment());
  }

  public UserDTOFull(int id) {
    this.id = id;
    this.firstName = "";
    this.lastName = "";
    this.departmentDTOSmall = null;
  }

  public UserDTOFull(String firstName, String lastName) {
    this.id = -1;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = null;
  }

  public UserDTOFull(String firstName, String lastName, String departmentName) {
    this.id = -1;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = new DepartmentDTOSmall(departmentName);
  }

  public UserDTOFull(int id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = null;
  }

  public UserDTOFull(int id, String firstName, String lastName, String departmentName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.departmentDTOSmall = new DepartmentDTOSmall(departmentName);
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

  @Override
  public String toString() {
    return "UserDTOFull{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", departmentDTOSmall=" + departmentDTOSmall +
        '}';
  }
}
