<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

import org.springframework.stereotype.Repository;

/**
 * 
 * @author chenlongjs
 * @date 2016年8月12日 下午3:48:42
 */
@Repository
public class ${className}DaoImpl extends BaseDaoImpl<${className},${table.idColumn.javaType}> implements ${className}Dao{
    
}
