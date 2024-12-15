package org.bank.database;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection();
             Statement statement = connection.createStatement()) {

            // Create database
            String createDatabase = "CREATE DATABASE IF NOT EXISTS bank";
            statement.executeUpdate(createDatabase);

            // Use the created database
            String useDatabase = "USE bank";
            statement.executeUpdate(useDatabase);

            // Create users table
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "username VARCHAR(255) UNIQUE NOT NULL, " +
                    "password VARCHAR(255) NOT NULL)";
            statement.executeUpdate(createUsersTable);

            // Create accounts table
            String createAccountsTable = "CREATE TABLE IF NOT EXISTS accounts (" +
                    "id BIGINT AUTO_INCREMENT PRIMARY KEY, " +
                    "accountHolderName VARCHAR(255) NOT NULL, " +
                    "balance DOUBLE NOT NULL)";
            statement.executeUpdate(createAccountsTable);

            System.out.println("Database and tables created successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
