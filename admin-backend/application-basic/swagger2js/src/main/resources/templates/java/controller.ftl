package ${cur.controller.package};

import ${cur.vo.package}.${cur.dao.name}PageVo;
import ${cur.vo.package}.${cur.dao.name}Vo;
import ${cur.biz.package}.${cur.dao.name}Biz;
import ${cur.controller.package}.params.${cur.dao.name}EditParams;
import ${cur.controller.package}.params.${cur.dao.name}PageParams;
import com.young.global.boot.annotation.EnableLogRecord;
import com.young.global.boot.bean.DataResponse;
import com.young.global.boot.bean.NoDataResponse;
import com.young.global.boot.bean.PageBean;
import com.young.global.boot.controller.params.BaseIdParams;
import com.young.global.boot.controller.params.BaseIdsParams;
import com.young.global.boot.exception.TransException;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
@RestController
public class ${cur.dao.name}Controller extends BaseController {
    private ${cur.dao.name}Biz biz;

    @Autowired
    public void set${cur.dao.name}Biz(${cur.dao.name}Biz biz) {
        this.biz = biz;
    }

    @RequiresPermissions(value = {"${cur.dao.name2}:edit"})
    @EnableLogRecord
    @RequestMapping(value = "/${cur.dao.name2}/edit", method = RequestMethod.POST)
    public NoDataResponse edit(@Validated @RequestBody ${cur.dao.name}EditParams p) throws TransException {

        biz.edit(p);

        return ok();
    }

    @RequiresPermissions(value = {"${cur.dao.name2}:delete"})
    @EnableLogRecord
    @RequestMapping(value = "/${cur.dao.name2}/delete", method = RequestMethod.POST)
    public NoDataResponse delete(@RequestBody BaseIdsParams<${cur.dao.idType}> p) throws TransException {

        biz.delete(p);

        return ok();
    }

    @RequiresPermissions(value = {"${cur.dao.name2}:get"})
    @EnableLogRecord
    @RequestMapping(value = "/${cur.dao.name2}/get", method = RequestMethod.POST)
    public DataResponse<${cur.dao.name}Vo> get(@RequestBody BaseIdParams<${cur.dao.idType}> p) throws TransException {
        return ok(biz.get(p));
    }

    @RequiresPermissions(value = {"${cur.dao.name2}:getPage"})
    @EnableLogRecord
    @RequestMapping(value = "/${cur.dao.name2}/getPage", method = {RequestMethod.POST})
    public DataResponse<PageBean<${cur.dao.name}PageVo>> getPage(@RequestBody ${cur.dao.name}PageParams p) throws TransException {
        return ok(biz.getPage(p));
    }
}
