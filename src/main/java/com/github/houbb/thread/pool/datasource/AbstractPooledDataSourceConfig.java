package com.github.houbb.thread.pool.datasource;

import com.github.houbb.thread.pool.api.ILifeCycle;
import com.github.houbb.thread.pool.api.IPooledDataSourceConfig;
import com.github.houbb.thread.pool.constant.PooledConst;

/**
 * @author binbin.hou
 * @since 1.1.0
 */
public class AbstractPooledDataSourceConfig extends AbstractDataSourceConfig
        implements IPooledDataSourceConfig, ILifeCycle {

    /**
     * 最小尺寸
     * @since 1.1.0
     */
    protected int minSize = PooledConst.DEFAULT_MIN_SIZE;

    /**
     * 最大尺寸
     * @since 1.1.0
     */
    protected int maxSize = PooledConst.DEFAULT_MAX_SIZE;

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

}
