package ua.goit.commands.specialCommands;

import ua.goit.commands.Command;
import ua.goit.dao.SpecialDao;
import java.sql.SQLException;

public class SpecialCommands implements Command {

    private final SpecialDao specialDao = new SpecialDao();

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
            case ("getDevsWithLevelList"):
                getDevsWithLevelList(subParams);
                break;
            case ("getDevsWithLangList"):
                getDevsWithLangList(subParams);
                break;
            case ("getProjectsList"):
                getProjectsList();
                break;
        }
    }

    //зарплату(сумму) всех разработчиков отдельного проекта;
    public void getDevsSalaryOnSeparateProject(String projectId) throws SQLException {
        specialDao.getDevsSalaryOnSeparateProjectDao(projectId);
    }

    //  список разработчиков отдельного проекта;
    public void getDeveloperListOfProject(String params) throws SQLException {
        specialDao.getDeveloperListOfProjectDao(params);
    }

    //список всех middle разработчиков;
    public void getDevsWithLevelList(String level) throws SQLException {
      specialDao.getDevsWithLevelListDao(level);
    }

    //список всех Java разработчиков;
    public void getDevsWithLangList(String language) throws SQLException {
        specialDao.getDevsWithLangListDao(language);
    }

    //список проектов в следующем формате: дата создания - название проекта - количество разработчиков на этом проекте.
    public void getProjectsList() throws SQLException {
      specialDao.getProjectsListDao();
    }
}