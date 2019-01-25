package ${basepackage}.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.mybatis.spring.SqlSessionTemplate;

public abstract class BaseDaoImpl<T, PK extends Serializable> implements BaseDao<T, PK> {

    @Resource
    private SqlSessionTemplate sqlSessionTemplate;
    public static final String INSERT = ".insert";
    public static final String UPDATE = ".update";
    public static final String FIN_BY_PK = ".findByPk";
    public static final String FIND_BY_CONDITION_COUNT = ".findByCondition_count";
    public static final String FIND_BY_CONDITION = ".findByCondition";
    private String statementNamespace = "";

    public int insert(T obj) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return getCurSqlSessionTemplate().insert(getStatementNamespace() + ".insert", obj);
    }

    public int insert(T obj, ShardStrategyParams strategyParams) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return getCurSqlSessionTemplate().insert(getStatementNamespace() + ".insert", obj);
    }

    public int update(T obj) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return getCurSqlSessionTemplate().update(getStatementNamespace() + ".update", obj);
    }

    public int update(T obj, ShardStrategyParams strategyParams) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return getCurSqlSessionTemplate().update(getStatementNamespace() + ".update", obj);
    }

    public T fingByPk(PK pk) {
        return getCurSqlSessionTemplate().selectOne(getStatementNamespace() + ".findByPk", pk);
    }

    public T fingByPk(PK pk, ShardStrategyParams strategyParams) {
        return getCurSqlSessionTemplate().selectOne(getStatementNamespace() + ".findByPk", pk);
    }

    public Long findCondition_count(T obj) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return (Long) getCurSqlSessionTemplate().selectOne(getStatementNamespace() + ".findByCondition_count", obj);
    }

    public Long findCondition_count(T obj, ShardStrategyParams strategyParams) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return (Long) getCurSqlSessionTemplate().selectOne(getStatementNamespace() + ".findByCondition_count", obj);
    }

    public List<T> findByCondition(T obj) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return getCurSqlSessionTemplate().selectList(getStatementNamespace() + ".findByCondition", obj);
    }

    public List<T> findByCondition(T obj, ShardStrategyParams strategyParams) {
        if (null == obj) {
            throw DaoException.ParamEmpty;
        }
        return getCurSqlSessionTemplate().selectList(getStatementNamespace() + ".findByCondition", obj);
    }

    public SqlSessionTemplate getCurSqlSessionTemplate() {
        return this.sqlSessionTemplate;
    }

    public synchronized String getStatementNamespace() {
        if (!StringUtils.isEmpty(this.statementNamespace)) {
            return this.statementNamespace;
        }
        try {
            Type type = getClass().getGenericSuperclass();
            ParameterizedType pType = (ParameterizedType) type;
            Type[] params = pType.getActualTypeArguments();

            Class cls = (Class) params[0];
            this.statementNamespace = cls.getName();
            return this.statementNamespace;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}