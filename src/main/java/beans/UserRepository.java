package beans;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class UserRepository {

    @PersistenceContext
    EntityManager entityManager;

    public void add(User user) {
        entityManager.persist(user);
    }

    public List<User> findAll() {
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createQuery("Select u FROM User u");

        return query.getResultList();
    }
}
