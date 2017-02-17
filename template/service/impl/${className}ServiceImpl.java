<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;

<#include "/java_imports.include">
@Service
public class ${className}ServiceImpl implements ${className}Service{
	@Resource
	private ${className}Dao ${classNameLower}Dao;
	
	
}
