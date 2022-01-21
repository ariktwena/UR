package dto;

import entities.Project;

public class ProjectDTOFull {

  private int id;
  private String projectName;
  private UserDTOFull user;

  public ProjectDTOFull() {
  }

  public ProjectDTOFull(Project project) {
    this.id = project.getId();
    this.projectName = project.getProjectName();
    this.user = project.getUser() == null ? null : new UserDTOFull(project.getUser());
  }

  public ProjectDTOFull(String projectName, UserDTOFull user) {
    this.id = -1;
    this.projectName = projectName;
    this.user = user;
  }

  public ProjectDTOFull(int id, String projectName, UserDTOFull user) {
    this.id = id;
    this.projectName = projectName;
    this.user = user;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProjectName() {
    return projectName;
  }

  public void setProjectName(String projectName) {
    this.projectName = projectName;
  }

  public UserDTOFull getUser() {
    return user;
  }

  public void setUser(UserDTOFull user) {
    this.user = user;
  }

  @Override
  public String toString() {
    return "ProjectDTOFull{" +
        "id=" + id +
        ", projectName='" + projectName + '\'' +
        ", user=" + user +
        '}';
  }
}
