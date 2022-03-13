package entities;

import java.beans.Transient;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "requirement")
@NamedQuery(name = "Requirement.deleteAllRows", query = "DELETE from Requirement")
public class Requirement implements Serializable {

  public enum Status {
    Approved,
    Review,
    Pending,
    Completed
  }

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "req_id")
  private int id;
  @Column(name = "created")
  private LocalDate created;
  @Column(name = "description")
  private String description;
  @Column(name = "req_dependency_id")
  private int req_dependency_id;
  @Column(name = "edited")
  private LocalDate edited;
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  private Status status;
  @Column(name = "active")
  private int active;


  //***************Many to One****************
  @ManyToOne
  @JoinColumn(name="category_id")
  private Category_level0 category_level0;

  public void setCategory_level0(Category_level0 category_level0) {
    this.category_level0 = category_level0;
  }

  public Category_level0 getCategory_level0() {
    return category_level0;
  }
  //***************************************************************

  //***************Many to One****************
  @ManyToOne
  @JoinColumn(name="author_id")
  private User author;

  public void setAuthor(User author) {
    this.author = author;
  }

  public User getAuthor() {
    return author;
  }
  //***************************************************************

  //***************Many to One****************
  @ManyToOne
  @JoinColumn(name="editor_id")
  private User editor;

  public void setEditor(User editor) {
    this.editor = editor;
  }

  public User getEditor() {
    return editor;
  }
  //***************************************************************

//  //***************One to Many****************
//  @OneToMany(mappedBy = "requirements", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
//  private ArrayList<Sub_Requirement> sub_requirements;
//
//  public void addRSubequirement(Sub_Requirement sub_requirement) {
//    if (sub_requirement != null) {
//      sub_requirement.setRequirement(this);
//      this.sub_requirements.add(sub_requirement);
//    }
//  }
//
//  public ArrayList<Sub_Requirement> getSubRequirement() {
//    return sub_requirements;
//  }
//  //*****************************************


  /* Variables here */

  public Requirement() {
  }

  public Requirement(String description) {
//    this.created = LocalDate.now();
    this.created = LocalDate.now();
//    this.created = LocalDate.parse(LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    this.description = description;
    this.edited = null;
    this.status = Status.Pending;
    this.active = 1;
    this.category_level0 = null;
    this.author = null;
    this.editor = null;
    this.req_dependency_id = 0;
//    this.sub_requirements = new ArrayList<>();
  }

  /* Constructor here */

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

  public LocalDate getEdited() {
    return edited;
  }

  public void setEdited(LocalDate edited) {
    this.edited = edited;
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

//  public ArrayList<Sub_Requirement> getSub_requirements() {
//    return sub_requirements;
//  }
//
//  public void setSub_requirements(ArrayList<Sub_Requirement> sub_requirements) {
//    this.sub_requirements = sub_requirements;
//  }


  public int getDepended_on_id() {
    return req_dependency_id;
  }

  public void setDepended_on_id(int req_dependency_id) {
    this.req_dependency_id = req_dependency_id;
  }
}