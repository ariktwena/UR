/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dto.CompanyDTO;
import dto.FieldDTO;
import dto.PlayerDTO;
import dto.SpinDTO;
import dto.WheelDTO;
import entities.Company;
import entities.Field;
import entities.Player;
import entities.Spin;
import entities.Wheel;
import interfaces.IWheelFacade;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Tweny
 */
public class WheelFacade implements IWheelFacade {

    private static WheelFacade instance;
    private static EntityManagerFactory emf;

    private WheelFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static WheelFacade getFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new WheelFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public WheelDTO createWheel(WheelDTO wheelDTO) throws WebApplicationException {
        if (wheelDTO.getCompany().getCompanyName() == null || wheelDTO.getCompany().getCompanyName().equals("")) {
            throw new WebApplicationException("Company name is missing", 401);
        } else if (wheelDTO.getFields() == null || wheelDTO.getFields().isEmpty()) {
            throw new WebApplicationException("Wheel Fields are missing", 401);
        }

        Company company = new Company(wheelDTO.getCompany().getCompanyName());

        Wheel wheel = new Wheel(wheelDTO.getWheelName());

        ArrayList<FieldDTO> fieldDTOs = wheelDTO.getFields();

        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();

            for (FieldDTO fieldDTO : fieldDTOs) {
                Field field = new Field(fieldDTO.getPrizeName(), fieldDTO.getPrizeValue());
                wheel.addField(field);
            }

            em.persist(wheel);

            company.addWheel(wheel);
            em.persist(company);

            em.getTransaction().commit();
            return new WheelDTO(wheel);
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<WheelDTO> getAllWheels() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Wheel> query = em.createQuery("SELECT w FROM Wheel w", Wheel.class);
            List<Wheel> wheels = query.getResultList();
            ArrayList<WheelDTO> wheelDTOs = new ArrayList<>();
            for (Wheel w : wheels) {
                wheelDTOs.add(new WheelDTO(w));
            }
            return wheelDTOs;
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }

    @Override
    public WheelDTO getWheelById(int id) throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        try {
            Wheel wheel = em.find(Wheel.class, id);
            return new WheelDTO(wheel);
        } catch (RuntimeException ex) {
            throw new WebApplicationException("No Wheel with id: " + id + " exists", 404);
        } finally {
            em.close();
        }
    }

    @Override
    public SpinDTO createSpin(PlayerDTO playerDTO, int wheelID) throws WebApplicationException {
        if (playerDTO.getPlayerName() == null || playerDTO.getPlayerName().equals("")) {
            throw new WebApplicationException("Player name is missing", 401);
        }

        EntityManager em = emf.createEntityManager();

        Wheel wheel = em.find(Wheel.class, wheelID);

        Player player = getPlayerByName(playerDTO.getPlayerName(), playerDTO.getEmail());

        try {
            em.getTransaction().begin();
            Spin spin = new Spin(wheel.getFields().size());
            spin.setResultName(wheel.getFields());
            spin.setResultValue(wheel.getFields());
            spin.setPlayer(player);
            spin.setWheel(wheel);
            em.persist(spin);
            em.getTransaction().commit();
            return new SpinDTO(spin);
        } catch (NoResultException ex) {
            throw new WebApplicationException("No Wheel with id: " + wheelID + " exists", 404);
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<SpinDTO> getAllSpins() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Spin> query = em.createQuery("SELECT s FROM Spin s JOIN s.player p", Spin.class);
            List<Spin> spins = query.getResultList();
            ArrayList<SpinDTO> spinDTOs = new ArrayList<>();
            for (Spin s : spins) {
                spinDTOs.add(new SpinDTO(s));
            }
            return spinDTOs;
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<PlayerDTO> getAllPlayers() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Player> query = em.createQuery("SELECT p FROM Player p", Player.class);
            List<Player> players = query.getResultList();
            ArrayList<PlayerDTO> playerDTOs = new ArrayList<>();
            for (Player p : players) {
                playerDTOs.add(new PlayerDTO(p));
            }
            return playerDTOs;
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }

    @Override
    public ArrayList<CompanyDTO> getAllCompanies() throws WebApplicationException {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Company> query = em.createQuery("SELECT c FROM Company c", Company.class);
            List<Company> companys = query.getResultList();
            ArrayList<CompanyDTO> companyDTOs = new ArrayList<>();
            for (Company c : companys) {
                companyDTOs.add(new CompanyDTO(c));
            }
            return companyDTOs;
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }

    private Player getPlayerByName(String name, String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Player p WHERE p.playerName = :name ", Player.class);
            query.setParameter("name", name);
            Player player = (Player) query.getSingleResult();
            return player;
        } catch (NoResultException ex) {
            em.getTransaction().begin();
            Player player = new Player(name, email);
            em.persist(player);
            em.getTransaction().commit();
            return player;
        } catch (RuntimeException ex) {
            throw new WebApplicationException("Internal Server Problem. We are sorry for the inconvenience", 500);
        } finally {
            em.close();
        }
    }
}
