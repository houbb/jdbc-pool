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

    /**
     * 最大的等待时间
     * @since 1.3.0
     */
    protected long maxWaitMills = PooledConst.DEFAULT_MAX_WAIT_MILLS;

    public int getMinSize() {
        return minSize;
    }

    @Override
    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    @Override
    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public long getMaxWaitMills() {
        return maxWaitMills;
    }

    @Override
    public void setMaxWaitMills(long maxWaitMills) {
        this.maxWaitMills = maxWaitMills;
    }

    @Override
    public void init() {

    }

    @Override
    public void destroy() {

    }

}
