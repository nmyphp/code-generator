<#include "/macro.include"/>
<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.dto;

/**
 * 
 * @author chenlongjs
 * @date 2016年8月12日 下午1:57:06
 */
public class ${className}{
 
	<#list table.columns as column>
	/** ${column.columnAlias!} */	
	private ${column.javaType} ${column.columnNameLower};
	<#if column.isDateTimeColumn>
	/** 非数据库字段，查询时使用 */
	private ${column.javaType} ${column.columnNameLower}Begin;
	/** 非数据库字段，查询时使用 */
	private ${column.javaType} ${column.columnNameLower}End;
	</#if>
	</#list>
 
	<@generateConstructor className/>
	<@generateJavaColumns/>
	<@generateJavaOneToMany/>
	<@generateJavaManyToOne/>
 
}

<#macro generateJavaColumns>
	<#list table.columns as column>
	public void set${column.columnName}(${column.javaType} ${column.columnNameLower}) {
		this.${column.columnNameLower} = ${column.columnNameLower};
	}
	public ${column.javaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}
	<#if column.isDateTimeColumn>
    public void set${column.columnName}Begin(${column.javaType} ${column.columnNameLower}Begin) {
		this.${column.columnNameLower}Begin = ${column.columnNameLower}Begin;
	}
	public ${column.javaType} get${column.columnName}Begin() {
		return this.${column.columnNameLower}Begin;
	}
	public void set${column.columnName}End(${column.javaType} ${column.columnNameLower}End) {
		this.${column.columnNameLower}End = ${column.columnNameLower}End;
	}
	public ${column.javaType} get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}	
	</#if> 
	</#list>
</#macro>

<#macro generateJavaOneToMany>
	<#list table.exportedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	private Set ${fkPojoClassVar}s = new HashSet(0);
	public void set${fkPojoClass}s(Set<${fkPojoClass}> ${fkPojoClassVar}){
		this.${fkPojoClassVar}s = ${fkPojoClassVar};
	}
	public Set<${fkPojoClass}> get${fkPojoClass}s() {
		return this.${fkPojoClassVar}s;
	}
	</#list>
</#macro>

<#macro generateJavaManyToOne>
	<#list table.importedKeys.associatedTables?values as foreignKey>
	<#assign fkSqlTable = foreignKey.sqlTable>
	<#assign fkTable    = fkSqlTable.className>
	<#assign fkPojoClass = fkSqlTable.className>
	<#assign fkPojoClassVar = fkPojoClass?uncap_first>
	private ${fkPojoClass} ${fkPojoClassVar};
	public void set${fkPojoClass}(${fkPojoClass} ${fkPojoClassVar}){
		this.${fkPojoClassVar} = ${fkPojoClassVar};
	}
	public ${fkPojoClass} get${fkPojoClass}() {
		return this.${fkPojoClassVar};
	}
	</#list>
</#macro>
