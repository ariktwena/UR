/**
 * @author Arik Gaarde Nielsen Twena
 */
package dto;

import entities.Role;

public class RoleDTO {

  private int id;
  private String roleName;
  private int active;

  public RoleDTO(Role role) {
    this.id = role.getId();
    this.roleName = role.getRoleName();
    this.active = role.getActive();
  }

  public RoleDTO(String roleName) {
    this.id = -1;
    this.roleName = roleName;
    this.active = 1;
  }

  public RoleDTO(int id, String roleName) {
    this.id = id;
    this.roleName = roleName;
    this.active = 1;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  public int getActive() {
    return active;
  }

  public void setActive(int active) {
    this.active = active;
  }

  @Override
  public String toString() {
    return "RoleDTO{" +
        "id=" + id +
        ", roleName='" + roleName + '\'' +
        ", active=" + active +
        '}';
  }
}
