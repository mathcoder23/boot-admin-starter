import MyApi from "../../application/api/MyApi";
import {PFApiConfig} from "../../api/config/config";

export const PfApiPlug = {
    init: (Vue) => {
        PFApiConfig.init()
        Vue.prototype.$api = MyApi
    }
}