package dto;

import entities.Project;

public class ProjectDTOSmall {

  private int id;
  private String projectName;

  public ProjectDTOSmall() {
  }

  public ProjectDTOSmall(Project project) {
    this.id = project.getId();
    this.projectName = project.getProjectName();
  }

  public ProjectDTOSmall(String projectName, UserDTOFull user) {
    this.id = -1;
    this.projectName = projectName;
  }

  public ProjectDTOSmall(int id, String projectName, UserDTOFull user) {
    this.id = id;
    this.projectName = projectName;
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

  @Override
  public String toString() {
    return "ProjectDTOSmall{" +
        "id=" + id +
        ", projectName='" + projectName + '\'' +
        '}';
  }
}