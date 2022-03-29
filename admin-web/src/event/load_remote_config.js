import {SystemConfigApi} from "../application/api/genApi/api/config/SystemConfigApi";
import {ConstantApi} from "../application/api/genApi/api/ConstantApi";

export const LoadRemoteConfig = {
    // 加载站点配置
    loadSiteConfig: (vue) => {
        SystemConfigApi.getConfigByKey({
                key: "PUBLIC_WEB_CONFIG",
                pfPublic: true
            }
        ).then(rep => {
            try {
                let config = JSON.parse(rep.data.value)

                vue.$store.commit("SET_PUBLIC_WEB_CONFIG", config)
            } catch (e) {
                console.log('load remote config', rep)
                vue.$message.error("加载站点配置失败")
            }

        })
    },
    // 加载字典配置
    loadDictConfig: (vue) => {
        ConstantApi.dict({
        }).then(rep => {
            vue.$store.commit('SET_DICT_LIST', rep.data)
        })

    }
}