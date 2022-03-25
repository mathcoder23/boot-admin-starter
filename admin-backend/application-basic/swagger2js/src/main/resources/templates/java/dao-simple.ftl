package ${cur.dao.package};

import com.young.global.db.bean.model.${cur.dao.name};
import com.young.global.db.dao.SimpleDao;

/**
* @author ${context.author}
* @date ${context.genDate}
*/
public interface ${cur.dao.name}SimpleDao extends SimpleDao<${cur.dao.name}, ${cur.dao.idType}>, ${cur.dao.name}ComplexDao {

}
