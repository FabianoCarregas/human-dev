package br.com.alura.humanDev.jdbc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    public DataSource dataSource;

    public ConnectionFactory() {
        ComboPooledDataSource poolData = new ComboPooledDataSource();
        poolData.setJdbcUrl("jdbc:mysql://localhost/humandev?useTimezone=true&serverTimezone=UTC");
        poolData.setUser("root");
        poolData.setPassword("Http@0081");

        poolData.setMaxPoolSize(10);

        this.dataSource = poolData;
    }

    public Connection connectionFactory() throws SQLException {
     return dataSource.getConnection();
    }
}
