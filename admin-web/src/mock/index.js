import user from './user';
import menu from './menu';

/**
 * 模拟数据mock
 * 
 * mock是否开启模拟数据拦截
 */

export default {
    init:()=>{

        user({ mock: true });
        menu({ mock: true });
        console.log('init mock')
    }
}
