/**
 * @author Arik Gaarde Nielsen Twena
 */
package facades;

import dto.DepartmentDTOFull;
import dto.DepartmentDTOSmall;
import dto.ProjectDTOFull;
import dto.RoleDTO;
import dto.UserDTOCreateEdit;
import dto.UserDTOFull;
import dto.UserDTOFullProject;
import entities.Department;
import entities.Project;
import entities.Role;
import entities.User;
import interfaces.IReqFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

public class ReqFacade implements IReqFacade {

  private static ReqFacade instance;
  private static EntityManagerFactory emf;

  private ReqFacade() {
  }

  /**
   * @param _emf
   * @return an instance of this facade class.
   */
  public static ReqFacade getFacade(EntityManagerFactory _emf) {
    if (instance == null) {
      emf = _emf;
      instance = new ReqFacade();
    }
    return instance;
  }

  private EntityManager getEntityManager() {
    return emf.createEntityManager();
  }


  @Override
  public DepartmentDTOSmall createDepartment(DepartmentDTOSmall departmentDTOSmall)
      throws WebApplicationException {
    if (departmentDTOSmall.getName() == null || departmentDTOSmall.getName().equals("")) {
      throw new WebApplicationException("Department name is missing", 401);
    }

    Department department = checkDepartmentNameDB(departmentDTOSmall);

    return new DepartmentDTOSmall(department);

  }

  @Override
  public DepartmentDTOSmall editDepartment(DepartmentDTOSmall departmentDTOSmall, int departmentId)
      throws WebApplicationException {
    if (departmentDTOSmall.getName() == null || departmentDTOSmall.getName().equals("")) {
      throw new WebApplicationException("Department name is missing", 401);
    }

    EntityManager em = emf.createEntityManager();
    try {
      Department department = em.find(Department.class, departmentId);
      department.setDepartmentName(departmentDTOSmall.getName());
      em.getTransaction().begin();
      em.merge(department);
      em.getTransaction().commit();
      return new DepartmentDTOSmall(department);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No Department with id: " + departmentId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public DepartmentDTOSmall getDepratmentById(int departmentId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      Department department = em.find(Department.class, departmentId);
      return new DepartmentDTOSmall(department);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No Role with id: " + departmentId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public DepartmentDTOFull getUsersInDepartment(int departmentId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      Department department = em.find(Department.class, departmentId);
      return new DepartmentDTOFull(department);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No Department with id: " + departmentId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public ArrayList<DepartmentDTOSmall> getAllDepartments() throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<Department> query = em.createQuery("SELECT d FROM Department d", Department.class);
      List<Department> departments = query.getResultList();
      ArrayList<DepartmentDTOSmall> departmentDTOSmalls = new ArrayList<>();
      for (Department d : departments) {
        departmentDTOSmalls.add(new DepartmentDTOSmall(d));
      }
      return departmentDTOSmalls;
    } catch (RuntimeException ex) {
      throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
    } finally {
      em.close();
    }
  }

