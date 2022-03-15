package br.com.alura.humanDev.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    String localhost = "jdbc:mysql://localhost/humandev?useTimezone=true&serverTimezone=UTC";
    String user = "root";
    String password = "Http@0081";

    private DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource poolData = new ComboPooledDataSource();
        poolData.setJdbcUrl(localhost);
        poolData.setUser(user);
        poolData.setPassword(password);
        poolData.setMaxPoolSize(10);

        this.dataSource = poolData;
    }

    public Connection getConnection() throws SQLException {
     return dataSource.getConnection();
    }

}
