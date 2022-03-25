package com.pettyfox.platform_example.config.domain.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.pettyfox.platform_example.config.domain.biz.ConfigSystemBiz;
import com.pettyfox.platform_example.config.domain.po.SystemConfig;
import com.pettyfox.platform_example.config.domain.repository.SystemConfigMapper;
import com.pettyfox.platform_example.config.interfaces.assembler.ConfigSystemAssembler;
import com.pettyfox.platform_example.config.interfaces.dto.data.SystemConfigModifyData;
import com.pettyfox.platform_example.config.interfaces.dto.vo.SystemConfigVO;
import com.pettyfox.platform_example.config.interfaces.facade.dto.ConfigEdit;
import org.pettyfox.base.web.dao.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConfigSystemBizImpl extends BaseService<SystemConfigMapper, SystemConfig> implements ConfigSystemBiz {

    @Override
    public List<SystemConfigVO> listAll() {
        return this.list().stream().map(ConfigSystemAssembler::convert).collect(Collectors.toList());
    }

    @Override
    public void simpleBatchModify(List<SystemConfigModifyData> list) {
        if (null == list || list.isEmpty()) {
            return;
        }
        List<SystemConfig> systemConfigs = list.stream().map(d -> {
            SystemConfig config = new SystemConfig();
            config.setId(d.getId());
            config.setValue(d.getValue());
            return config;
        }).collect(Collectors.toList());
        this.updateBatchById(systemConfigs);
    }

    @Override
    public SystemConfig getByConfigKey(String key) {
        LambdaQueryWrapper<SystemConfig> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(SystemConfig::getConfigKey, key);
        return getOne(queryWrapper);
    }

    @Override
    public void saveByConfigKey(ConfigEdit configEdit) {

        LambdaUpdateWrapper<SystemConfig> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.eq(SystemConfig::getConfigKey, configEdit.getKey());
        updateWrapper.set(SystemConfig::getValue, configEdit.getValue());
        this.update(updateWrapper);
    }
}
