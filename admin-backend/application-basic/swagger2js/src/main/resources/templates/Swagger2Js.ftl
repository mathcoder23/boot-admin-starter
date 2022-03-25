/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  ${genDate}
*  mbg-author: ${author}
*/
import {PFApi} from "${cGenApi.importCore}core/core";
let apiPrefix = '${cGenApi.uriPrefix}'
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
    let ${item.cmdName} = (<#if item.apiMethod=='Get'>params</#if><#if item.apiMethod!='Get'>body,params</#if>) => {
        return PFApi.api${item.apiMethod}(
        {
            uri: apiPrefix + '/${item.uri}'
        }, <#if item.apiMethod=='Get'>params</#if><#if item.apiMethod!='Get'>body,params</#if>)
    }
</#list>
export const ${cGenApi.objName} = {
<#list cGenApi.cmdList as item>
    /**
     *
     */
    ${item.cmdName}:${item.cmdName},
</#list>
}