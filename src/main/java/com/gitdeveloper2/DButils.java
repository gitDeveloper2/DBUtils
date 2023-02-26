package com.gitdeveloper2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author gitDeveloper2--GitHub
 * @author Joseph Horace Karatu--name
 * @version 1.0
 */
public class DButils {
    private String username;
    private String password;
    private String databaseUrl;

    public DButils(String username, String password, String databaseUrl) {
        this.username = username;
        this.password = password;
        this.databaseUrl = databaseUrl;
    }

    /**
     * Used to acquire a MYSQL database connection
     *
     * @return  A java.sql.Connection object
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public Connection getConection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(getDatabaseUrl(), getUsername(), getPassword());

    }

    /**
     * Executes an SQL query that returns a ResultSet
     * @param executeQuerySQL SQL to be executed
     * @return A populated java.sql.ResultSet object
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public ResultSet executeQuery(String executeQuerySQL) throws SQLException, ClassNotFoundException {
        Connection connection = getConection();
        ResultSet resultSet=connection.createStatement().executeQuery(executeQuerySQL);

        return resultSet;
    }

    /**
     * Executes an SQL query that returns a true or false
     * @param executeSQL
     * @return  Returns true or false
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public boolean execute(String executeSQL) throws SQLException, ClassNotFoundException {
        Connection connection = getConection();
        return connection.createStatement().execute(executeSQL);
    }

    /**
     * Executes an SQL query that updates mysql table
     * @param executeQuerySQL
     * @return  return an integer indicating the result status
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public int executeUpdate(String executeQuerySQL) throws SQLException, ClassNotFoundException {
        Connection connection = getConection();
        return connection.createStatement().executeUpdate(executeQuerySQL);
    }

    public void closeConnection(Connection connection) throws SQLException {
        connection.close();

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }
}
