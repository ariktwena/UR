/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Category_level0;
import entities.Category_level1;
import java.util.ArrayList;

public class Category_level0DTO {

  private int id;
  private String categoryName;
  private int active;
  private int level;
  private int refrence_id;
  private ArrayList<Category_level1DTO> category_level1DTOS;

  public Category_level0DTO() {
  }

  public Category_level0DTO(Category_level0 category_level0) {
    this.id = category_level0.getId();
    this.categoryName = category_level0.getCategoryName();
    this.active = category_level0.getActive();
    this.level = category_level0.getLevel();
    this.refrence_id = category_level0.getRefrence_id();
    this.category_level1DTOS = category_level0.getCategory_level1() == null ? null : converter(category_level0.getCategory_level1());
  }

  public Category_level0DTO(String categoryName) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.level = -1;
    this.refrence_id = -1;
    this.category_level1DTOS = new ArrayList<>();
  }

  public Category_level0DTO(String categoryName, int refrence_id) {
    this.id = -1;
    this.categoryName = categoryName;
    this.active = 1;
    this.level = -1;
    this.refrence_id = refrence_id;
    this.category_level1DTOS = new ArrayList<>();
  }

  private ArrayList<Category_level1DTO> converter(ArrayList<Category_level1> category_level1s){
    ArrayList<Category_level1DTO> category_level1DTOS = new ArrayList<>();
    for(Category_level1 c : category_level1s){
      category_level1DTOS.add(new Category_level1DTO(c));
    }
    return category_level1DTOS;
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

  public ArrayList<Category_level1DTO> getCategory_level1DTOS() {
    return category_level1DTOS;
  }

  public void setCategory_level1DTOS(ArrayList<Category_level1DTO> category_level1DTOS) {
    this.category_level1DTOS = category_level1DTOS;
  }

  public int getRefrence_id() {
    return refrence_id;
  }

  public void setRefrence_id(int refrence_id) {
    this.refrence_id = refrence_id;
  }

  @Override
  public String toString() {
    return "Category_level0DTO{" +
        "id=" + id +
        ", categoryName='" + categoryName + '\'' +
        ", active=" + active +
        ", level=" + level +
        ", refrence_id=" + refrence_id +
        ", category_level1DTOS=" + category_level1DTOS +
        '}';
  }
}
