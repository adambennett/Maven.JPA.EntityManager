package entities;

import javax.persistence.*;
import java.util.*;

@Entity
public class Game {

    @Id
    private Long gameID;

    @ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.REMOVE})
    @MapsId
    private Player owner;

    private String name;
    private String genre;
    private String platform;
    private Integer ageMin;
    private Integer retailPrice;

    public Game() {}

    public Long getGameID() {
        return gameID;
    }

    public void setGameID(Long gameID) {
        this.gameID = gameID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Integer getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(Integer ageMin) {
        this.ageMin = ageMin;
    }

    public Integer getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(Integer retailPrice) {
        this.retailPrice = retailPrice;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Game)) return false;
        Game game = (Game) o;
        return Objects.equals(getGameID(), game.getGameID()) &&
                Objects.equals(getOwner(), game.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameID(), getOwner());
    }
}
