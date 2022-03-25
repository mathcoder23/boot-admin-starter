/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  ${genDate}
*  mbg-author: ${author}
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '${cGenApi.uriPrefix}'
<#list cGenApi.cmdList as item>
/**
* function:
*  ${item.cmdName}
* params:
${item.params!''}
* body:
${item.body!''}
* response:
${item.response!''}
*
*/
const ${item.cmdName} = (<#if item.apiMethod=='Get'>params</#if><#if item.apiMethod!='Get'>body, params</#if>) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/${item.uri}',
        method: <#if item.apiMethod=='Get'>'GET'</#if><#if item.apiMethod!='Get'>'POST'</#if>,
        <#if item.apiMethod=='Get'>params: params</#if><#if item.apiMethod!='Get'>data: body,<#if item.responseType=='blob'>
        responseType: 'blob',</#if>
        params: params</#if>
    })
}
</#list>
export const ${cGenApi.objName} = {
<#list cGenApi.cmdList as item>
    /**
     *
     */
    ${item.cmdName}: ${item.cmdName}<#if item_has_next>,
</#if><#if !item_has_next>

}
</#if>
</#list>
