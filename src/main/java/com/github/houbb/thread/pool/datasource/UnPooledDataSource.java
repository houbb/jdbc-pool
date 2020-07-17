package com.github.houbb.thread.pool.datasource;

import com.github.houbb.thread.pool.exception.JdbcPoolException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class UnPooledDataSource extends AbstractDataSourceConfig {

    @Override
    public Connection getConnection() throws SQLException {
        try {
            Class.forName(super.getDriverClass());
        } catch (ClassNotFoundException e) {
            throw new JdbcPoolException(e);
        }

        return DriverManager.getConnection(super.getJdbcUrl(),
                super.getUser(), super.getPassword());
    }

}
