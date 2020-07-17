package com.github.houbb.thread.pool.api;

/**
 * 池化的接口
 * @author binbin.hou
 * @since 1.0.0
 */
public interface IPooledDataSourceConfig extends IDataSourceConfig {

    /**
     * 设置最小尺寸
     *
     * @param minSize 大小
     * @since 1.1.0
     */
    void setMinSize(final int minSize);

    /**
     * 设置最大的大小
     *
     * @param maxSize 最大的大小
     * @since 1.1.0
     */
    void setMaxSize(final int maxSize);

}
