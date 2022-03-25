/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2021-08-18 10:00:51
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '/api/constant'
/**
* function:
*  dict
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"RestObjectResponse«Map«string,List«DictData»»»",
	*	"properties":{
	*		"msg":{
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"additionalProperties":{
	*				"type":"array",
	*				"items":{
	*					"ref":"#/definitions/DictData"
	*				}
	*			},
	*			"type":"object"
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
const dict = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/dict',
        method: 'POST',
        data: body,
        params: params
    })
}
export const ConstantApi = {
    /**
     *
     */
    dict: dict
}
