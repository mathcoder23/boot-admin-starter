package com.pettyfox.platform_example.business.domain.po;

import com.baomidou.mybatisplus.annotation.TableName;
import org.pettyfox.base.web.dao.BaseEntitySnowId;
import lombok.*;

/**
 * <p>
 * 
 * </p>
 *
 * @author Petty Fox
 * @since 2022-03-24
 */
@Getter
@Setter
@TableName("t_m_test")
public class Test extends BaseEntitySnowId 
{

    private static final long serialVersionUID = 1L;



    private String name;


}
