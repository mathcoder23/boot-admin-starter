package com.pettyfox.platform_example.cache.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/10/12</p>
 * <p></p>
 *
 * @author Petty Fox
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RealStatusDTO implements Serializable {

    private String id;
    private Boolean online;
    private String desc;
    private Map<String, String> meta;

}
