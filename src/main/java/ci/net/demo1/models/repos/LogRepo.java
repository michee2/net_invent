package ci.net.demo1.models.repos;

import ci.net.demo1.models.entities.Log;

import java.sql.SQLException;
import java.util.List;

public class LogRepo implements Repo<Log> {
    @Override
    public void create(Log log) throws SQLException {

    }

    @Override
    public Log getById(Long id) {
        return null;
    }

    @Override
    public List<Log> getAll() {
        return null;
    }

    @Override
    public boolean delete(Log log) throws SQLException {
        return false;
    }

    @Override
    public void update(Log log) throws SQLException {

    }
}
