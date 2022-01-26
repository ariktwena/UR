package interfaces;

import dto.DepartmentDTOFull;
import dto.DepartmentDTOSmall;
import dto.ProjectDTOFull;
import dto.RoleDTO;
import dto.UserDTOCreateEdit;
import dto.UserDTOFull;
import dto.UserDTOFullProject;
import dto.UserDTOSmall;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

public interface IReqFacade {

  public DepartmentDTOSmall createDepartment(DepartmentDTOSmall departmentDTOSmall)
      throws WebApplicationException;

  public DepartmentDTOSmall editDepartment(DepartmentDTOSmall departmentDTOSmall, int departmentId)
      throws WebApplicationException;

  public DepartmentDTOSmall getDepratmentById(int departmentId) throws WebApplicationException;

  public DepartmentDTOFull getUsersInDepartment(int departmentId) throws WebApplicationException;

  public ArrayList<DepartmentDTOSmall> getAllDepartments() throws WebApplicationException;

  public String deleteDepartment(int departmentId) throws WebApplicationException;

  public UserDTOFull createUser(UserDTOCreateEdit userDTOCreateEdit, int departmentId)
      throws WebApplicationException;

  public UserDTOFull editUser(UserDTOCreateEdit userDTOCreateEdit, int userId)
      throws WebApplicationException;

  public ArrayList<RoleDTO> getRoles() throws WebApplicationException;

  public UserDTOFull addUserRoleToUser(RoleDTO roleDTO, int userID) throws WebApplicationException;

  public UserDTOFull removeUserRoleFromUser(RoleDTO roleDTO, int userID) throws WebApplicationException;

  public RoleDTO addUserRole(RoleDTO roleDTO) throws WebApplicationException;

  public String deleteUserRole(int roleId) throws WebApplicationException;

  public RoleDTO getRoleById(int roleId) throws WebApplicationException;

  public ArrayList<UserDTOFull> getUsersByRoleId(int roleID) throws WebApplicationException;

  public UserDTOFullProject getUserFullDataById(int userId) throws WebApplicationException;

  public ArrayList<UserDTOFull> getAllUsers() throws WebApplicationException;

  public String deleteUser(int userId) throws WebApplicationException;

  public UserDTOFull activateUser(int userId) throws WebApplicationException;

  public ProjectDTOFull createProject(ProjectDTOFull projectDTOFull, int userId) throws WebApplicationException;

  public ProjectDTOFull editProject(ProjectDTOFull projectDTOFull, int projectId)
      throws WebApplicationException;

  //All projects

  //Project by id

  //Project by user id

  //Add project to user

  //Remove project from user

  //Activate project

  public String deleteProject(int projectId) throws WebApplicationException;


}
