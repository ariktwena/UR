package dto;

import entities.Department;

public class DepartmentDTOSmall {

  private int id;
  private String departmentName;
  private int active;

  public DepartmentDTOSmall() {
  }

  public DepartmentDTOSmall(Department department) {
    this.id = department.getId();
    this.departmentName = department.getDepartmentName();
    this.active = department.getActive();
  }

  public DepartmentDTOSmall(String name) {
    this.id = -1;
    this.departmentName = name;
    this.active = 1;
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

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "DepartmentDTOSmall{" +
        "id=" + id +
        ", departmentName='" + departmentName + '\'' +
        ", active=" + active +
        '}';
  }
}
