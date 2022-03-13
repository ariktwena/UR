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

@Entity
@Table(name = "category_level1")
@NamedQuery(name = "Category_level1.deleteAllRows", query = "DELETE from Category_level1")
public class Category_level1 implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(name = "name", length = 255, nullable = false, unique = true)
  private String categoryName;
  @Column(name = "active")
  private int active;
  @Column(name = "level")
  private int level;
  @Column(name = "refrence_id")
  private int refrence_id;
//  @Column(name = "Overall Id")
//  private int overallId;

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

  //***************Many to One****************
  @ManyToOne
  @JoinColumn(name="category_level0_id")
  private Category_level0 category_level0;

  public void setCategory_level0(Category_level0 category_level0) {
    this.category_level0 = category_level0;
  }

  public Category_level0 getCategory_level0() {
    return category_level0;
  }
  //***************************************************************


//  //***************One to Many****************
//  @OneToMany(mappedBy = "category_level0", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//  private ArrayList<Requirement> requirements;
//
//  public void addRequirement(Requirement requirement) {
//    if (requirement != null) {
//      requirement.setCategory_level0(this);
//      this.requirements.add(requirement);
//    }
//  }
//
//  public ArrayList<Requirement> getRequirement() {
//    return requirements;
//  }
//  //*****************************************

  public Category_level1() {
  }

  public Category_level1(String categoryName){
    this.active = 1;
    this.level = 1;
    this.categoryName = categoryName;
    this.project = null;
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

  //  public int getOverallId() {
//    return overallId;
//  }
//
//  public void setOverallId(int overallId) {
//    this.overallId = overallId;
//  }
}