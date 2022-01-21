package dto;

import entities.Department;

public class DepartmentDTOSmall {

  private int id;
  private String name;

  public DepartmentDTOSmall() {
  }

  public DepartmentDTOSmall(Department department) {
    this.id = department.getId();
    this.name = department.getDepartmentName();
  }

  public DepartmentDTOSmall(String name) {
    this.id = -1;
    this.name = name;
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

  @Override
  public String toString() {
    return "DepartmentDTOSmall{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
