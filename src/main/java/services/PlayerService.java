package services;

import entities.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

@Service
public class PlayerService {

    @PersistenceContext
    private final EntityManager manager;

    public PlayerService() {
        this.manager = Persistence.createEntityManagerFactory("jpapersist").createEntityManager();
    }

    public Player findById(Long id) {
        Player output = manager.find(Player.class, id);
        manager.detach(output);
        return output;
    }

    public List<Player> findAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Player> cq = cb.createQuery(Player.class);
        Root<Player> rootEntry = cq.from(Player.class);
        CriteriaQuery<Player> all = cq.select(rootEntry);
        TypedQuery<Player> allQuery = manager.createQuery(all);
        return allQuery.getResultList();
    }

    public void update(Player updated) {
        manager.getTransaction().begin();
        Player output = manager.find(Player.class, updated.getId());
        output.setAge(updated.getAge());
        output.setGamesOwned(updated.getGamesOwned());
        output.setUserName(updated.getUserName());
        output.setPlatforms(updated.getPlatforms());
        output.setPassword(updated.getPassword());
        output.setMoney(updated.getMoney());
        manager.getTransaction().commit();
    }

    public void create(Player player) {
        manager.getTransaction().begin();
        manager.merge(player);
        manager.getTransaction().commit();
    }

    public void delete(Player player) {
        manager.getTransaction().begin();
        manager.remove(player);
        manager.getTransaction().commit();
    }

}
