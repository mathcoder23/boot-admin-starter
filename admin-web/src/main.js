import Vue from 'vue';
import axios from './router/axios';
import VueAxios from 'vue-axios';
import App from './App';
import router from './router/router';
import './permission'; // 权限
import './error'; // 日志
import './cache';//页面缓冲
import store from './store';
import {loadStyle} from './util/util'
import * as urls from '@/config/env';
import Element from 'element-ui';
// 注意Element在vue.config中被忽略了，所以在升级element-ui和axios、vue等基础组件时必须升级cdn下的对应版本
import {
    iconfontUrl,
    iconfontVersion
} from '@/config/env';
import i18n from './lang' // Internationalization
import './styles/common.scss';
import basicBlock from './components/basic-block/main'
import basicContainer from './components/basic-container/main'
import {PFApiConfig} from "./api/config/config";
import mock from './mock/index'
import "./global.scss"
import MyApi from "./application/api/MyApi";

mock.init()
PFApiConfig.init()
Vue.use(router)
Vue.use(VueAxios, axios)
Vue.use(Element, {
    i18n: (key, value) => i18n.t(key, value),
    size: 'small', zIndex: 19950
})
import Avue from '@smallwei/avue';
import '@smallwei/avue/lib/index.css';
Vue.use(Avue, {
    i18n: (key, value) => i18n.t(key, value)
})
//注册全局容器
Vue.component('basicContainer', basicContainer)
Vue.component('basicBlock', basicBlock)
// 加载相关url地址
Object.keys(urls).forEach(key => {
    Vue.prototype[key] = urls[key];
})
Vue.prototype.$api = MyApi
// 动态加载阿里云字体库
iconfontVersion.forEach(ele => {
    loadStyle(iconfontUrl.replace('$key', ele));
})

Vue.config.productionTip = false;

window.MyVue = new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount('#app')
