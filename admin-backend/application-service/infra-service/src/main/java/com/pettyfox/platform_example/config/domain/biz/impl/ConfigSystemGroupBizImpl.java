package com.pettyfox.platform_example.config.domain.biz.impl;

import com.pettyfox.platform_example.config.domain.biz.ConfigSystemBiz;
import com.pettyfox.platform_example.config.domain.biz.ConfigSystemGroupBiz;
import com.pettyfox.platform_example.config.domain.po.SystemConfigGroup;
import com.pettyfox.platform_example.config.domain.repository.SystemConfigGroupMapper;
import com.pettyfox.platform_example.config.interfaces.assembler.ConfigSystemGroupAssembler;
import com.pettyfox.platform_example.config.interfaces.dto.vo.SystemConfigGroupVO;
import com.pettyfox.platform_example.config.interfaces.dto.vo.SystemConfigVO;
import org.pettyfox.base.web.dao.BaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigSystemGroupBizImpl extends BaseService<SystemConfigGroupMapper, SystemConfigGroup> implements ConfigSystemGroupBiz {

    @Resource
    private ConfigSystemBiz configSystemBiz;

    @Override
    public List<SystemConfigGroupVO> getAllConfig() {
        List<SystemConfigGroupVO> groupList = this.list().stream().map(ConfigSystemGroupAssembler::convert).collect(Collectors.toList());
        List<SystemConfigVO> list = configSystemBiz.listAll();

        for (SystemConfigVO system : list) {
            for (SystemConfigGroupVO group : groupList) {
                if (system.getSystemConfigGroupId().equals(group.getId())) {
                    if (null == group.getList()) {
                        group.setList(new ArrayList<>());
                    }
                    group.getList().add(system);
                }
            }
        }
        return groupList;
    }

}
