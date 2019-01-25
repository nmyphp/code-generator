package ${basepackage}.dao;

import java.util.List;
import org.mybatis.spring.SqlSessionTemplate;

public abstract interface BaseDao<T, PK extends Serializable> {

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
}