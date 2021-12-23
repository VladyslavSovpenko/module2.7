package ua;

import ua.commands.CommandHandler;
import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws SQLException {
        System.out.println("Start app");

        CommandHandler commandHandler = new CommandHandler();
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()){
            commandHandler.handleCommand(scanner.nextLine());
        }

        System.out.println("Finish app");
    }
}

