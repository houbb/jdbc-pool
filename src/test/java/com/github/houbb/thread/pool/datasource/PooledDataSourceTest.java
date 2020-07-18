package com.github.houbb.thread.pool.datasource;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author binbin.hou
 * @since 1.1.0
 */
public class PooledDataSourceTest {

    @Test
    public void simpleTest() throws SQLException {
        PooledDataSource source = new PooledDataSource();
        source.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
        source.setUser("root");
        source.setPassword("123456");
        source.setMinSize(1);

        // 初始化
        source.init();

        Connection connection = source.getConnection();
        System.out.println(connection.getCatalog());

        Connection connection2 = source.getConnection();
        System.out.println(connection2.getCatalog());
    }

}
