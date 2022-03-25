package ${cur.dao.package};

import com.young.global.db.bean.model.${cur.dao.name};
import ${cur.vo.package}.${cur.dao.name}PageVo;
import com.young.global.boot.bean.Page;
import com.young.global.boot.bean.PageBean;
import com.young.global.db.dao.ComplexDao;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
public interface ${cur.dao.name}ComplexDao extends ComplexDao<${cur.dao.name}, ${cur.dao.idType}> {
    boolean exists(String name, String exceptId);
    PageBean<${cur.dao.name}PageVo> getPage(String name, Page page);
}
