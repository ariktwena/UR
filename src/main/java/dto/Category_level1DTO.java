/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Category_level0;
import entities.Category_level1;
import java.util.ArrayList;

public class Category_level1DTO {

  private int id;
  private String categoryName;
  private int active;
  private int level;
  private int refrence_id;

  public Category_level1DTO() {
  }

  public Category_level1DTO(Category_level1 category_level1) {
    this.id = category_level1.getId();
    this.categoryName = category_level1.getCategoryName();
    this.active = category_level1.getActive();
    this.level = category_level1.getLevel();
    this.refrence_id = category_level1.getRefrence_id();
  }

  public Category_level1DTO(String categoryName) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.level = -1;
    this.refrence_id = -1;
  }

  public Category_level1DTO(String categoryName, int refrence_id) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.level = -1;
    this.refrence_id = refrence_id;
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

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getRefrence_id() {
    return refrence_id;
  }

  public void setRefrence_id(int refrence_id) {
    this.refrence_id = refrence_id;
  }
}
