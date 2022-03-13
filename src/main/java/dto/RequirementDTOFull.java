/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Requirement;
import entities.Requirement.Status;
import java.time.LocalDate;

public class RequirementDTOFull {

  private int id;
  private LocalDate created;
  private String description;
  private Status status;
  private int active;
  private UserDTOSmall author;
  private int req_dependency_id;
  private LocalDate edited;
  private UserDTOSmall editor;


  public RequirementDTOFull() {
  }

  public RequirementDTOFull(Requirement requirement) {
    this.id = requirement.getId();
    this.created = requirement.getCreated();
    this.description = requirement.getDescription();
    this.status = requirement.getStatus();
    this.active = requirement.getActive();
    this.author = requirement.getAuthor() == null ? null : new UserDTOSmall(requirement.getAuthor());
    this.req_dependency_id = requirement.getDepended_on_id();
    this.edited = requirement.getEdited();
    this.editor = requirement.getEditor() == null ? null : new UserDTOSmall(requirement.getEditor());
  }

  public RequirementDTOFull(LocalDate created, String description,
      String status, int active, UserDTOSmall author, int req_dependency_id,
      LocalDate edited, UserDTOSmall editor) {
    this.id = -1;
    this.created = created;
    this.description = description;
    this.status = findStatus(status);
    this.active = active;
    this.author = author;
    this.req_dependency_id = req_dependency_id;
    this.edited = edited;
    this.editor = editor;
  }

  private Status findStatus(String status){
    switch (status){
      case "Approved":
        return Status.Approved;
      case "Review":
        return Status.Review;
      case "Pending":
        return Status.Pending;
      default:
        return Status.Completed;
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public LocalDate getCreated() {
    return created;
  }

  public void setCreated(LocalDate created) {
    this.created = created;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public UserDTOSmall getAuthor() {
    return author;
  }

  public void setAuthor(UserDTOSmall author) {
    this.author = author;
  }

  public int getReq_dependency_id() {
    return req_dependency_id;
  }

  public void setReq_dependency_id(int req_dependency_id) {
    this.req_dependency_id = req_dependency_id;
  }

  public LocalDate getEdited() {
    return edited;
  }

  public void setEdited(LocalDate edited) {
    this.edited = edited;
  }

  public UserDTOSmall getEditor() {
    return editor;
  }

  public void setEditor(UserDTOSmall editor) {
    this.editor = editor;
  }


}
