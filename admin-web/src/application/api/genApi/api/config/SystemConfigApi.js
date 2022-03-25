/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2021-08-18 10:00:51
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '/api/config/systemConfig'
/**
* function:
*  getAllConfig
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"RestObjectResponse«List«系统配置组»»",
	*	"properties":{
	*		"msg":{
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"type":"array",
	*			"items":{
	*				"ref":"#/definitions/系统配置组"
	*			}
	*		},
	*		"errmsg":{
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
const getAllConfig = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/getAllConfig',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  simpleBatchModify
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"RestObjectResponse«string»",
	*	"properties":{
	*		"msg":{
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"type":"string"
	*		},
	*		"errmsg":{
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
const simpleBatchModify = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/simpleBatchModify',
        method: 'POST',
        data: body,
        params: params
    })
}
export const SystemConfigApi = {
    /**
     *
     */
    getAllConfig: getAllConfig,
    /**
     *
     */
    simpleBatchModify: simpleBatchModify
}
