// 将会与远程获取的枚举合并

import MyApi from "../../application/api/MyApi";

const localDictList = {
    local_Enable: [
        {label: '开启', value: true},
        {label: '关闭', value: false}
    ]
}
const constants = {
    state: {
        dictList: {}
    },
    mutations: {
        SET_DICT_LIST: (state, dictList) => {
            state.dictList = dictList
        }
    },
    actions: {
        GetEnumFormatValue({commit}) {
            return new Promise((resolve, reject) => {
                    MyApi.genApi.ConstantApi.dict().then(rep => {
                        commit('SET_DICT_LIST', Object.assign(rep.data, localDictList))
                        resolve()
                    }).catch(error => {
                        reject(error)
                    })
                }
            )
        }
    }
}

export default constants
