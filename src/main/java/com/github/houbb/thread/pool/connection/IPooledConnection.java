package com.github.houbb.thread.pool.connection;

import java.sql.Connection;

/**
 * 池化的连接池
 */
public interface IPooledConnection extends Connection {


    /**
     * 是否繁忙
     * @since 1.1.0
     * @return 状态
     */
    boolean isBusy();

    /**
     * 设置状态
     * @param busy 状态
     * @since 1.1.0
     */
    void setBusy(boolean busy);

    /**
     * 获取真正的连接
     * @return 连接
     * @since 1.1.0
     */
    Connection getConnection();

    /**
     * 设置连接信息
     * @param connection 连接信息
     * @since 1.1.0
     */
    void setConnection(Connection connection);

}
