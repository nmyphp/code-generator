基于rapid-generator代码自动生成功能，并提供一套后端代码生成模板。

包括：
1. dao、dto、mapper、service
2. dao层提供多样化的增删改查方法，基本满足开发需要
```java
public abstract int insert(T paramT);

public abstract int insert(T paramT);

public abstract int update(T paramT);

public abstract int update(T paramT);

public abstract T fingByPk(PK paramPK);

public abstract T fingByPk(PK paramPK);

public abstract Long findCondition_count(T paramT);

public abstract Long findCondition_count(T paramT);

public abstract List<T> findByCondition(T paramT);

public abstract List<T> findByCondition(T paramT);

public abstract SqlSessionTemplate getCurSqlSessionTemplate();

public abstract String getStatementNamespace();
```

Getting Start
#### 1.设置数据库配置
修改resources/generator.xml

| 配置项 | 描述 | 示例 |
| --------- | -------- | -------------- |
| basepackage | 包路径 | com.free |
| outRoot | 输出目录 | /Users/Documents/generator_codes |
| tableRemovePrefixes | 表前缀 | order_ |
| jdbc_url | 数据库URL | jdbc:mysql://127.0.0.1:3306/OrderDB?characterEncoding=utf-8 |
| jdbc_driver | 驱动包名 | com.mysql.jdbc.Driver |
| jdbc_username | 用户名 | test |
| jdbc_password | 密码 | test |

#### 2.运行
点击运行GeneratorMain.main

#### 参考文档
https://code.google.com/archive/p/rapid-framework/wikis/rapid_generator.wiki