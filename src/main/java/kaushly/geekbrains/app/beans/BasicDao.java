package kaushly.geekbrains.app.beans;

import org.hibernate.Session;

import javax.annotation.PostConstruct;
import javax.persistence.NoResultException;
import java.util.List;

public abstract class BasicDao<T> {
    protected Class cls;

    private ShopSessionsFactory factory;

    public BasicDao(ShopSessionsFactory factory) {
        this.factory = factory;
    }

    @PostConstruct
    public abstract void init();

    public T findById(long id, Session session) {
        T item = (T) session.get(cls, id);
        if (item == null) {
            throw new RuntimeException(cls.getSimpleName() + " not found");
        } else {
            return item;
        }
    }

    public List<T> findAll(Session session) {
        List<T> items = session.createQuery(String.format("FROM %s",cls.getSimpleName()), cls).getResultList();
        if (items == null) {
            throw new RuntimeException(cls.getSimpleName() + " not found");
        } else {
            return items;
        }
    }


}
