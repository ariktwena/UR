/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Category;
import java.util.ArrayList;

public class CategoryDTOFull {private int id;
  private String categoryName;
  private int active;
  private ProjectDTOFull projectDTOFull;
  private int category_dependency_id;
  private ArrayList<CategoryDTOFull> subCategories = new ArrayList<>();

  public CategoryDTOFull() {
  }

  public CategoryDTOFull(Category category) {
    this.id = category.getId();
    this.categoryName = category.getCategoryName();
    this.active = category.getActive();
    this.projectDTOFull = category.getProject() != null ? new ProjectDTOFull(category.getProject()) : null;
    this.category_dependency_id = category.getCategory_dependency_id();
  }

  public CategoryDTOFull(String categoryName, int active, int category_dependency_id) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = active;
    this.projectDTOFull = null;
    this.category_dependency_id = category_dependency_id;
  }

  public CategoryDTOFull(String categoryName, int active, int category_dependency_id, ProjectDTOFull projectDTOFull) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = active;
    this.category_dependency_id = category_dependency_id;
    this.projectDTOFull = projectDTOFull;

  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCategoryName() {
    return categoryName;
  }

  public void setCategoryName(String categoryName) {
    this.categoryName = categoryName;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  public ProjectDTOFull getProjectDTOFull() {
    return projectDTOFull;
  }

  public void setProjectDTOFull(ProjectDTOFull projectDTOFull) {
    this.projectDTOFull = projectDTOFull;
  }

  public int getCategory_dependency_id() {
    return category_dependency_id;
  }

  public void setCategory_dependency_id(int category_dependency_id) {
    this.category_dependency_id = category_dependency_id;
  }

  public ArrayList<CategoryDTOFull> getSubCategories() {
    return subCategories;
  }

  public void setSubCategories(ArrayList<CategoryDTOFull> subCategories) {
    this.subCategories = subCategories;
  }
}