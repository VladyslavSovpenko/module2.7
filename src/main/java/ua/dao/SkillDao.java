package ua.dao;

import ua.DbHelper;
import ua.model.Skills;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class SkillDao extends AbstractDao<Skills> {
    @Override
    String getTableName() {
        return "skills";
    }

    @Override
    Skills mapToEntity(ResultSet resultSet) throws SQLException {
        Skills skill = new Skills();
        skill.setId(resultSet.getLong("id"));
        skill.setLanguage(resultSet.getString("language"));
        skill.setSkillRate(resultSet.getString("skill_rate"));
        return skill;
    }

    @Override
    public Optional<Skills> create(Skills entity) throws SQLException {
        String sql = "insert into skills (language, skill_rate) values (?,?);";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getLanguage());
            ps.setString(2, entity.getSkillRate());
        });
        System.out.println("Records 'skill' was created");
        return Optional.empty();
    }

    @Override
    public void update(Skills entity) throws SQLException {
        String sql = "update skills set language=?, skill_rate=? where id =?;";
        DbHelper.executeWithPreparedStatement(sql, ps -> {
            ps.setString(1, entity.getLanguage());
            ps.setString(2, entity.getSkillRate());
            ps.setLong(3, entity.getId());
        });
        System.out.println("Record 'skill' was updated");
    }
}
