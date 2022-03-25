package ${cur.controller.package}.params;

import com.young.global.boot.controller.params.BaseIdParams;
import lombok.Getter;
import lombok.Setter;
<#list cur.entity.imports as item>
import ${item};
</#list>

/**
* @author ${context.author}
* @date ${context.genDate}
*/
@Getter
@Setter
public class ${cur.dao.name}EditParams extends BaseIdParams<${cur.dao.idType}> {
<#list cur.entity.fields as item>
    <#if item.note?? >/**
    * ${item.note!''}
    */</#if>
    private ${item.fieldType} ${item.field};

</#list>
}
