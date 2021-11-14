package ua.goit.dao;

import ua.goit.DbHelper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Identity> implements Dao<T> {

    abstract String getTableName();
    abstract T mapToEntity(ResultSet resultSet) throws SQLException;

    @Override
    public void delete(T entity) {
        String sql = String.format("delete from %s where id=?", getTableName());
        try {
            DbHelper.executeWithPreparedStatement(sql, ps -> {
                ps.setLong(1, entity.getId());
            });
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("Deleted from " + getTableName());
    }

    @Override
    public Optional<T> get(Long id) throws SQLException {
        String query = String.format("select * from %s where id=?", getTableName());
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                query, ps -> {
                    ps.setLong(1, id);
                });
        if (resultSet.next()) {
            System.out.println("Record was selected");
            return Optional.of(mapToEntity(resultSet));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<T> getAll() throws SQLException {
        List<T> result = new ArrayList<>();
        String query = String.format("select * from %s", getTableName());
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                query, ps -> {
                });
        while (resultSet.next()) {
            result.add(mapToEntity(resultSet));
        }
        resultSet.close();
        return result;
    }



}
