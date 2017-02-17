<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dao;
import ${basepackage}.dto.${className};
<#include "/java_imports.include">

/**
 * 
 * @author chenlongjs
 * @date 2016年8月12日 下午1:52:33
 */
public interface ${className}Dao extends BaseDao<${className}, ${table.idColumn.javaType}> {
    
}
