package com.github.houbb.thread.pool.api;

import com.github.houbb.thread.pool.connection.IPooledConnection;

import javax.sql.DataSource;

/**
 * 配置接口
 * @author binbin.hou
 * @since 1.0.0
 */
public interface IDataSourceConfig extends IConfig, DataSource {


}
