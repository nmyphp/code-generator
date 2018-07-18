<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao.impl;

import org.springframework.stereotype.Repository;

@Repository
public class ${className}DaoImpl extends BaseDaoImpl<${className},${table.idColumn.javaType}> implements ${className}Dao{
    
}
