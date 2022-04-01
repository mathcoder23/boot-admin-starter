package org.pettyfox.base.utils;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import org.pettyfox.base.comm.exception.DirtyException;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Copyright: Copyright (c) 2021</p>
 * <p>Description: Created by Petty Fox on 2021/9/7</p>
 * <p></p>
 *
 * @author Petty Fox
 */
public class CommAssembler {


    public static <PO, VO> PageInfo<VO> convert(PageInfo<PO> pageInfo, Class<VO> voClazz) {
        PageInfo<VO> result = new PageInfo<VO>(CommAssembler.convert(pageInfo.getList(), voClazz));
        result.setTotal(pageInfo.getTotal());
        return result;
    }

    public static <PO, VO> List<VO> convert(List<PO> list, Class<VO> voClazz) {
        return list.stream().map(po -> {
            try {
                VO vo = voClazz.newInstance();
                BeanUtil.copyProperties(po, vo);
                return vo;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());
    }

    public static <ED, PO> PO convert(ED edit, Class<PO> poClass) {
        try {
            PO po = poClass.newInstance();
            BeanUtil.copyProperties(edit, po);
            return po;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        throw new DirtyException("assembler failed");
    }

}
