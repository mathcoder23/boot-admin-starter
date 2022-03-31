/**
*  note: 该代码全为自动生成，为了不影响代码的持续生成，请不要修改此处代码
*  version:
*  date:  2022-03-31 22:45:29
*  mbg-author: Petty Fox
*  description: 统一生成Api调用聚合
*  template-version: v1.0.0
*/
import { SystemConfigApi } from './api/config/SystemConfigApi'
import { RoleApi } from './api/sys/RoleApi'
import { WebsocketApi } from './api/message/WebsocketApi'
import { SystemLogApi } from './api/sys/SystemLogApi'
import { ConstantApi } from './api/ConstantApi'
import { DepartmentApi } from './api/sys/DepartmentApi'
import { PermissionApi } from './api/sys/PermissionApi'
import { AccountApi } from './api/sys/AccountApi'
import { RolePermissionApi } from './api/account/RolePermissionApi'

export default {
    SystemConfigApi,
    RoleApi,
    WebsocketApi,
    SystemLogApi,
    ConstantApi,
    DepartmentApi,
    PermissionApi,
    AccountApi,
    RolePermissionApi
}
