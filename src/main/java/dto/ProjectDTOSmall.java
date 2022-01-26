package dto;

import entities.Project;

public class ProjectDTOSmall {

  private int id;
  private String projectName;
  private int active;

  public ProjectDTOSmall() {
  }

  public ProjectDTOSmall(Project project) {
    this.id = project.getId();
    this.projectName = project.getProjectName();
    this.active = project.getActive();
  }

  public ProjectDTOSmall(String projectName, UserDTOFull user) {
    this.id = -1;
    this.projectName = projectName;
    this.active = 1;
  }

  public ProjectDTOSmall(int id, String projectName, UserDTOFull user) {
    this.id = id;
    this.projectName = projectName;
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

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "ProjectDTOSmall{" +
        "id=" + id +
        ", projectName='" + projectName + '\'' +
        ", active=" + active +
        '}';
  }
}