<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.api;

import org.springframework.stereotype.Service;

<#include "/java_imports.include">
@Service
public interface ${className}Service {
    
}