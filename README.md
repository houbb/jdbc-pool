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
    <version>0.0.1</version>
</dependency>
```

## 准备工作

- sql 建表

在 test 数据库执行下面的建表语句。

```sql
-- auto-generated definition
use test;
create table user
(
  id   int auto_increment
    primary key comment '唯一主键',
  name varchar(100) not null comment '姓名',
  password varchar(100) not null comment '密码',
  create_time char(17) comment '创建时间'
) CHARACTER SET utf8 COLLATE utf8_general_ci;

-- init
insert into user (name, password) value ('luna', '123456');
```

- 配置文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <dataSource>
        <property name="driver" value="com.mysql.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/test"/>
        <property name="username" value="root"/>
        <property name="password" value="123456"/>
    </dataSource>

    <mappers>
        <mapper resource="mapper/UserMapper.xml"/>
    </mappers>

    <plugins>
        <plugin interceptor="com.github.houbb.jdbc-pool.plugin.SimpleLogInterceptor"/>
    </plugins>

    <typeHandlers>
        <typeHandler javaType="java.util.Date" handler="com.github.houbb.jdbc-pool.typehandler.DateTypeHandler"/>
    </typeHandlers>

</configuration>
```

备注：默认使用的是 mysql 5.7，如果为 8.0+，需要自行引入 jar。

## 运行测试代码

# 后期 road-map

- [ ] 添加配置的读取

- [ ] 添加基础的线程池