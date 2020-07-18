package com.github.houbb.thread.pool.datasource;

import com.github.houbb.heaven.util.lang.ThreadUtil;
import com.github.houbb.heaven.util.util.DateUtil;
import com.github.houbb.heaven.util.util.Optional;
import com.github.houbb.heaven.util.util.TimeUtil;
import com.github.houbb.thread.pool.connection.IPooledConnection;
import com.github.houbb.thread.pool.connection.PooledConnection;
import com.github.houbb.thread.pool.exception.JdbcPoolException;
import com.github.houbb.thread.pool.util.DriverClassUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 池化的数据源
 * @author binbin.hou
 * @since 1.1.0
 */
public class PooledDataSource extends AbstractPooledDataSourceConfig {

    /**
     * 内置的队列
     * @since 1.1.0
     */
    private List<IPooledConnection> pool = new ArrayList<>();

    @Override
    public synchronized void init() {
        DriverClassUtil.loadDriverClass(super.driverClass, super.jdbcUrl);

        this.initJdbcPool();
    }

    @Override
    public synchronized Connection getConnection() throws SQLException {
        //1. 获取第一个不是 busy 的连接
        Optional<IPooledConnection> connectionOptional = getFreeConnection();
        if(connectionOptional.isPresent()) {
            return connectionOptional.get();
        }

        //2. 考虑是否可以扩容
        if(pool.size() >= maxSize) {
            //2.1 立刻返回
            if(maxWaitMills <= 0) {
                throw new JdbcPoolException("Can't get connection from pool!");
            }


            //2.2 循环等待
            final long startWaitMills = System.currentTimeMillis();
            final long endWaitMills = startWaitMills + maxWaitMills;
            while (System.currentTimeMillis() < endWaitMills) {
                Optional<IPooledConnection> optional = getFreeConnection();
                if(optional.isPresent()) {
                    return optional.get();
                }

                DateUtil.sleep(1);
                System.out.println("等待连接池归还...");
            }

            //2.3 等待超时
            throw new JdbcPoolException("Can't get connection from pool, wait time out for mills: " + maxWaitMills);
        }

        //3. 扩容（暂时只扩容一个）
        System.out.println("Grow create the jdbc pool...");
        IPooledConnection pooledConnection = createPooledConnection();
        pooledConnection.setBusy(true);
        this.pool.add(pooledConnection);

        return pooledConnection;
    }

    /**
     * 获取空闲的连接
     * @return 连接
     * @since 1.3.0
     */
    private Optional<IPooledConnection> getFreeConnection() {
        for(IPooledConnection pc : pool) {
            if(!pc.isBusy()) {
                System.out.println("Get from thread pool...");
                pc.setBusy(true);
                return Optional.of(pc);
            }
        }
        // 空
        return Optional.empty();
    }

    /**
     * 初始化连接池
     * @since 1.1.0
     */
    private void initJdbcPool() {
        final int minSize = super.minSize;
        pool = new ArrayList<>(minSize);

        for(int i = 0; i < minSize; i++) {
            IPooledConnection pooledConnection = createPooledConnection();

            pool.add(pooledConnection);
        }
    }

    /**
     * 创建一个池化的连接
     * @return 连接
     * @since 1.1.0
     */
    private IPooledConnection createPooledConnection() {
        Connection connection = createConnection();

        IPooledConnection pooledConnection = new PooledConnection();
        pooledConnection.setBusy(false);
        pooledConnection.setConnection(connection);

        return pooledConnection;
    }

    /**
     * 创建新连接
     * @return 连接
     * @since 1.1.0
     */
    private Connection createConnection() {
        try {
            return DriverManager.getConnection(super.getJdbcUrl(),
                    super.getUser(), super.getPassword());
        } catch (SQLException e) {
            throw new JdbcPoolException(e);
        }
    }

}
