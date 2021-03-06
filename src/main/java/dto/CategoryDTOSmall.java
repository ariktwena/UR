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
  private int category_level;
  private int refrence_id;

  public CategoryDTOSmall() {
  }

  public CategoryDTOSmall(Category category) {
    this.id = category.getId();
    this.categoryName = category.getCategoryName();
    this.active = category.getActive();
    this.category_level = category.getCategory_level();
    this.refrence_id = category.getRefrence_id();
  }

  public CategoryDTOSmall(String categoryName, int category_level, int refrence_id) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.category_level = category_level;
    this.refrence_id = refrence_id;
  }

  public CategoryDTOSmall(String categoryName, int category_level) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.category_level = category_level;
    this.refrence_id = -1;
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

  public int getCategory_level() {
    return category_level;
  }

  public void setCategory_level(int category_level) {
    this.category_level = category_level;
  }

  public int getRefrence_id() {
    return refrence_id;
  }

  public void setRefrence_id(int refrence_id) {
    this.refrence_id = refrence_id;
  }
}
