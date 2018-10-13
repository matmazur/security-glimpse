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
        TypedQuery<User> query = entityManager.createQuery("Select u FROM User u", User.class);

        return query.getResultList();
    }
    public List<User> findUserByUsername(String string) {

        TypedQuery<User> query = entityManager.createQuery("Select u FROM User u Where u.username=?1", User.class);

        return query.setParameter(1, string).getResultList();
    }
}
