package ${cur.biz.package}.impl;

import ${cur.vo.package}.${cur.dao.name}PageVo;
import ${cur.vo.package}.${cur.dao.name}Vo;
import ${cur.biz.package}.${cur.dao.name}Biz;
import ${cur.controller.package}.params.${cur.dao.name}EditParams;
import ${cur.controller.package}.params.${cur.dao.name}PageParams;
import ${cur.dao.package}.${cur.dao.name}SimpleDao;
import com.young.global.boot.bean.PageBean;
import com.young.global.boot.controller.params.BaseIdParams;
import com.young.global.boot.controller.params.BaseIdsParams;
import com.young.global.boot.enumeration.TransCode;
import com.young.global.boot.exception.TransException;
import com.young.global.db.bean.model.${cur.dao.name};
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
@Slf4j
@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class ${cur.dao.name}BizImpl implements ${cur.dao.name}Biz {
    private ${cur.dao.name}SimpleDao dao;

    @Autowired
    public void set${cur.dao.name}SimpleDao(${cur.dao.name}SimpleDao dao) {
        this.dao = dao;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void edit(${cur.dao.name}EditParams p) throws TransException {

        if (dao.exists(p.getName(), p.getId())) {
        throw new TransException(TransCode.CUSTOM_EXCEPTION_MSG, "名称已存在");
        }
        ${cur.dao.name} m;
        if (StringUtils.isNotBlank(p.getId())) {
            Optional<${cur.dao.name}> o = dao.findById(p.getId());
            if (!o.isPresent()) {
                throw new TransException(TransCode.RECORD_NOT_EXIST);
            }
            m = o.get();
        } else {
            m = new ${cur.dao.name}();
        }
        m.modify(p);
        dao.save(m);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(BaseIdsParams<${cur.dao.idType}> p) throws TransException {
        p.validate();

        dao.deleteByIds( p.getIds());
    }


    @Override
    public ${cur.dao.name}Vo get(BaseIdParams<${cur.dao.idType}> p) throws TransException {
        p.validate();

        Optional<${cur.dao.name}> o = dao.findById(p.getId());

            if (!o.isPresent()) {
                throw new TransException(TransCode.RECORD_NOT_EXIST);
            }

        ${cur.dao.name} r = o.get();
        ${cur.dao.name}Vo vo = new ${cur.dao.name}Vo();
        return vo;
    }

    @Override
    public PageBean<${cur.dao.name}PageVo> getPage(${cur.dao.name}PageParams p) throws TransException {
        p.validate();
        return dao.getPage(p.getName(), p.getPage());
    }
}
