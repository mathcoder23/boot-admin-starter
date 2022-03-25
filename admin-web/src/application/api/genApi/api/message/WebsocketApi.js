/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2021-08-18 10:00:51
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
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
	*	"title":"RestObjectResponse«消息连接配置»",
	*	"properties":{
	*		"msg":{
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"ref":"#/definitions/消息连接配置",
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
export const WebsocketApi = {
    /**
     *
     */
    getConfig: getConfig
}
