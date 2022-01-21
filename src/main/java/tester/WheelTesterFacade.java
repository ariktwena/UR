/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tester;

import dto.CompanyDTO;
import dto.FieldDTO;
import dto.PlayerDTO;
import dto.SpinDTO;
import dto.SpinDTOsmall;
import dto.WheelDTO;
import facades.WheelFacade;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author Tweny
 */
public class WheelTesterFacade {
    public static void main(String[] args) {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        WheelFacade FACADE = WheelFacade.getFacade(emf);
        
        FieldDTO f1 = new FieldDTO("Car", 200);
        FieldDTO f2 = new FieldDTO("Boat", 400);
        FieldDTO f3 = new FieldDTO("Jepp", 600);
        FieldDTO f4 = new FieldDTO("Chopper", 800);
        FieldDTO f5 = new FieldDTO("Bike", 1000);
        
        WheelDTO wheelDto = new WheelDTO("test_wheel");
        wheelDto.getFields().add(f1);
        wheelDto.getFields().add(f2);
        wheelDto.getFields().add(f3);
        wheelDto.getFields().add(f4);
        wheelDto.getFields().add(f5);
        
        CompanyDTO companyDTO = new CompanyDTO("test_company");
        wheelDto.setCompany(companyDTO);
        
        System.out.println(wheelDto);
        
        wheelDto = FACADE.createWheel(wheelDto);
        System.err.println(wheelDto);
        System.out.println("-----");
        
        PlayerDTO playerDTO = new PlayerDTO("Bob", "test@test.dk");
        SpinDTO spinDTO = FACADE.createSpin(playerDTO, wheelDto.getId());
//        System.out.println(spinDTO);
        
        ArrayList<SpinDTO> spinDTOs = FACADE.getAllSpins();
        for(SpinDTO s : spinDTOs){
            System.out.println(s);
        }
    }
    
}
