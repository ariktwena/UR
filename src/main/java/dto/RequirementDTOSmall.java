/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Requirement;
import entities.Requirement.Status;
import java.time.LocalDate;

public class RequirementDTOSmall {

  private int id;
  private LocalDate created;
  private String description;
  private Status status;
  private UserDTOSmall author;
  private int active;
  private CategoryDTOSmall categoryDTOSmall;

  public RequirementDTOSmall() {
  }

  public RequirementDTOSmall(Requirement requirement) {
    this.id = requirement.getId();
    this.created = requirement.getCreated();
    this.description = requirement.getDescription();
    this.status = requirement.getStatus();
    this.author = requirement.getAuthor() == null ? null : new UserDTOSmall(requirement.getAuthor());
    this.active = requirement.getActive();
    this.categoryDTOSmall = requirement.getCategory() == null ? null : new CategoryDTOSmall(requirement.getCategory());
  }

  public RequirementDTOSmall(LocalDate created, String description,
      String status, int active) {
    this.id = -1;
    this.created = created;
    this.description = description;
    this.status = findStatus(status);
    this.active = active;
    this.author = null;
    this.categoryDTOSmall = null;
  }

  public RequirementDTOSmall(LocalDate created, String description,
      String status, int active, UserDTOSmall userDTOSmall, CategoryDTOSmall categoryDTOSmall) {
    this.id = -1;
    this.created = created;
    this.description = description;
    this.status = findStatus(status);
    this.active = active;
    this.author = userDTOSmall;
    this.categoryDTOSmall = categoryDTOSmall;
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

  public CategoryDTOSmall getCategoryDTOSmall() {
    return categoryDTOSmall;
  }

  public void setCategoryDTOSmall(CategoryDTOSmall categoryDTOSmall) {
    this.categoryDTOSmall = categoryDTOSmall;
  }
}
