import Mock from 'mockjs'

const top = [{
    label: "首页",
    path: "/wel/index",
    icon: 'el-icon-document',
    meta: {
        i18n: 'dashboard',
    },
    parentId: 0
},
    // {
    //     label: "官网",
    //     icon: 'el-icon-document',
    //     meta: {
    //         menu: false,
    //         i18n: 'website',
    //     },
    //     path: "https://avuejs.com",
    //     parentId: 1
    // },
    // {
    //     label: "测试",
    //     icon: 'el-icon-document',
    //     path: "/test/index",
    //     meta: {
    //         i18n: '测试',
    //     },
    //     parentId: 2
    // },
    // {
    //     label: "更多",
    //     icon: 'el-icon-document',
    //     path: "/wel/dashboard",
    //     meta: {
    //         menu: false,
    //         i18n: 'more',
    //     },
    //     parentId: 3
    // }
]
const first = [{
    label: "缓冲",
    path: '/cache',
    component: 'views/util/cache',
    icon: 'icon-caidan',
    meta: {
        i18n: 'cache',
        keepAlive: true
    },
    children: []
}, {
    label: "标签",
    path: '/tags',
    component: 'views/util/tags',
    icon: 'icon-caidan',
    meta: {
        i18n: 'tags',
    },
    children: []
}, {
    label: "存储",
    path: '/store',
    component: 'views/util/store',
    icon: 'icon-caidan',
    meta: {
        i18n: 'store',
    },
    children: []
}, {
    label: "全局函数",
    path: 'https://avuejs.com/doc/api?test1=1&test2=2',
    icon: 'icon-caidan',
    meta: {
        i18n: 'api',
    }
}, {
    label: "日志监控",
    path: '/logs',
    component: 'views/util/logs',
    icon: 'icon-caidan',
    meta: {
        i18n: 'logs',
    },
    children: []
}, {
    label: "表格",
    path: '/table',
    component: 'views/util/table',
    icon: 'icon-caidan',
    meta: {
        i18n: 'table',
    },
    children: []
}, {
    label: "表单",
    path: '/form',
    component: 'views/util/form',
    icon: 'icon-caidan',
    meta: {
        i18n: 'form'
    },
    children: []
}, {
    label: "权限",
    path: '/permission',
    component: 'views/util/permission',
    icon: 'icon-caidan',
    meta: {
        i18n: 'permission',
    },
    children: []
}, {
    label: "返回顶部",
    path: '/top',
    component: 'views/util/top',
    icon: 'icon-caidan',
    meta: {
        i18n: 'top',
    },
    children: []
}, {
    label: "表格表单",
    path: '/crud-form',
    component: 'views/util/crud-form',
    icon: 'icon-caidan',
    meta: {
        i18n: 'crudForm',
    },
    children: []
}, {
    label: "图钉",
    path: '/affix',
    component: 'views/util/affix',
    icon: 'icon-caidan',
    meta: {
        i18n: 'affix',
    },
    children: []
}, {
    label: "异常页",
    path: '/error',
    meta: {
        i18n: 'error',
    },
    icon: 'icon-caidan',
    children: [{
        label: "403",
        path: 'error',
        component: 'components/error-page/403',
        icon: 'icon-caidan',
        children: []
    }, {
        label: "404",
        path: '404',
        component: 'components/error-page/404',
        icon: 'icon-caidan',
        children: []
    }, {
        label: "500",
        path: '500',
        component: 'components/error-page/500',
        icon: 'icon-caidan',
        children: []
    }]
}]
const second = [
    {
        label: "首页",
        path: '/test',
        component: 'views/test',
        icon: 'icon-caidan',
        meta: {
            i18n: '首页',
        },
        children: []
    },
    {
        label: "运行日志",
        path: '/log',
        component: 'views/test',
        icon: 'el-icon-s-order',
        meta: {
            i18n: '运行日志',
        },
        children: [
            {
                label: "系统日志",
                path: 'system-log',
                component: 'my-views/system-log/SystemLog',
                meta: {
                    i18n: '系统日志'
                }
            },
            {
                label: "操作日志",
                path: 'option-log',
                component: 'my-views/system-log/SystemLogOption',
                meta: {
                    i18n: '操作日志'
                }
            }
        ]
    },
]
const third = [{
    label: "访问控制管理",
    path: '/acl',
    component: 'views/acl',
    icon: 'icon-caidan',
    meta: {
        i18n: '访问控制管理',
    },
    children: [{
        label: "用户管理",
        path: 'user',
        component: 'views/acl/user/UserAccount',
        icon: 'icon-caidan',
        meta: {
            i18n: '用户管理',
        },
        children: []
    },{
        label: "角色管理",
        path: 'role',
        component: 'views/acl/role/Role',
        icon: 'icon-caidan',
        meta: {
            i18n: '角色管理',
        },
        children: []
    }, {
        label: "权限管理",
        path: 'permission',
        component: 'views/acl/permission/Permission',
        icon: 'icon-caidan',
        meta: {
            i18n: '权限管理',
        },
        children: []
    }]
}]
import {baseUrl} from '@/config/env';

export default ({mock}) => {
    if (!mock) return;
    let menu = [third]
    Mock.mock(baseUrl + '/user/getMenu', 'get', (res) => {
        let body = JSON.parse(res.body);
        return {
            data: menu[body.type] || []
        }
    })
    Mock.mock(baseUrl + '/user/getTopMenu', 'get', () => {
        return {
            data: top
        }
    })

}
