package ci.net.demo1.models.repos;


import java.sql.SQLException;
import java.util.List;

public interface Repo<T>{
    void create(T t) throws SQLException;

    T getById(Long id);

    List<T> getAll();

    boolean delete(T t) throws SQLException;

    void update(T t) throws SQLException;
}

