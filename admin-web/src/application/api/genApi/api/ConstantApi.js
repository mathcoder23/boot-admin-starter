/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-03-29 21:25:09
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '/api/constant'
/**
* function:
*  domain
* params:
	*[
	*	{
	*		"in":"query",
	*		"name":"domain",
	*		"description":"domain",
	*		"type":"string",
	*		"required":true
	*	}
	*]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«string»",
	*	"properties":{
	*		"msg":{
	*			"description":"正常消息",
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"description":"公共响应码",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"description":"数据体",
	*			"type":"string"
	*		},
	*		"errmsg":{
	*			"description":"错误消息",
	*			"type":"string"
	*		},
	*		"bcode":{
	*			"format":"int32",
	*			"type":"integer"
	*		}
	*	}
	*}

*
*/
const domain = (params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/domain',
        method: 'GET',
        params: params
    })
}
/**
* function:
*  dict
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«Map«string,List«DictData»»»",
	*	"properties":{
	*		"msg":{
	*			"description":"正常消息",
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"description":"公共响应码",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"description":"数据体",
	*			"additionalProperties":{
	*				"type":"array",
	*				"items":{
	*					"ref":"#/definitions/DictData"
	*				}
	*			},
	*			"type":"object"
	*		},
	*		"errmsg":{
	*			"description":"错误消息",
	*			"type":"string"
	*		},
	*		"bcode":{
	*			"format":"int32",
	*			"type":"integer"
	*		}
	*	}
	*}

*
*/
const dict = (params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/dict',
        method: 'GET',
        params: params
    })
}
export const ConstantApi = {
    /**
     *
     */
    domain: domain,
    /**
     *
     */
    dict: dict
}
