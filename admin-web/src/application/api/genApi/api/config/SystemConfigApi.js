/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-03-29 21:25:09
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
	*	"title":"通用响应体«List«系统配置组»»",
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
	*			"type":"array",
	*			"items":{
	*				"ref":"#/definitions/系统配置组"
	*			}
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
const getAllConfig = (params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/getAllConfig',
        method: 'GET',
        params: params
    })
}
/**
* function:
*  saveConfigByKey
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"ConfigEdit",
	*	"properties":{
	*		"value":{
	*			"type":"string"
	*		},
	*		"key":{
	*			"type":"string"
	*		}
	*	}
	*}

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
const saveConfigByKey = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/saveConfigByKey',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  getConfigByKey
* params:
	*[
	*	{
	*		"in":"query",
	*		"name":"key",
	*		"description":"key",
	*		"type":"string",
	*		"required":true
	*	}
	*]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«SystemConfig»",
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
	*			"ref":"#/definitions/SystemConfig",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"SystemConfig",
	*				"properties":{
	*					"configKey":{
	*						"type":"string"
	*					},
	*					"createTime":{
	*						"format":"date-time",
	*						"type":"string"
	*					},
	*					"defaultValue":{
	*						"type":"string"
	*					},
	*					"systemConfigGroupId":{
	*						"format":"int64",
	*						"type":"integer"
	*					},
	*					"remark":{
	*						"type":"string"
	*					},
	*					"updateTime":{
	*						"format":"date-time",
	*						"type":"string"
	*					},
	*					"id":{
	*						"format":"int64",
	*						"type":"integer"
	*					},
	*					"label":{
	*						"type":"string"
	*					},
	*					"type":{
	*						"type":"string",
	*						"enum":[
	*							"TEXT"
	*						]
	*					},
	*					"value":{
	*						"type":"string"
	*					}
	*				}
	*			}
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
const getConfigByKey = (params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/getConfigByKey',
        method: 'GET',
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
    saveConfigByKey: saveConfigByKey,
    /**
     *
     */
    getConfigByKey: getConfigByKey,
    /**
     *
     */
    simpleBatchModify: simpleBatchModify
}
