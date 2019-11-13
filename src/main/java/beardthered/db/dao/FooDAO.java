package beardthered.db.dao;

import beardthered.db.model.Foo;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FooDAO
{
    @PersistenceContext
    private EntityManager entityManager;

    public List<Foo> findAll() {
        return entityManager
                .createQuery("from " + Foo.class.getName()).getResultList();
    }
}
