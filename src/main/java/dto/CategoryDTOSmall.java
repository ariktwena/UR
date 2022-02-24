/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Category;
import java.util.ArrayList;

public class CategoryDTOSmall {

  private int id;
  private String categoryName;
  private int active;
  private ProjectDTOSmall projectDTOSmall;
  private int category_dependency_id;
  private ArrayList<CategoryDTOSmall> subCategories = new ArrayList<>();

  public CategoryDTOSmall() {
  }

  public CategoryDTOSmall(Category category) {
    this.id = category.getId();
    this.categoryName = category.getCategoryName();
    this.active = category.getActive();
    this.projectDTOSmall = category.getProject() != null ? new ProjectDTOSmall(category.getProject()) : null;
    this.category_dependency_id = category.getCategory_dependency_id();
  }

  public CategoryDTOSmall(String categoryName, int active, int category_dependency_id) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = active;
    this.category_dependency_id = category_dependency_id;
    this.projectDTOSmall = null;
  }

  public CategoryDTOSmall(String categoryName, int active, int category_dependency_id, ProjectDTOSmall projectDTOSmall) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = active;
    this.category_dependency_id = category_dependency_id;
    this.projectDTOSmall = projectDTOSmall;
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

  public ProjectDTOSmall getProjectDTOSmall() {
    return projectDTOSmall;
  }

  public void setProjectDTOSmall(ProjectDTOSmall projectDTOSmall) {
    this.projectDTOSmall = projectDTOSmall;
  }

  public int getCategory_dependency_id() {
    return category_dependency_id;
  }

  public void setCategory_dependency_id(int category_dependency_id) {
    this.category_dependency_id = category_dependency_id;
  }

  public ArrayList<CategoryDTOSmall> getSubCategories() {
    return subCategories;
  }

  public void setSubCategories(ArrayList<CategoryDTOSmall> subCategories) {
    this.subCategories = subCategories;
  }
}
