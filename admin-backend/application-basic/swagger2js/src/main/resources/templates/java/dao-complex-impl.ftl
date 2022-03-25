package ${cur.dao.package}.impl;

import ${cur.vo.package}.${cur.dao.name}PageVo;
import ${cur.dao.package}.${cur.dao.name}ComplexDao;
import com.young.global.boot.bean.Page;
import com.young.global.boot.bean.PageBean;
import com.young.global.db.bean.model.BaseModel;
import com.young.global.db.bean.model.${cur.dao.name};
import com.young.global.db.dao.impl.ComplexDaoImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
@Repository
public class ${cur.dao.name}ComplexDaoImpl extends ComplexDaoImpl<${cur.dao.name}, ${cur.dao.idType}> implements ${cur.dao.name}ComplexDao {
    @Override
    public boolean exists(String name, String exceptId) {

        String where = "WHERE o.name=:name ";

        Map<String, Object> params = new HashMap<>(5);

        params.put("name", name);

        if (null != exceptId) {
        where += "AND o.id!=:exceptId ";
        params.put("exceptId", exceptId);
        }

        return super.exists(where, params);
    }

    @Override
    public PageBean<${cur.dao.name}PageVo> getPage(String name, Page page) {

        String hql = String.format("SELECT " +
                "o.id AS id " +
                "FROM %s o " +
                "WHERE 1=1 ", getClassName());

        Map<String, Object> params = new HashMap<>(1);

        if (StringUtils.isNotBlank(name)) {
        hql += "AND o.name LIKE :name ";
        params.put("name", super.returnLikeContaining(name));
        }

        return super.getPageByHql(hql, params, BaseModel.DEFAULT_CREATE_DATETIME_DESC_ORDERS, page, ${cur.dao.name}PageVo.class);
    }
}
