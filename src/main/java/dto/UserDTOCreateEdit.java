package dto;

import entities.User;

public class UserDTOCreateEdit {

  private int id;
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;

  public UserDTOCreateEdit() {
  }

  public UserDTOCreateEdit(User user) {
    this.id = user.getId();
    this.username = user.getUserName();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.password = user.getUserPass();
    this.email = user.getEmail();
  }

  public UserDTOCreateEdit(int id, String username, String firstName, String lastName, String email,
      String password) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public UserDTOCreateEdit(int id, String username, String firstName, String lastName,
      String password) {
    this.id = id;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }

  public UserDTOCreateEdit(String username, String firstName, String lastName,
      String password) {
    this.id = -1;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
  }

  public UserDTOCreateEdit(String username, String firstName, String lastName, String email,
      String password) {
    this.id = -1;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.password = password;
  }

  public UserDTOCreateEdit(String username, String password) {
    this.id = -1;
    this.username = username;
    this.firstName = "";
    this.lastName = "";
    this.password = password;
  }

  public UserDTOCreateEdit(int id, String username, String password) {
    this.id = id;
    this.username = username;
    this.firstName = "";
    this.lastName = "";
    this.password = password;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return "UserDTOCreateEdit{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", email='" + email + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
