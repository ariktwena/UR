package dto;

import entities.Department;
import entities.User;
import java.util.ArrayList;

public class DepartmentDTOFull {

  private int id;
  private String name;
  private ArrayList<UserDTOSmall> users;

  public DepartmentDTOFull() {
  }

  public DepartmentDTOFull(Department department) {
    this.id = department.getId();
    this.name = department.getDepartmentName();
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
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ArrayList<UserDTOSmall> getUsers() {
    return users;
  }

  public void setUsers(ArrayList<UserDTOSmall> users) {
    this.users = users;
  }

  @Override
  public String toString() {
    return "DepartmentDTOFull{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", users=" + users +
        '}';
  }
}
