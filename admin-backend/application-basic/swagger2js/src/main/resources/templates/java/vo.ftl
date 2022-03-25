package ${cur.vo.package};

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
<#list cur.entity.imports as item>
import ${item};
</#list>

/**
* @author ${context.author}
* @date ${context.genDate}
*/
@Getter
@Setter
@NoArgsConstructor
public class ${cur.dao.name}Vo implements Serializable {

    <#list cur.entity.fields as item>
    <#if item.note?? >/**
     * ${item.note!''}
     */</#if>
    private ${item.fieldType} ${item.field};

</#list>
}
