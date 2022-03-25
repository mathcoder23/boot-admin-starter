package com.pettyfox.platform_example.config.interfaces.facade.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by eface .FW on 2021/9/13</p>
 * <p></p>
 *
 * @author eface .FW
 */
@Getter
@Setter
public class ConfigEdit implements Serializable {

    private String key;
    private String value;
}
