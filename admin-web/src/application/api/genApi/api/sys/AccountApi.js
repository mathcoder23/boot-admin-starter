/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2021-08-18 10:00:51
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '/api/sys/account'
/**
* function:
*  getPermissionTree
* params:
	*[]

* body:

* response:
	*{
	*	"type":"object",
	*	"title":"RestObjectResponse«List«PermissionTreeData»»",
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
	*				"ref":"#/definitions/PermissionTreeData"
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
	*		"id":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"username":{
	*			"type":"string"
	*		}
	*	}
	*}

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
	*	"title":"RestObjectResponse«PageInfo«账户信息»»",
	*	"properties":{
	*		"msg":{
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"ref":"#/definitions/PageInfo«账户信息»",
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
export const AccountApi = {
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
    list: list
}
