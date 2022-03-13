/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Category;
import java.util.ArrayList;

public class CategoryDTOFull {

  private int id;
  private String categoryName;
  private int active;
  private int category_level;

  public CategoryDTOFull() {
  }

  public CategoryDTOFull(Category category) {
    this.id = category.getId();
    this.categoryName = category.getCategoryName();
    this.active = category.getActive();
    this.category_level = category.getCategory_level();
  }

  public CategoryDTOFull(String categoryName, int category_level) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.category_level = category_level;
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
}