package com.pettyfox.platform_example.config.domain.biz;


import com.pettyfox.platform_example.config.domain.po.SystemConfig;
import com.pettyfox.platform_example.config.interfaces.dto.data.SystemConfigModifyData;
import com.pettyfox.platform_example.config.interfaces.dto.vo.SystemConfigVO;
import com.pettyfox.platform_example.config.interfaces.facade.dto.ConfigEdit;

import java.util.List;

public interface ConfigSystemBiz {

    List<SystemConfigVO> listAll();

    void simpleBatchModify(List<SystemConfigModifyData> list);

    SystemConfig getByConfigKey(String key);

    void saveByConfigKey(ConfigEdit configEdit);
}
