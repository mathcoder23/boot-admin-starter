package com.pettyfox.platform_example.cache.service.impl;

import com.pettyfox.platform_example.cache.dto.RealStatusDTO;
import com.pettyfox.platform_example.cache.service.RealStatusService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by eface .FW on 2021/10/12</p>
 * <p></p>
 *
 * @author eface .FW
 */
@Component
public class RealStatusServiceImpl implements RealStatusService {

    @Resource
    private RedisTemplate<String, RealStatusDTO> redisTemplate;

    @Override
    public void putStatusTtl(String redisKey, String id, boolean online, String desc, Map<String, String> meta, int ttl) {
        RealStatusDTO realStatusDTO = new RealStatusDTO();
        realStatusDTO.setId(id);
        realStatusDTO.setOnline(online);
        realStatusDTO.setDesc(desc);
        realStatusDTO.setMeta(meta);
        String key = buildKey(redisKey, id);
        redisTemplate.opsForValue().set(key, realStatusDTO);
        if (ttl > 0) {
            redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
        }
    }

    @Override
    public void putStatus(String redisKey, String id, boolean online, String desc, Map<String, String> meta) {
        putStatusTtl(redisKey, id, online, desc, meta, -1);
    }

    @Override
    public void delStatus(String redisKey, String id) {
        redisTemplate.delete(buildKey(redisKey, id));
    }

    @Override
    public RealStatusDTO getStatus(String redisKey, String id) {
        RealStatusDTO dto = redisTemplate.opsForValue().get(buildKey(redisKey, id));
        return dto;
    }

    @Override
    public List<RealStatusDTO> listOnline(String key) {
        Set<String> keys = redisTemplate.keys(key + "*");
        if (CollectionUtils.isEmpty(keys)) {
            return null;
        }
        ValueOperations<String, RealStatusDTO> operations = redisTemplate.opsForValue();
        return keys.stream().map(operations::get).filter(Objects::nonNull).filter(RealStatusDTO::getOnline).collect(Collectors.toList());
    }

    private String buildKey(String redisKey, String id) {
        return redisKey + "::" + id;
    }
}
