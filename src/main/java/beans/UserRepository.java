package beans;

import model.User;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@RequestScoped
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }
}
