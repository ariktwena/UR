package entities;

import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
@NamedQuery(name = "Project.deleteAllRows", query = "DELETE from Project")
public class Project implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name", length = 255, nullable = false, unique = true)
  private String projectName;
  @Column(name = "active")
  private int active;

  //***************Many to One****************
  @ManyToOne
  private User user;

  public void setUser(User user) {
    this.user = user;
  }

  public User getUser() {
    return user;
  }
  //***************************************************************

  //***************One to Many****************
  @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ArrayList<Category> categories;

  public void addCategory(Category category) {
    if (category != null) {
      category.setProject(this);
      this.categories.add(category);
    }
  }

  public ArrayList<Category> getCategories() {
    return categories;
  }
  //*****************************************

  //***************One to Many****************
  @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ArrayList<Category_level0> category_level0s;

  public void addCategory_level0(Category_level0 category_level0) {
    if (category_level0 != null) {
      category_level0.setProject(this);
      this.category_level0s.add(category_level0);
    }
  }

  public ArrayList<Category_level0> getCategories_level0() {
    return category_level0s;
  }
  //*****************************************

  //***************One to Many****************
  @OneToMany(mappedBy = "project", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
  private ArrayList<Category_level1> category_level1s;

  public void addCategory_level1(Category_level1 category_level1) {
    if (category_level1 != null) {
      category_level1.setProject(this);
      this.category_level1s.add(category_level1);
    }
  }

  public ArrayList<Category_level1> getCategories_level1() {
    return category_level1s;
  }
  //*****************************************

  public Project() {
  }

  public Project(String projectName) {
    this.projectName = projectName;
    this.user = null;
    this.active = 1;
    this.categories = new ArrayList<>();
    this.category_level0s = new ArrayList<>();
    this.category_level1s = new ArrayList<>();
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
}