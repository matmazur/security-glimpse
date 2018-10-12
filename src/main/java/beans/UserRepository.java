package beans;

import model.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.QueryParam;
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

    public User findUserByUsername(String string) {

        TypedQuery<User> query = entityManager.createQuery("Select u FROM User u Where u.username=?1",User.class);

        return query.setParameter(1,string).getResultList().get(0);
    }


}
