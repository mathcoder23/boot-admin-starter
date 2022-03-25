/**
*  note: 该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2021-08-18 10:00:51
*  mbg-author: Petty Fox
*  description: 统一生成Api调用聚合
*  template-version: v1.0.0
*/
import { SystemConfigApi } from './api/config/SystemConfigApi'
import { RoleApi } from './api/sys/RoleApi'
import { WebsocketApi } from './api/message/WebsocketApi'
import { SystemLogApi } from './api/sys/SystemLogApi'
import { ConstantApi } from './api/ConstantApi'
import { AccountApi } from './api/sys/AccountApi'
import { PermissionApi } from './api/sys/PermissionApi'
import { RolePermissionApi } from './api/account/RolePermissionApi'

export default {
    SystemConfigApi,
    RoleApi,
    WebsocketApi,
    SystemLogApi,
    ConstantApi,
    AccountApi,
    PermissionApi,
    RolePermissionApi
}
