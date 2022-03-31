/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-04-01 01:05:16
*  mbg-author: Petty Fox
*/
import {PFApi} from '@_framework/api/core/core'
const apiPrefix = '/api/sys/department'
/**
* function:
*  list
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"BasePageParam",
	*	"properties":{
	*		"pageNo":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"pageSize":{
	*			"format":"int32",
	*			"type":"integer"
	*		}
	*	}
	*}

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«PageInfo«DepartmentVO»»",
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
	*			"ref":"#/definitions/PageInfo«DepartmentVO»",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"PageInfo«DepartmentVO»",
	*				"properties":{
	*					"navigatepageNums":{
	*						"type":"array",
	*						"items":{
	*							"format":"int32",
	*							"type":"integer"
	*						}
	*					},
	*					"startRow":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"hasNextPage":{
	*						"type":"boolean"
	*					},
	*					"prePage":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"nextPage":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"endRow":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"pageSize":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"list":{
	*						"type":"array",
	*						"items":{
	*							"ref":"#/definitions/DepartmentVO"
	*						}
	*					},
	*					"pageNum":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"navigatePages":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"navigateFirstPage":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"total":{
	*						"format":"int64",
	*						"type":"integer"
	*					},
	*					"pages":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"size":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"isLastPage":{
	*						"type":"boolean"
	*					},
	*					"hasPreviousPage":{
	*						"type":"boolean"
	*					},
	*					"navigateLastPage":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"isFirstPage":{
	*						"type":"boolean"
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
const list = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/list',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  remove
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"BaseIdsParams",
	*	"properties":{
	*		"ids":{
	*			"type":"array",
	*			"items":{
	*				"format":"int64",
	*				"type":"integer"
	*			}
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
const remove = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/delete',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  save
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"DepartmentEdit",
	*	"properties":{
	*		"adminName":{
	*			"type":"string"
	*		},
	*		"address":{
	*			"type":"string"
	*		},
	*		"adminPhone":{
	*			"type":"string"
	*		},
	*		"name":{
	*			"type":"string"
	*		},
	*		"id":{
	*			"format":"int64",
	*			"type":"integer"
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
const save = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/save',
        method: 'POST',
        data: body,
        params: params
    })
}
export const DepartmentApi = {
    /**
     *
     */
    list: list,
    /**
     *
     */
    remove: remove,
    /**
     *
     */
    save: save
}
