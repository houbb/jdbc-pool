package com.github.houbb.thread.pool.datasource;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author binbin.hou
 * @since 1.0.0
 */
public class UnPooledDataSourceTest {

    @Test
    public void simpleTest() throws SQLException {
        UnPooledDataSource source = new UnPooledDataSource();
        source.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
        source.setUser("root");
        source.setPassword("123456");

        Connection connection = source.getConnection();
        System.out.println(connection.getCatalog());
    }

}
