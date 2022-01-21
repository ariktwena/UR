/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Player;

/**
 *
 * @author Tweny
 */
public class PlayerDTO {

    private int id;
    private String playerName;
    private String email;

    public PlayerDTO() {
    }

    public PlayerDTO(Player player) {
        this.id = player.getId();
        this.playerName = player.getPlayerName();
        this.email = player.getEmail();
    }

    public PlayerDTO(String playerName, String email) {
        this.id = -1;
        this.playerName = playerName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PlayerDTO{" + "id=" + id + ", playerName=" + playerName + ", email=" + email + '}';
    }

}
