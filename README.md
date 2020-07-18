# 项目简介

[jdbc-pool](https://github.com/houbb/jdbc-pool) 是一款简化版的 jdbc-pool 实现。

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.houbb/jdbc-pool/badge.svg)](http://mvnrepository.com/artifact/com.github.houbb/jdbc-pool)
[![Build Status](https://www.travis-ci.org/houbb/jdbc-pool.svg?branch=master)](https://www.travis-ci.org/houbb/jdbc-pool?branch=master)
[![](https://img.shields.io/badge/license-Apache2-FF0080.svg)](https://github.com/houbb/jdbc-pool/blob/master/LICENSE.txt)
[![Open Source Love](https://badges.frapsoft.com/os/v2/open-source.svg?v=103)](https://github.com/houbb/jdbc-pool)

## 创作目的

- 学习 jdbc-pool 的原理

- 便于拓展自己的数据库工具

# 快速开始

## 需要

- jdk 1.7+

- maven 3.x+

## maven 引入

```xml
<dependency>
    <groupId>com.github.houbb</groupId>
    <artifactId>jdbc-pool</artifactId>
    <version>1.2.0</version>
</dependency>
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
Get from thread pool...
test
Grow create the jdbc pool...
test
```

第一次默认直接从线程池中获取，第二次为重新创建的信息。

# 后期 road-map

- [x] 根据 url 自动识别 driverClass

- [ ] 添加获取的等待

- [ ] 添加 validQuery, testOnBorrow, testOnReturn, testWhileIdle

（1）指定 idle 驱除的时间间隔

- [ ] 添加 filter-chain

- [ ] 添加监控页面实现