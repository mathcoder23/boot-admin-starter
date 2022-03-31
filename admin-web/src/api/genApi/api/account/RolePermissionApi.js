/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-04-01 01:05:16
*  mbg-author: Petty Fox
*/
import {PFApi} from '@_framework/api/core/core'
const apiPrefix = '/api/account/role-permission'
/**
* function:
*  list2
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"RolePermissionQueryParams",
	*	"properties":{
	*		"pageNo":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"roleId":{
	*			"format":"int64",
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
	*	"title":"通用响应体«PageInfo«RolePermission对象»»",
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
	*			"ref":"#/definitions/PageInfo«RolePermission对象»",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"PageInfo«RolePermission对象»",
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
	*							"ref":"#/definitions/RolePermission对象"
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
const list2 = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/list2',
        method: 'POST',
        data: body,
        params: params
    })
}
/**
* function:
*  list
* params:
	*[
	*	{
	*		"default":1,
	*		"in":"query",
	*		"name":"pageNo",
	*		"format":"int32",
	*		"description":"pageNo",
	*		"type":"integer",
	*		"required":false
	*	},
	*	{
	*		"default":15,
	*		"in":"query",
	*		"name":"pageSize",
	*		"format":"int32",
	*		"description":"pageSize",
	*		"type":"integer",
	*		"required":false
	*	}
	*]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"通用响应体«RolePermissionBizImpl»",
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
	*			"ref":"#/definitions/RolePermissionBizImpl",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"RolePermissionBizImpl"
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
const list = (params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/list',
        method: 'GET',
        params: params
    })
}
/**
* function:
*  savePermission
* params:
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"RolePermissionEditParams",
	*	"properties":{
	*		"id":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"permissionIds":{
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
const savePermission = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/savePermission',
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
	*	"title":"RolePermission对象",
	*	"properties":{
	*		"permissionId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"createTime":{
	*			"format":"date-time",
	*			"type":"string"
	*		},
	*		"roleId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"remark":{
	*			"type":"string"
	*		},
	*		"updateTime":{
	*			"format":"date-time",
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
	*	"title":"通用响应体«RolePermission对象»",
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
	*			"ref":"#/definitions/RolePermission对象",
	*			"description":"数据体",
	*			"value":{
	*				"type":"object",
	*				"title":"RolePermission对象",
	*				"properties":{
	*					"permissionId":{
	*						"format":"int64",
	*						"type":"integer"
	*					},
	*					"createTime":{
	*						"format":"date-time",
	*						"type":"string"
	*					},
	*					"roleId":{
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
*  remove
* params:
	*[
	*	{
	*		"in":"query",
	*		"name":"ids",
	*		"description":"ids",
	*		"type":"array",
	*		"items":{
	*			"type":"string"
	*		},
	*		"collectionFormat":"multi",
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
const remove = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/delete',
        method: 'POST',
        data: body,
        params: params
    })
}
export const RolePermissionApi = {
    /**
     *
     */
    list2: list2,
    /**
     *
     */
    list: list,
    /**
     *
     */
    savePermission: savePermission,
    /**
     *
     */
    save: save,
    /**
     *
     */
    remove: remove
}
