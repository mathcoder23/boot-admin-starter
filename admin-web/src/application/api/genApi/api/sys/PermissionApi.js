/**
*  该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2021-08-18 10:00:51
*  mbg-author: Petty Fox
*/
import {PFApi} from '@/api/core/core'
const apiPrefix = '/api/sys/permission'
/**
* function:
*  getTree
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
const getTree = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/getTree',
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
	*	"title":"Permission对象",
	*	"properties":{
	*		"menuIcon":{
	*			"type":"string"
	*		},
	*		"menuPath":{
	*			"type":"string"
	*		},
	*		"pathDepth":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"menuComponent":{
	*			"type":"string"
	*		},
	*		"parentIds":{
	*			"type":"array",
	*			"items":{
	*				"type":"string"
	*			}
	*		},
	*		"orderNum":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"remark":{
	*			"type":"string"
	*		},
	*		"updateTime":{
	*			"format":"date-time",
	*			"type":"string"
	*		},
	*		"type":{
	*			"description":"权限类型,[MENU(1):菜单]",
	*			"type":"string",
	*			"enum":[
	*				"MENU"
	*			]
	*		},
	*		"parentId":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"parentNames":{
	*			"type":"array",
	*			"items":{
	*				"type":"string"
	*			}
	*		},
	*		"createTime":{
	*			"format":"date-time",
	*			"type":"string"
	*		},
	*		"enable":{
	*			"description":"是否启用",
	*			"type":"boolean"
	*		},
	*		"scope":{
	*			"type":"string"
	*		},
	*		"name":{
	*			"type":"string"
	*		},
	*		"id":{
	*			"format":"int64",
	*			"type":"integer"
	*		},
	*		"menuMeta":{
	*			"type":"string"
	*		},
	*		"sn":{
	*			"type":"string"
	*		}
	*	}
	*}

* response:
	*{
	*	"type":"object",
	*	"title":"RestObjectResponse«Permission对象»",
	*	"properties":{
	*		"msg":{
	*			"type":"string"
	*		},
	*		"code":{
	*			"format":"int32",
	*			"type":"integer"
	*		},
	*		"data":{
	*			"ref":"#/definitions/Permission对象",
	*			"value":{
	*				"type":"object",
	*				"title":"Permission对象",
	*				"properties":{
	*					"menuIcon":{
	*						"type":"string"
	*					},
	*					"menuPath":{
	*						"type":"string"
	*					},
	*					"pathDepth":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"menuComponent":{
	*						"type":"string"
	*					},
	*					"parentIds":{
	*						"type":"array",
	*						"items":{
	*							"type":"string"
	*						}
	*					},
	*					"orderNum":{
	*						"format":"int32",
	*						"type":"integer"
	*					},
	*					"remark":{
	*						"type":"string"
	*					},
	*					"updateTime":{
	*						"format":"date-time",
	*						"type":"string"
	*					},
	*					"type":{
	*						"description":"权限类型,[MENU(1):菜单]",
	*						"type":"string",
	*						"enum":[
	*							"MENU"
	*						]
	*					},
	*					"parentId":{
	*						"format":"int64",
	*						"type":"integer"
	*					},
	*					"parentNames":{
	*						"type":"array",
	*						"items":{
	*							"type":"string"
	*						}
	*					},
	*					"createTime":{
	*						"format":"date-time",
	*						"type":"string"
	*					},
	*					"enable":{
	*						"description":"是否启用",
	*						"type":"boolean"
	*					},
	*					"scope":{
	*						"type":"string"
	*					},
	*					"name":{
	*						"type":"string"
	*					},
	*					"id":{
	*						"format":"int64",
	*						"type":"integer"
	*					},
	*					"menuMeta":{
	*						"type":"string"
	*					},
	*					"sn":{
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
	*[]

* body:
	*{
	*	"type":"object",
	*	"title":"BaseIdsParams",
	*	"properties":{
	*		"ids":{
	*			"type":"array",
	*			"items":{
	*				"type":"string"
	*			}
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
const remove = (body, params) => {
    return PFApi.apiRequest(
    {
        url: apiPrefix + '/delete',
        method: 'POST',
        data: body,
        params: params
    })
}
export const PermissionApi = {
    /**
     *
     */
    getTree: getTree,
    /**
     *
     */
    save: save,
    /**
     *
     */
    remove: remove
}
