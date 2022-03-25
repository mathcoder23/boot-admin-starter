package ${cur.controller.package}.params;

import com.young.global.boot.controller.params.BasePageParams;
import lombok.Getter;
import lombok.Setter;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
@Getter
@Setter
public class ${cur.dao.name}PageParams extends BasePageParams {
    /**
    * 名称
    */
    private String name;
}
