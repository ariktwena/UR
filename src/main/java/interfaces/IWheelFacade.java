/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import dto.CompanyDTO;
import dto.PlayerDTO;
import dto.SpinDTO;
import dto.SpinDTOsmall;
import dto.WheelDTO;
import java.util.ArrayList;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Tweny
 */
public interface IWheelFacade {

    public WheelDTO createWheel(WheelDTO wheelDTO) throws WebApplicationException;

    public ArrayList<WheelDTO> getAllWheels() throws WebApplicationException;

    public WheelDTO getWheelById(int id) throws WebApplicationException;

    public SpinDTO createSpin(PlayerDTO playerDTO, int wheelID) throws WebApplicationException;

    public ArrayList<SpinDTO> getAllSpins() throws WebApplicationException;

    public ArrayList<PlayerDTO> getAllPlayers() throws WebApplicationException;

    public ArrayList<CompanyDTO> getAllCompanies() throws WebApplicationException;

}
