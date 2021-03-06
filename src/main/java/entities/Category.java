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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "categories")
@NamedQuery(name = "Category.deleteAllRows", query = "DELETE from Category")
public class Category implements Serializable {

  private static final long serialVersionUID = 1L;


  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private int id;
  @Column(name = "name", length = 255, nullable = false, unique = true)
  private String categoryName;
  @Column(name = "active")
  private int active;
  @Column(name = "category_level")
  private int category_level;
  @Column(name = "refrence_id")
  private int refrence_id;

  //***************Many to One****************
  @ManyToOne
  @JoinColumn(name="project_id")
  private Project project;

  public void setProject(Project project) {
    this.project = project;
  }

  public Project getProject() {
    return project;
  }
  //***************************************************************


//  //***************One to Many****************
//  @OneToMany(mappedBy = "category", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//  private ArrayList<Requirement> requirements;
//
//  public void addRequirement(Requirement requirement) {
//    if (requirement != null) {
//      requirement.setCategory(this);
//      this.requirements.add(requirement);
//    }
//  }
//
//  public ArrayList<Requirement> getRequirement() {
//    return requirements;
//  }
//  //*****************************************

  public Category() {
  }

  public Category(String categoryName, int category_level) {
    this.categoryName = categoryName;
    this.project = null;
    this.active = 1;
//    this.requirements = new ArrayList<>();
    this.category_level = category_level;
    this.refrence_id = -1;
  }

  public Category(String categoryName) {
    this.categoryName = categoryName;
    this.project = null;
    this.active = 1;
//    this.requirements = new ArrayList<>();
    this.category_level = -1;
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