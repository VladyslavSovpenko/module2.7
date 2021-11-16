package ua.goit.dao;

import ua.goit.DbHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class SpecialDao {

    public void getDevsSalaryOnSeparateProjectDao(String params) throws SQLException {
        String sql = String.format("select sum(salary) from developers d " +
                "join dev_to_project dtp on dtp.id_dev =d.id " +
                "join projects p on p.id =dtp.id_projects  where p.id=%s group by p.name order by sum(salary)", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                sql, ps -> {
                });
        if (resultSet.next()) {
            System.out.println("salary sum = " + resultSet.getString("sum"));
        }
    }

    public void getDeveloperListOfProjectDao(String params) throws SQLException {
        List<String> devList = new ArrayList<>();
        String sql = String.format("select d.name from developers d " +
                "join dev_to_project dtp on dtp.id_dev = d.id " +
                "join projects p on dtp.id_projects =p.id where p.name = '%s'", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            devList.add(resultSet.getString("name"));
        }
        resultSet.close();
        System.out.println(devList);
    }

    public void getDevsWithLevelListDao(String params) throws SQLException {
        List<String> devs = new ArrayList<>();
        String sql = String.format("select d.name from developers d " +
                "join dev_to_skills dts on dts.id_dev =d.id " +
                "join skills s on s.id =dts.id_skills where s.skill_rate = '%s';", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            devs.add(resultSet.getString("name"));
        }
        resultSet.close();
        System.out.println(devs);
    }

    public void getDevsWithLangListDao(String params) throws SQLException {
        List<String> devs = new ArrayList<>();
        String sql = String.format("select d.name " +
                "from developers d " +
                "join dev_to_skills dts on dts.id_dev =d.id " +
                "join skills s on s.id=dts.id_skills where language ='%s';", params);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            devs.add(resultSet.getString("name"));
        }
        resultSet.close();
        System.out.println(devs);
    }

    public void getProjectsListDao() throws SQLException {

        List<Map<String, Map<Date, Integer>>> results = new ArrayList<>();

        String sql = "select p.date_added, p.name, count(*) " +
                "from developers d " +
                "join dev_to_project dtp on dtp.id_dev =d.id " +
                "join projects p on p.id = dtp.id_projects where date_added is not null " +
                "group by p.id " +
                "order by count(*) desc;";
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            Map<Date, Integer> res1 = new HashMap<>();
            res1.put(resultSet.getDate("date_added"), resultSet.getInt("count"));
            Map<String, Map<Date, Integer>> res2 = new HashMap<>();
            res2.put(resultSet.getString("name"), res1);
            results.add(res2);
        }
        for (int i = 0; i < results.size(); i++) {
            System.out.print(results.get(i).values()+" ");
            System.out.println(results.get(i).keySet());
        }
    }
}
