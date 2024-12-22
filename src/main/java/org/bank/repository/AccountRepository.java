package org.bank.repository;

import org.bank.database.DatabaseConnection;
import org.bank.model.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

// 데이터베이스 접근을 위한 클래스
public class AccountRepository {

    public void save(Account account) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "INSERT INTO accounts (accountHolderName, balance) VALUES (?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                statement.setString(1, account.getAccountHolderName());
                statement.setDouble(2, account.getBalance());
                statement.executeUpdate();

                // 자동 생성된 ID를 가져와서 Account 객체에 설정
                ResultSet generatedKeys = statement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    account.setId(generatedKeys.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Account findByName(String accountHolderName) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE accountHolderName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, accountHolderName);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return new Account(
                            resultSet.getLong("id"),
                            resultSet.getString("accountHolderName"),
                            resultSet.getDouble("balance")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Account findById(Long id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM accounts WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    return new Account(
                            resultSet.getLong("id"),
                            resultSet.getString("accountHolderName"),
                            resultSet.getDouble("balance")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Account> findAll() {
        List<Account> accounts = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT * FROM accounts";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    accounts.add(new Account(
                            resultSet.getLong("id"),
                            resultSet.getString("accountHolderName"),
                            resultSet.getDouble("balance")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return accounts;
    }

    public void update(Account account) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "UPDATE accounts SET balance = ? WHERE accountHolderName = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDouble(1, account.getBalance());
                statement.setString(2, account.getAccountHolderName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
