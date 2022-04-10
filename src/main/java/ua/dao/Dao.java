package ua.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface Dao <T> {
   List<T> getAll() throws SQLException;
   Optional<T> get(Long id) throws SQLException;
   void create(T entity) throws SQLException;
   void update(T entity) throws SQLException;
   void delete(T entity);

}
