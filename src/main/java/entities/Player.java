/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Tweny
 */
@Entity
@Table(name = "player")
@NamedQueries({
    @NamedQuery(name = "Player.deleteAllRows", query = "DELETE from Player"),})
public class Player implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "playerName", length = 255, nullable = false, unique = false)
    private String playerName;
    @Column(name = "email", length = 255, nullable = false, unique = false)
    private String email;

    //***************One to Many****************
    @OneToMany(mappedBy = "player", cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    private ArrayList<Spin> spins;

    public void addSpin(Spin spin) {
        if (spin != null) {
            spin.setPlayer(this);
            this.spins.add(spin);
        }
    }

    public ArrayList<Spin> getSpins() {
        return spins;
    }
    //*****************************************

    public Player() {
    }

    public Player(String playerName, String email) {
        this.playerName = playerName;
        this.email = email;
        this.spins = new ArrayList<>();
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
        return "Player{" + "id=" + id + ", playerName=" + playerName + ", email=" + email + '}';
    }

}
