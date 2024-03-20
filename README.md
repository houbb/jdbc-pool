# 项目简介

[jdbc-pool](https://github.com/houbb/jdbc-pool) 是一款简化版的 jdbc-pool 实现。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/jdbc-pool/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/jdbc-pool)
[![Build Status](https://www.travis-ci.org/houbb/jdbc-pool.svg?branch=master)](https://www.travis-ci.org/houbb/jdbc-pool?branch=master)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/jdbc-pool/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/jdbc-pool)

## 创作目的

- 学习 jdbc-pool 的原理

- 便于拓展自己的数据库工具

## 特性

- 基本的数据库连接池实现

- 自动适配 jdbc 驱动类

- 支持各种场景对于连接的校验

# 快速开始

## 需要

- jdk 1.7+

- maven 3.x+

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>jdbc-pool</artifactId>
    <version>1.6.1</version>
</dependency>
```

## 引导类

```java
JdbcPoolBs jdbcPoolBs = JdbcPoolBs.newInstance()
                .username("root")
                .password("123456")
                .url("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");

DataSource pooled = jdbcPoolBs.pooled();
DataSource unPooled = jdbcPoolBs.unPooled();
```

## 测试代码

```java
UnPooledDataSource source = new UnPooledDataSource();
source.setDriverClass("com.mysql.jdbc.Driver");
source.setJdbcUrl("jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf-8");
source.setUser("root");
source.setPassword("123456");

Connection connection = source.getConnection();
```

## 池化的实现

```java
PooledDataSource source = new PooledDataSource();
source.setDriverClass("com.mysql.jdbc.Driver");
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
```

### 输出日志

```
[DEBUG] [2020-07-18 10:50:54.536] [main] [c.g.h.t.p.d.PooledDataSource.getFreeConnection] - 从连接池中获取连接
test
[DEBUG] [2020-07-18 10:50:54.537] [main] [c.g.h.t.p.d.PooledDataSource.getConnection] - 开始扩容连接池大小，step: 1
[DEBUG] [2020-07-18 10:50:54.548] [main] [c.g.h.t.p.d.PooledDataSource.getConnection] - 从扩容后的连接池中获取连接
test
```

第一次默认直接从线程池中获取，第二次为重新创建的信息。

# 后期 road-map

- [x] 根据 url 自动识别 driverClass

- [x] 添加获取的等待

- [x] 添加设置为繁忙的状态 check

- [x] 添加日志替代 sout

- [x] 添加 validQuery, testOnBorrow, testOnReturn, testWhileIdle

- [ ] 添加 filter-chain

- [ ] JMX 添加各种监听的属性

- [ ] 添加监控页面实现

- [ ] 添加 druid/mybatis??/commons-pool 等常见的数据源

# 中间件等工具开源矩阵

[heaven: 收集开发中常用的工具类](https://github.com/houbb/heaven)

[rpc: 基于 netty4 实现的远程调用工具](https://github.com/houbb/rpc)

[mq: 简易版 mq 实现](https://github.com/houbb/mq)

[ioc: 模拟简易版 spring ioc](https://github.com/houbb/ioc)

[mybatis: 简易版 mybatis](https://github.com/houbb/mybatis)

[cache: 渐进式 redis 缓存](https://github.com/houbb/cache)

[jdbc-pool: 数据库连接池实现](https://github.com/houbb/jdbc-pool)

[sandglass: 任务调度时间工具框架](https://github.com/houbb/sandglass)

[sisyphus: 支持注解的重试框架](https://github.com/houbb/sisyphus)

[resubmit: 防止重复提交框架，支持注解](https://github.com/houbb/resubmit)

[auto-log: 日志自动输出](https://github.com/houbb/auto-log)

[async: 多线程异步并行框架](https://github.com/houbb/async)

