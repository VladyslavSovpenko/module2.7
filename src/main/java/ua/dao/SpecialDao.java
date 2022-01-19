package ua.dao;

import ua.DbHelper;
import ua.model.Developer;
import ua.model.ProjectList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SpecialDao {

    public String getDevsSalaryOnSeparateProjectDao(String params) throws SQLException {
        String sql = String.format("select sum(salary) " +
                "from developers d " +
                "join dev_to_project dtp on dtp.id_dev =d.id " +
                "join projects p on p.id =dtp.id_projects  where p.name='%s' group by p.name order by sum(salary);", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                sql, ps -> {
                });
        if (resultSet.next()) {
            System.out.println("salary sum = " + resultSet.getString("sum"));
        }
        return resultSet.getString("sum");
    }

    public List<Developer> getDeveloperListOfProjectDao(String params) throws SQLException {
        List<Developer> devList = new ArrayList<>();
        String sql = String.format("select d.name from developers d " +
                "join dev_to_project dtp on dtp.id_dev = d.id " +
                "join projects p on dtp.id_projects =p.id where p.name = '%s';", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            Developer developer = new Developer();
            developer.setName(resultSet.getString("name"));
            devList.add(developer);
        }
        resultSet.close();
        System.out.println(devList);
        return devList;

    }

    public List<Developer> getDevsWithLevelListDao(String params) throws SQLException {
        List<Developer> devs = new ArrayList<>();
        String sql = String.format("select d.name from developers d " +
                "join dev_to_skills dts on dts.id_dev =d.id " +
                "join skills s on s.id =dts.id_skills where s.skill_rate = '%s';", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            Developer developer = new Developer();
            developer.setName(resultSet.getString("name"));
            devs.add(developer);
        }
        resultSet.close();
        System.out.println(devs);
        return devs;
    }

    public List<Developer> getDevsWithLangListDao(String params) throws SQLException {
        List<Developer> devs = new ArrayList<>();
        String sql = String.format("select d.name " +
                "from developers d " +
                "join dev_to_skills dts on dts.id_dev =d.id " +
                "join skills s on s.id=dts.id_skills where language ='%s';", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            Developer developer = new Developer();
            developer.setName(resultSet.getString("name"));
            devs.add(developer);
        }
        resultSet.close();
        System.out.println(devs);
        return devs;
    }

    public List<ProjectList> getProjectsListDao() throws SQLException {

        List<ProjectList> devList = new ArrayList<>();

        String sql = "select p.date_added, p.name, count(*) " +
                "from developers d " +
                "join dev_to_project dtp on dtp.id_dev =d.id " +
                "join projects p on p.id = dtp.id_projects where date_added is not null " +
                "group by p.id " +
                "order by count(*) desc;";
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            ProjectList projectList = new ProjectList();
            projectList.setCount(resultSet.getInt("count"));
            projectList.setName(resultSet.getString("name"));
            projectList.setDateAdded(resultSet.getDate("date_added"));
            devList.add(projectList);
        }
        System.out.println(devList);
        return devList;
    }
}