  @Override
  public String deleteDepartment(int departmentId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      Department department = em.find(Department.class, departmentId);

      TypedQuery<User> query = em.createQuery("SELECT u FROM User u JOIN u.department d WHERE d.id = :id", User.class);
      query.setParameter("id", departmentId);
      List<User> users = query.getResultList();
      System.out.println(users.size());
      em.getTransaction().begin();
      for(User u : users){
        department.removeUser(u);
        u.setDepartment(null);
      }
      em.merge(department);
      department.setActive(0);
      em.merge(department);
      em.getTransaction().commit();
      return "{\"message\":\"Department deleted!\"}";
    } catch (NoResultException ex) {
      throw new WebApplicationException("No Department with id: " + departmentId + " exists", 404);
    } finally {
      em.close();
    }
  }


  @Override
  public UserDTOFull createUser(UserDTOCreateEdit userDTOCreateEdit, int departmentId)
      throws WebApplicationException {
    if (userDTOCreateEdit.getUsername() == null || userDTOCreateEdit.getUsername().equals("")) {
      throw new WebApplicationException("Username is missing", 401);
    } else if (userDTOCreateEdit.getPassword() == null || userDTOCreateEdit.getPassword().equals("")) {
      throw new WebApplicationException("Password is missing", 401);
    }

    User user = checkUsernameDB(userDTOCreateEdit);

    Role role = findUserRole("user");

    EntityManager em = emf.createEntityManager();

    try {
      Department department = em.find(Department.class, departmentId);
      if(user != null && department != null){
        department.addUser(user);
        em.getTransaction().begin();
        em.merge(department);
        user.addRole(role);
        em.merge(user);
        em.getTransaction().commit();
        return new UserDTOFull(user);
      } else{
        throw new WebApplicationException("User created but no Department with id: " + departmentId + " exists", 401);
      }

    } catch (NoResultException ex) {
      throw new WebApplicationException("No Department with id: " + departmentId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public UserDTOFull editUser(UserDTOCreateEdit userDTOCreateEdit, int userId)
      throws WebApplicationException {
    if (userDTOCreateEdit.getFirstName() == null || userDTOCreateEdit.getFirstName().equals("")) {
      throw new WebApplicationException("First name is missing", 401);
    } else if (userDTOCreateEdit.getLastName() == null || userDTOCreateEdit.getLastName().equals("")) {
      throw new WebApplicationException("Last name is missing", 401);
    } else if (userDTOCreateEdit.getPassword() == null || userDTOCreateEdit.getPassword().equals("")) {
      throw new WebApplicationException("Password is missing", 401);
    }

    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userId);
      user.setFirstName(userDTOCreateEdit.getFirstName());
      user.setLastName(userDTOCreateEdit.getLastName());
      user.setUserSalt();
      user.setUserPass(userDTOCreateEdit.getPassword());
      em.getTransaction().begin();
      em.merge(user);
      em.getTransaction().commit();
      return new UserDTOFull(user);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No user with id: " + userId + " exists", 404);
    } finally {
      em.close();
    }

  }

  @Override
  public ArrayList<RoleDTO> getRoles() throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<Role> query = em.createQuery("SELECT r FROM Role r", Role.class);
      List<Role> roles = query.getResultList();
      ArrayList<RoleDTO> roleDTOS = new ArrayList<>();
      for (Role r : roles) {
        roleDTOS.add(new RoleDTO(r));
      }
      return roleDTOS;
    } catch (RuntimeException ex) {
      throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
    } finally {
      em.close();
    }
  }

  @Override
  public UserDTOFull addUserRoleToUser(RoleDTO roleDTO, int userID) throws WebApplicationException {
    if (roleDTO.getRoleName() == null || roleDTO.getRoleName().equals("")) {
      throw new WebApplicationException("Role name is missing", 401);
    }
    Role role = findUserRole(roleDTO.getRoleName());
    role.setActive(1);
    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userID);
      user.addRole(role);
      em.getTransaction().begin();
      em.merge(role);
      em.merge(user);
      em.getTransaction().commit();
      return new UserDTOFull(user);
    } catch (NoResultException ex) {
      throw new WebApplicationException("No User with id: " + userID + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public UserDTOFull removeUserRoleFromUser(RoleDTO roleDTO, int userID)
      throws WebApplicationException {
    if (roleDTO.getRoleName() == null || roleDTO.getRoleName().equals("")) {
      throw new WebApplicationException("Role name is missing", 401);
    }
    Role role = findUserRole(roleDTO.getRoleName());
    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userID);
      user.removeRole(role);
      em.getTransaction().begin();
      em.merge(user);
      em.getTransaction().commit();
      return new UserDTOFull(user);
    } catch (NoResultException ex) {
      throw new WebApplicationException("No User with id: " + userID + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public RoleDTO addUserRole(RoleDTO roleDTO) throws WebApplicationException {
    if (roleDTO.getRoleName() == null || roleDTO.getRoleName().equals("")) {
      throw new WebApplicationException("Role name is missing", 401);
    }

    EntityManager em = emf.createEntityManager();
    try {
      Query query = em.createQuery("SELECT r FROM Role r WHERE r.roleName = :name ", Role.class);
      query.setParameter("name", roleDTO.getRoleName());
      Role role = (Role) query.getSingleResult();
      throw new WebApplicationException("Role '" + roleDTO.getRoleName() + "' already exists", 401);
    } catch (NoResultException ex) {
      Role role = new Role(roleDTO.getRoleName());
      em.getTransaction().begin();
      em.persist(role);
      em.getTransaction().commit();
      return new RoleDTO(role);
    } finally {
      em.close();
    }
  }

  @Override
  public String deleteUserRole(int roleId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      Role role = em.find(Role.class, roleId);
      RoleDTO roleDTO = new RoleDTO(role);
      for(User user : role.getUserList()){
        removeUserRoleFromUser(roleDTO, user.getId());
      }
      deactivateRole(roleId);
      return "{\"message\":\"Role deleted!\"}";
    } catch (NoResultException ex) {
      throw new WebApplicationException("Role id: " + roleId + " does not exists", 401);
    } finally {
      em.close();
    }
  }

  @Override
  public RoleDTO getRoleById(int roleId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      Role role = em.find(Role.class, roleId);
      return new RoleDTO(role);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No Role with id: " + roleId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public ArrayList<UserDTOFull> getUsersByRoleId(int roleID) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<User> query = em.createQuery("SELECT u FROM User u JOIN u.roleList r WHERE r.id = :id", User.class);
      query.setParameter("id", roleID);
      List<User> users = query.getResultList();
      ArrayList<UserDTOFull> userDTOFulls = new ArrayList<>();
      for(User u : users){
        userDTOFulls.add(new UserDTOFull(u));
      }
      return userDTOFulls;
    } catch (RuntimeException ex) {
      throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
    } finally {
      em.close();
    }
  }

  @Override
  public UserDTOFullProject getUserFullDataById(int userId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userId);
      return new UserDTOFullProject(user);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No User with id: " + userId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public ArrayList<UserDTOFull> getAllUsers() throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      TypedQuery<User> query = em.createQuery("SELECT u FROM User u", User.class);
      List<User> users = query.getResultList();
      ArrayList<UserDTOFull> userDTOFulls = new ArrayList<>();
      for(User u : users){
        userDTOFulls.add(new UserDTOFull(u));
      }
      return userDTOFulls;
    } catch (RuntimeException ex) {
      throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
    } finally {
      em.close();
    }
  }

  @Override
  public String deleteUser(int userId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userId);
      for(Role role : user.getRoleList()){
        removeUserRoleFromUser(new RoleDTO(role), user.getId());
      }
      deactivateUser(userId);
      return "{\"message\":\"User deleted!\"}";
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No User with id: " + userId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public UserDTOFull activateUser(int userId) throws WebApplicationException {
    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userId);
      user.setActive(1);
      return new UserDTOFull(user);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No User with id: " + userId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public ProjectDTOFull createProject(ProjectDTOFull projectDTOFull, int userId)
      throws WebApplicationException {
    if (projectDTOFull.getProjectName() == null || projectDTOFull.getProjectName().equals("")) {
      throw new WebApplicationException("Project name is missing", 401);
    }

    Project project = findOrCreateProjectInDB(projectDTOFull);

    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userId);
      project.setUser(user);
      em.getTransaction().begin();
      em.merge(project);
      em.getTransaction().commit();
      return new ProjectDTOFull(project);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No User with id: " + userId + " exists", 404);
    } finally {
      em.close();
    }
  }

  @Override
  public ProjectDTOFull editProject(ProjectDTOFull projectDTOFull, int projectId)
      throws WebApplicationException {
    if (projectDTOFull.getProjectName() == null || projectDTOFull.getProjectName().equals("")) {
      throw new WebApplicationException("Project name is missing", 401);
    }
    EntityManager em = emf.createEntityManager();
    try {
      Project project = em.find(Project.class, projectId);
      project.setProjectName(projectDTOFull.getProjectName());
      User user = em.find(User.class, projectDTOFull.getUser().getId());
      project.setUser(user);
      em.getTransaction().begin();
      em.merge(project);
      em.getTransaction().commit();
      return new ProjectDTOFull(project);
    } catch (RuntimeException ex) {
      throw new WebApplicationException("No User with id: " + projectId + " exists", 404);
    } finally {
      em.close();
    }


  }

  @Override
  public String deleteProject(int projectId) throws WebApplicationException {
    return null;
  }

  private Department checkDepartmentNameDB(DepartmentDTOSmall departmentDTOSmall){
    EntityManager em = emf.createEntityManager();
    try {
      Query query = em.createQuery("SELECT d FROM Department d WHERE d.departmentName = :name ", Department.class);
      query.setParameter("name", departmentDTOSmall.getName());
      Department department = (Department) query.getSingleResult();
      return department;
    } catch (NoResultException ex) {
      em.getTransaction().begin();
      Department department = new Department(departmentDTOSmall.getName());
      em.persist(department);
      em.getTransaction().commit();
      return department;
    } catch (RuntimeException ex) {
      throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
    } finally {
      em.close();
    }
  }

  private Role findUserRole(String rolenName) {
    EntityManager em = emf.createEntityManager();
    try {
      Query query = em.createQuery("SELECT r FROM Role r WHERE r.roleName = :name ", Role.class);
      query.setParameter("name", rolenName);
      Role role = (Role) query.getSingleResult();
      return role;
    } catch (NoResultException ex) {
      throw new WebApplicationException("Role '" + rolenName + "' does not exists", 401);
    } finally {
      em.close();
    }
  }

  private User checkUsernameDB(UserDTOCreateEdit userDTOCreateEdit){
    EntityManager em = emf.createEntityManager();
    try {
      Query query = em.createQuery("SELECT u FROM User u WHERE u.userName = :name ", User.class);
      query.setParameter("name", userDTOCreateEdit.getUsername());
      User user = (User) query.getSingleResult();
      if(user.getId() > -1){
        throw new WebApplicationException("User already exists", 401);
      }
      return null;
    } catch (NoResultException ex) {
      em.getTransaction().begin();
      User user = new User(userDTOCreateEdit.getFirstName(), userDTOCreateEdit.getLastName(), userDTOCreateEdit.getUsername(), userDTOCreateEdit.getPassword());
      em.persist(user);
      em.getTransaction().commit();
      return user;
    } finally {
      em.close();
    }
  }

  private void deactivateRole(int roleId){
    EntityManager em = emf.createEntityManager();
    try {
      Role role = em.find(Role.class, roleId);
      em.getTransaction().begin();
      role.setActive(0);
      em.merge(role);
      em.getTransaction().commit();
    } catch (NoResultException ex) {
      throw new WebApplicationException("Role id: " + roleId + " does not exists", 401);
    } finally {
      em.close();
    }
  }

  private void deactivateUser(int userId){
    EntityManager em = emf.createEntityManager();
    try {
      User user = em.find(User.class, userId);
      em.getTransaction().begin();
      user.setActive(0);
      em.merge(user);
      em.getTransaction().commit();
    } catch (NoResultException ex) {
      throw new WebApplicationException("Role id: " + userId + " does not exists", 401);
    } finally {
      em.close();
    }
  }

  private Project findOrCreateProjectInDB(ProjectDTOFull projectDTOFull) {
    EntityManager em = emf.createEntityManager();
    try {
      Query query = em.createQuery("SELECT p FROM Project p WHERE p.projectName = :name ", Project.class);
      query.setParameter("name", projectDTOFull.getProjectName());
      User user = (User) query.getSingleResult();
      if(user.getId() > -1){
        throw new WebApplicationException("Project already exists", 401);
      }
      return null;
    } catch (NoResultException ex) {
      em.getTransaction().begin();
      Project project = new Project(projectDTOFull.getProjectName());
      em.persist(project);
      em.getTransaction().commit();
      return project;
    } finally {
      em.close();
    }
  }
}