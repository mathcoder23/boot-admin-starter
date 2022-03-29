/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-03-29 21:25:09
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '/api/sys/account'
/**
* function:
*  restPassword
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"EditAccountDTO",
	*	"properties":{
	*		"nick":{
	*			"type":"string"
	*		},
	*		"password":{
	*			"type":"string"
	*		},
	*		"enable":{
	*			"type":"boolean"
	*		},
	*		"roleId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"departmentId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"id":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"type":{
	*			"type":"string",
	*			"enum":[
	*				"SUPER_ADMIN",
	*				"USER"
	*			]
	*		},
	*		"username":{
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
const restPassword = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/restPassword',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  getPermissionTree
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«List«PermissionTreeData»»",
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
	*				"ref":"#/definitions/PermissionTreeData"
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
const getPermissionTree = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/getPermissionTree',
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
	*	"title":"EditAccountDTO",
	*	"properties":{
	*		"nick":{
	*			"type":"string"
	*		},
	*		"password":{
	*			"type":"string"
	*		},
	*		"enable":{
	*			"type":"boolean"
	*		},
	*		"roleId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"departmentId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"id":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"type":{
	*			"type":"string",
	*			"enum":[
	*				"SUPER_ADMIN",
	*				"USER"
	*			]
	*		},
	*		"username":{
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
const save = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/save',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  list
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"AccountParam",
	*	"properties":{
	*		"pageNo":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"pageSize":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"anyText":{
	*			"type":"string"
	*		},
	*		"type":{
	*			"type":"string",
	*			"enum":[
	*				"SUPER_ADMIN",
	*				"USER"
	*			]
	*		}
	*	}
	*}

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«PageInfo«账户信息»»",
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
	*			"ref":"#/definitions/PageInfo«账户信息»",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"PageInfo«账户信息»",
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
	*							"ref":"#/definitions/账户信息"
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
*  modifyPassword
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"ModifyPwdDTO",
	*	"properties":{
	*		"newPwd":{
	*			"type":"string"
	*		},
	*		"pwd":{
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
const modifyPassword = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/modifyPassword',
        method: 'POST',
        data: body,
        params: params
    })
}
export const AccountApi = {
    /**
     *
     */
    restPassword: restPassword,
    /**
     *
     */
    getPermissionTree: getPermissionTree,
    /**
     *
     */
    save: save,
    /**
     *
     */
    list: list,
    /**
     *
     */
    modifyPassword: modifyPassword
}
