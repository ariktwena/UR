/**
 * @author Arik Gaarde Nielsen Twena
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.DepartmentDTOFull;
import dto.DepartmentDTOSmall;
import dto.ProjectDTOFull;
import dto.RoleDTO;
import dto.UserDTOCreateEdit;
import dto.UserDTOFull;
import facades.ReqFacade;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;
import utils.EMF_Creator;

@Path("req")
public class ReqResource {

  private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

  private static final ReqFacade FACADE = ReqFacade.getFacade(EMF);
  private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

  @Context
  private UriInfo context;

  @Context
  SecurityContext securityContext;

  @Path("/msg")
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  public String demo() {
    return "{\"msg\":\"Hello World\"}";
  }

  //@RolesAllowed("admin")
  @Path("/departments")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String createDepartment(String department) {
    DepartmentDTOSmall departmentDTOSmall = GSON.fromJson(department, DepartmentDTOSmall.class);
    departmentDTOSmall = FACADE.createDepartment(departmentDTOSmall);
    return GSON.toJson(departmentDTOSmall);
  }

  //@RolesAllowed("admin")
  @Path("/departments/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String editDepartment(@PathParam("id") int id, String department) {
    DepartmentDTOSmall departmentDTOSmall = GSON.fromJson(department, DepartmentDTOSmall.class);
    departmentDTOSmall = FACADE.editDepartment(departmentDTOSmall, id);
    return GSON.toJson(departmentDTOSmall);
  }

  //@RolesAllowed("admin")
  @Path("/users/department/{id}")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getUsersInDepartment(@PathParam("id") int id) {
    DepartmentDTOFull departmentDTOFull = FACADE.getUsersInDepartment(id);
    return GSON.toJson(departmentDTOFull);
  }

  //@RolesAllowed("admin")
  @Path("/departments/{id}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteDepartment(@PathParam("id") int id) {
    return FACADE.deleteDepartment(id);
  }

  //@RolesAllowed("admin")
  @Path("/departments")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllDepartments() {
    ArrayList<DepartmentDTOSmall> departmentDTOSmalls = FACADE.getAllDepartments();
    return GSON.toJson(departmentDTOSmalls);
  }

  //@RolesAllowed("admin")
  @Path("/departments/{id}")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getDepatmentById(@PathParam("id") int id) {
    DepartmentDTOSmall departmentDTOSmall = FACADE.getDepratmentById(id);
    return GSON.toJson(departmentDTOSmall);
  }

  //@RolesAllowed("admin")
  @Path("/users/department/{id}")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String createUser(@PathParam("id") int id, String user) {
    UserDTOCreateEdit userDTOCreateEdit = GSON.fromJson(user, UserDTOCreateEdit.class);
    UserDTOFull userDTOFull = FACADE.createUser(userDTOCreateEdit, id);
    return GSON.toJson(userDTOFull);
  }

  //@RolesAllowed("admin")
  @Path("/users/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String editUser(@PathParam("id") int id, String user) {
    UserDTOCreateEdit userDTOCreateEdit = GSON.fromJson(user, UserDTOCreateEdit.class);
    UserDTOFull userDTOFull = FACADE.editUser(userDTOCreateEdit, id);
    return GSON.toJson(userDTOFull);
  }

  //@RolesAllowed("admin")
  @Path("/roles")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllRoles() {
    ArrayList<RoleDTO> roleDTOS = FACADE.getRoles();
    return GSON.toJson(roleDTOS);
  }

  //@RolesAllowed("admin")
  @Path("/roles/{id}")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getRoleById(@PathParam("id") int id) {
    RoleDTO roleDTO = FACADE.getRoleById(id);
    return GSON.toJson(roleDTO);
  }

  //@RolesAllowed("admin")
  @Path("/roles/user/{id}")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addRoleToUser(@PathParam("id") int id, String role) {
    RoleDTO roleDTO = GSON.fromJson(role, RoleDTO.class);
    UserDTOFull userDTOFull = FACADE.addUserRoleToUser(roleDTO, id);
    return GSON.toJson(userDTOFull);
  }

  //@RolesAllowed("admin")
  @Path("/roles/user/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String removeRoleFromUser(@PathParam("id") int id, String role) {
    RoleDTO roleDTO = GSON.fromJson(role, RoleDTO.class);
    UserDTOFull userDTOFull = FACADE.removeUserRoleFromUser(roleDTO, id);
    return GSON.toJson(userDTOFull);
  }

  //@RolesAllowed("admin")
  @Path("/roles")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String addUserRole(String role) {
    RoleDTO roleDTO = GSON.fromJson(role, RoleDTO.class);
    roleDTO = FACADE.addUserRole(roleDTO);
    return GSON.toJson(roleDTO);
  }

  //@RolesAllowed("admin")
  @Path("/roles/{id}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteUserRole(@PathParam("id") int id) {
    return GSON.toJson(FACADE.deleteUserRole(id));
  }

  //@RolesAllowed("admin")
  @Path("/users/role/{id}")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getUsersByRoleId(@PathParam("id") int id) {
    return GSON.toJson(FACADE.getUsersByRoleId(id));
  }

  //@RolesAllowed("admin")
  @Path("/users/{id}")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getUserById(@PathParam("id") int id) {
    return GSON.toJson(FACADE.getUserFullDataById(id));
  }

  //@RolesAllowed("admin")
  @Path("/users")
  @GET
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String getAllUsers() {
    return GSON.toJson(FACADE.getAllUsers());
  }

  //@RolesAllowed("admin")
  @Path("/users/{id}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String deleteUser(@PathParam("id") int id) {
    return GSON.toJson(FACADE.deleteUser(id));
  }

  //@RolesAllowed("admin")
  @Path("/users/activate/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String activateUser(@PathParam("id") int id) {
    return GSON.toJson(FACADE.activateUser(id));
  }

  //@RolesAllowed("admin")
  @Path("/projects/user/{id}")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String createProject(@PathParam("id") int id, String project) {
    ProjectDTOFull projectDTOFull = GSON.fromJson(project, ProjectDTOFull.class);
    projectDTOFull = FACADE.createProject(projectDTOFull, id);
    return GSON.toJson(projectDTOFull);
  }

  //@RolesAllowed("admin")
  @Path("/projects/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public String editProject(@PathParam("id") int id, String project) {
    ProjectDTOFull projectDTOFull = GSON.fromJson(project, ProjectDTOFull.class);
    projectDTOFull = FACADE.editProject(projectDTOFull, id);
    return GSON.toJson(projectDTOFull);
  }

}
