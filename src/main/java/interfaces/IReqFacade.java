package interfaces;

import dto.CategoryDTOFull;
import dto.CategoryDTOSmall;
import dto.Category_level0DTO;
import dto.DepartmentDTOFull;
import dto.DepartmentDTOSmall;
import dto.ProjectDTOFull;
import dto.RequirementDTOFull;
import dto.RequirementDTOSmall;
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

  public UserDTOFull removeUserRoleFromUser(RoleDTO roleDTO, int userID)
      throws WebApplicationException;

  public RoleDTO addUserRole(RoleDTO roleDTO) throws WebApplicationException;

  public String deleteUserRole(int roleId) throws WebApplicationException;

  public RoleDTO getRoleById(int roleId) throws WebApplicationException;

  public ArrayList<UserDTOFull> getUsersByRoleId(int roleID) throws WebApplicationException;

  public UserDTOFullProject getUserFullDataById(int userId) throws WebApplicationException;

  public ArrayList<UserDTOFull> getAllUsers() throws WebApplicationException;

  public String deleteUser(int userId) throws WebApplicationException;

  public UserDTOFull activateUser(int userId) throws WebApplicationException;

  public ProjectDTOFull createProject(ProjectDTOFull projectDTOFull, int userId)
      throws WebApplicationException;

  public ProjectDTOFull editProject(ProjectDTOFull projectDTOFull, int projectId)
      throws WebApplicationException;

  public ArrayList<ProjectDTOFull> getAllProject() throws WebApplicationException;

  public ProjectDTOFull getProjectById(int projectId) throws WebApplicationException;

  public ArrayList<ProjectDTOFull> getProjectByUserId(int userId) throws WebApplicationException;

  public ProjectDTOFull addProjectToUser(int projectId, int userId) throws WebApplicationException;

  public String removeProjectFromUser(int projectId) throws WebApplicationException;

  public ProjectDTOFull activateProject(int projectId) throws WebApplicationException;

  public String deleteProject(int projectId) throws WebApplicationException;



  public Category_level0DTO createCategoryLevel0(CategoryDTOSmall categoryDTOSmall, int projectId)
      throws WebApplicationException;

  public CategoryDTOSmall createNestedCategory(CategoryDTOSmall categoryDTOSmall, int nestedCategoryId)
      throws WebApplicationException;

//  public CategoryDTOSmall editCategory(CategoryDTOSmall categoryDTOSmall, int categoryId)
//      throws WebApplicationException;

//  public ArrayList<CategoryDTOFull> getAllCategories() throws WebApplicationException;

//  public CategoryDTOFull getCategoryById(int categoryId) throws WebApplicationException;

//  public ArrayList<CategoryDTOSmall> getCategoryByProjectId(int projectId) throws WebApplicationException;

//  public ArrayList<CategoryDTOSmall> getCategoryByCategoryId(int categoryId) throws WebApplicationException;

  //Add to project

  //Remove from project

  //Activate

  //Delete






  public ArrayList<RequirementDTOSmall> getAllRequirements() throws WebApplicationException;

  public RequirementDTOFull getRequirementById(int req_id) throws WebApplicationException;

  public ArrayList<RequirementDTOFull> getNestedRequirements(int req_id) throws WebApplicationException;


}
