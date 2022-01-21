package dto;

import entities.Project;
import entities.User;
import java.util.ArrayList;

public class UserDTOFullProject {private int id;
  private String firstName;
  private String lastName;
  private DepartmentDTOSmall departmentDTOSmall;
  private ArrayList<ProjectDTOSmall> projects;

  public UserDTOFullProject() {
  }

  public UserDTOFullProject(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.departmentDTOSmall = user.getDepartment() == null ? null : new DepartmentDTOSmall(user.getDepartment());
    this.projects = user.getProjects() == null ? null : convertToDto(user.getProjects());
  }

  public UserDTOFullProject(int id) {
    this.id = id;
    this.firstName = "";
    this.lastName = "";
    this.departmentDTOSmall = null;
    this.projects = new ArrayList<>();
  }

  private ArrayList<ProjectDTOSmall> convertToDto(ArrayList<Project> projects){
    ArrayList<ProjectDTOSmall> projectDTOSmalls = new ArrayList<>();
    for(Project project : projects){
      ProjectDTOSmall projectDTOSmall = new ProjectDTOSmall(project);
      projectDTOSmalls.add(projectDTOSmall);
    }
    return projectDTOSmalls;
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

  public ArrayList<ProjectDTOSmall> getProjects() {
    return projects;
  }

  public void setProjects(ArrayList<ProjectDTOSmall> projects) {
    this.projects = projects;
  }

  @Override
  public String toString() {
    return "UserDTOFullProject{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", departmentDTOSmall=" + departmentDTOSmall +
        ", projects=" + projects +
        '}';
  }
}
