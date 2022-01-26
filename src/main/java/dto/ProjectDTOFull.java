package dto;

import entities.Project;

public class ProjectDTOFull {

  private int id;
  private String projectName;
  private UserDTOSmall user;
  private int active;

  public ProjectDTOFull() {
  }

  public ProjectDTOFull(Project project) {
    this.id = project.getId();
    this.projectName = project.getProjectName();
    this.user = project.getUser() == null ? null : new UserDTOSmall(project.getUser());
    this.active = project.getActive();
  }

  public ProjectDTOFull(String projectName, UserDTOSmall user) {
    this.id = -1;
    this.projectName = projectName;
    this.user = user;
    this.active = 1;
  }

  public ProjectDTOFull(int id, String projectName, UserDTOSmall user) {
    this.id = id;
    this.projectName = projectName;
    this.user = user;
    this.active = 1;
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

  public UserDTOSmall getUser() {
    return user;
  }

  public void setUser(UserDTOSmall user) {
    this.user = user;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "ProjectDTOFull{" +
        "id=" + id +
        ", projectName='" + projectName + '\'' +
        ", user=" + user +
        ", active=" + active +
        '}';
  }
}
