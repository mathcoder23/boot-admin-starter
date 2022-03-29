package com.pettyfox.platform_example.web.rest;

import cn.hutool.core.util.ClassUtil;
import com.pettyfox.platform_example.web.rest.data.DictData;
import org.pettyfox.base.comm.type.BaseEnum;
import org.pettyfox.base.comm.web.RestObjectResponse;
import org.springframework.web.bind.annotation.*;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Petty Fox
 * @version 1.0
 * @date 2021/4/16 13:27
 */
@RestController
@RequestMapping("/api/constant")
public class DictController {
    @GetMapping("dict")
    public RestObjectResponse<Map<String, List<DictData>>> getDict() {
        Map<String,List<DictData>> result = new HashMap<>(64);
        ClassUtil.scanPackageBySuper("com.pettyfox", BaseEnum.class).forEach(r -> {
            List<DictData> dictDataList = new ArrayList<>();

            String name = r.getName().substring(r.getName().lastIndexOf(".")+1).replace("$","_");
            for (Object e : r.getEnumConstants()) {
                if(e instanceof BaseEnum){
                    DictData dictData = new DictData();
                    BaseEnum ee = (BaseEnum) e;
                    dictData.setValue(String.valueOf(ee));
                    dictData.setLabel(ee.getName());
                    dictDataList.add(dictData);
                }
            }

            result.put(name,dictDataList);

        });

        return RestObjectResponse.ok(result);
    }
    @GetMapping("domain")
    public RestObjectResponse<String> test(@RequestParam("domain")String domain) throws UnknownHostException {
        return RestObjectResponse.ok(InetAddress.getByName(domain).getHostAddress());
    }
}
