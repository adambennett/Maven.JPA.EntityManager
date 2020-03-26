package services;

import entities.*;
import org.springframework.stereotype.*;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.*;

@Service
public class GameService {

    @PersistenceContext
    private final EntityManager manager;

    public GameService() {
        this.manager = Persistence.createEntityManagerFactory("jpapersist").createEntityManager();
    }

    public Game findById(Long id) {
        Game output = manager.find(Game.class, id);
        manager.detach(output);
        return output;
    }

    public List<Game> findAll() {
        CriteriaBuilder cb = manager.getCriteriaBuilder();
        CriteriaQuery<Game> cq = cb.createQuery(Game.class);
        Root<Game> rootEntry = cq.from(Game.class);
        CriteriaQuery<Game> all = cq.select(rootEntry);
        TypedQuery<Game> allQuery = manager.createQuery(all);
        return allQuery.getResultList();
    }

    public void update(Game updated) {
        manager.getTransaction().begin();
        Game output = manager.find(Game.class, updated.getGameID());
        output.setAgeMin(updated.getAgeMin());
        output.setGenre(updated.getGenre());
        output.setRetailPrice(updated.getRetailPrice());
        output.setPlatform(updated.getPlatform());
        output.setName(updated.getName());
        manager.getTransaction().commit();
    }

    public void create(Game game) {
        manager.getTransaction().begin();
        manager.persist(game);
        manager.getTransaction().commit();
    }

    public void delete(Game game) {
        manager.getTransaction().begin();
        manager.remove(game);
        manager.getTransaction().commit();
    }
}
