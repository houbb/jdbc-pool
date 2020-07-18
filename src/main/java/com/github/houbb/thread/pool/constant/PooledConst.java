package com.github.houbb.thread.pool.constant;

/**
 * 线程池常量
 * @since 1.1.0
 */
public final class PooledConst {

    private PooledConst(){}

    /**
     * 默认的最小连接数
     * @since 1.1.0
     */
    public static final int DEFAULT_MIN_SIZE = 10;

    /**
     * 默认最大的连接数
     * @since 1.1.0
     */
    public static final int DEFAULT_MAX_SIZE = 300;

    /**
     * 默认最大的等待毫秒数
     *
     * 默认：1 min
     *
     * @since 1.3.0
     */
    public static final int DEFAULT_MAX_WAIT_MILLS = 60 * 1000;

}
