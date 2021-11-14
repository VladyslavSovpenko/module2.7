package ua.goit.commands.specialCommands;

import ua.goit.DbHelper;
import ua.goit.commands.Command;
import ua.goit.dao.ProjectDao;
import ua.goit.model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SpecialCommands implements Command {

    private final ProjectDao projectDao = new ProjectDao();

    @Override
    public void handle(String params) throws SQLException {
        String[] i = params.split(" ");
        String subParams = String.join("", params.replace(i[0] + " ", ""));
        switch (i[0]) {
            case ("getSalary"):
                getDevsSalaryOnSeparateProject(subParams);
                break;
            case ("getDevList"):
                getDeveloperListOfProject(subParams);
                break;
            case ("getMiddleDevsList"):
                getMiddleDevsList();
                break;
            case ("getDevsListWithLevel"):
                getDevsListWithLevel(subParams);
                break;
            case ("getProjectsList"):
                getProjectsList();
                break;
        }
    }

    public void getDevsSalaryOnSeparateProject(String projectId) throws SQLException {
        String sql = String.format("select sum(salary) from developers d join dev_to_project dtp on dtp.id_dev =d.id join projects p on p.id =dtp.id_projects  where p.id=%s group by p.name order by sum(salary)", projectId);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(
                sql, ps -> {
                });
        if (resultSet.next()) {
            System.out.println("salary sum = " + resultSet.getString("sum"));
        }
    }

    //  список разработчиков отдельного проекта;
    public void getDeveloperListOfProject(String params) throws SQLException {
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

    //список всех middle разработчиков;
    public void getMiddleDevsList() throws SQLException {
        List<String> devs = new ArrayList<>();
        String sql = "select d.name from developers d " +
                "join dev_to_skills dts on dts.id_dev =d.id " +
                "join skills s on s.id =dts.id_skills where s.skill_rate = 'Middle';";
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            devs.add(resultSet.getString("name"));
        }
        resultSet.close();
        System.out.println(devs);
    }

    //список всех Java разработчиков;
    public void getDevsListWithLevel(String level) throws SQLException {
        List<String> devs = new ArrayList<>();
        String sql = String.format("select d.name --список всех Java разработчиков" +
                "from developers d" +
                "join dev_to_skills dts on dts.id_dev =d.id " +
                "join skills s on s.id=dts.id_skills where language ='%s';", level);
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            devs.add(resultSet.getString("name"));
        }
        resultSet.close();
        System.out.println(devs);
    }

    //список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.
    public void getProjectsList() throws SQLException {
        Project project = new Project();
        List<Project> projects = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        String sql = "select p.date_added, p.name, count(*)\n" +
                "from developers d \n" +
                "join dev_to_project dtp on dtp.id_dev =d.id \n" +
                "join projects p on p.id = dtp.id_projects where date_added is not null\n" +
                "group by p.id \n" +
                "order by count(*) desc;";
        ResultSet resultSet = DbHelper.getWithPreparedStatement(sql, ps -> {
        });
        while (resultSet.next()) {
            System.out.print("Date added - "+resultSet.getDate("date_added") + " | ");
            System.out.print("Project name - "+resultSet.getString("name") +" | ");
            System.out.println("Developers on project - "+resultSet.getInt("count"));
        }
        for (Project projectArray : projects) {
            int i = 0;
            System.out.print(projectArray);
            System.out.println(count.get(i));
        }

    }
}