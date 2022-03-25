package com.pettyfox.platform_example.account.domain.biz;

import com.baomidou.mybatisplus.extension.service.IService;
import com.pettyfox.platform_example.account.domain.po.Department;
import com.pettyfox.platform_example.account.interfaces.dto.vo.DepartmentVO;
import com.github.pagehelper.PageInfo;
import org.pettyfox.base.web.dto.params.BasePageParam;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author Petty Fox
 * @since 2021-04-14
 */
public interface DepartmentBiz extends IService<Department> {

    PageInfo<DepartmentVO> list(BasePageParam p);
}
