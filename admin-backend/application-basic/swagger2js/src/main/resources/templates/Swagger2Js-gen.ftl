/**
*  note: 该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  ${genDate}
*  mbg-author: ${author}
*  description: 统一生成Api调用聚合
*  template-version: v1.0.0
*/
<#list genApiList as item>
import { ${item.objName} } from '.${item.filePath}/${item.objName}'
</#list>

export default {
<#list genApiList as item>
    ${item.objName}<#if item_has_next>,
</#if><#if !item_has_next>

}
</#if>
</#list>
