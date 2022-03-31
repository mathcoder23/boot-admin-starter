/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-03-31 22:45:29
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/framework/api/core/core'
const apiPrefix = '/api/message/websocket'
/**
* function:
*  getConfig
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«消息连接配置»",
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
	*			"ref":"#/definitions/消息连接配置",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"消息连接配置",
	*				"properties":{
	*					"proto":{
	*						"type":"string"
	*					},
	*					"serverIp":{
	*						"type":"string"
	*					},
	*					"serverPort":{
	*						"type":"string"
	*					},
	*					"uri":{
	*						"type":"string"
	*					},
	*					"token":{
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
const getConfig = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/getConfig',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  unsubscribeMessage
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"SubscribeParamDTO",
	*	"properties":{
	*		"channelValue":{
	*			"type":"string"
	*		},
	*		"channelId":{
	*			"type":"string"
	*		},
	*		"token":{
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
const unsubscribeMessage = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/unsubscribeMessage',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  subscribeMessage
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"SubscribeParamDTO",
	*	"properties":{
	*		"channelValue":{
	*			"type":"string"
	*		},
	*		"channelId":{
	*			"type":"string"
	*		},
	*		"token":{
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
const subscribeMessage = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/subscribeMessage',
        method: 'POST',
        data: body,
        params: params
    })
}
export const WebsocketApi = {
    /**
     *
     */
    getConfig: getConfig,
    /**
     *
     */
    unsubscribeMessage: unsubscribeMessage,
    /**
     *
     */
    subscribeMessage: subscribeMessage
}
