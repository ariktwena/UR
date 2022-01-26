package dto;

import entities.Department;
import entities.User;
import java.util.ArrayList;

public class DepartmentDTOFull {

  private int id;
  private String departmentName;
  private int active;
  private ArrayList<UserDTOSmall> users;

  public DepartmentDTOFull() {
  }

  public DepartmentDTOFull(Department department) {
    this.id = department.getId();
    this.departmentName = department.getDepartmentName();
    this.active = department.getActive();
    this.users = department.getUsers() == null ? null : convertToDto(department.getUsers());
  }

  private ArrayList<UserDTOSmall> convertToDto(ArrayList<User> users){
    ArrayList<UserDTOSmall> usersDTO = new ArrayList<>();
    for(User user : users){
      UserDTOSmall userDTOSmall = new UserDTOSmall(user);
      usersDTO.add(userDTOSmall);
    }
    return usersDTO;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return departmentName;
  }

  public void setName(String name) {
    this.departmentName = name;
  }

  public ArrayList<UserDTOSmall> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<UserDTOSmall> users) {
    this.users = users;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "DepartmentDTOFull{" +
        "id=" + id +
        ", departmentName='" + departmentName + '\'' +
        ", active=" + active +
        ", users=" + users +
        '}';
  }
}
