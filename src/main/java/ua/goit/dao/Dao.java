package ua.goit.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao <T extends Identity> {
   List<T> getAll() throws SQLException;
   Optional<T> get(Long id) throws SQLException;
   Optional<T> create(T entity) throws SQLException;
   void update(T entity) throws SQLException;
   void delete(T entity);

}
