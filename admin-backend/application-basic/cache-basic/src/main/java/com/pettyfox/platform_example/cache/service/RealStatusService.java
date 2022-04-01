package com.pettyfox.platform_example.cache.service;

import com.pettyfox.platform_example.cache.dto.RealStatusDTO;

import java.util.List;
import java.util.Map;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/13</p>
 * <p></p>
 *
 * @author Petty Fox
 * @version 1.0
 */
public interface RealStatusService {

    /**
     * 写入实时状态信息，并附带状态的TTL时间
     *
     * @param key 所属组
     * @param id       唯一id
     * @param online   是否在线
     * @param desc     描述
     * @param meta     附加信息
     * @param ttl      秒，失效时间
     */
    void putStatusTtl(String key, String id, boolean online, String desc, Map<String, String> meta, int ttl);

    void putStatus(String key, String id, boolean online, String desc, Map<String, String> meta);

    void delStatus(String key, String id);

    RealStatusDTO getStatus(String key, String id);

    List<RealStatusDTO> listOnline(String key);
}
