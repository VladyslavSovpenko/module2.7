package ua.commands;

import java.sql.SQLException;

public interface Command {

    void handle(String params) throws SQLException;
}
