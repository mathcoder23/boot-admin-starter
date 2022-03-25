package ${cur.biz.package};

import ${cur.vo.package}.${cur.dao.name}PageVo;
import ${cur.vo.package}.${cur.dao.name}Vo;
import ${cur.controller.package}.params.${cur.dao.name}EditParams;
import ${cur.controller.package}.params.${cur.dao.name}PageParams;
import com.young.global.boot.bean.PageBean;
import com.young.global.boot.controller.params.BaseIdParams;
import com.young.global.boot.controller.params.BaseIdsParams;
import com.young.global.boot.exception.TransException;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
public interface ${cur.dao.name}Biz {

    void edit(${cur.dao.name}EditParams p) throws TransException;

    void delete(BaseIdsParams<${cur.dao.idType}> p) throws TransException;

    ${cur.dao.name}Vo get(BaseIdParams<${cur.dao.idType}> p) throws TransException;

    PageBean<${cur.dao.name}PageVo> getPage(${cur.dao.name}PageParams p) throws TransException;
}
