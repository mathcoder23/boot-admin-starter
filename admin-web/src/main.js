import {Framework} from "../framework/main";
import {MyApi} from "./api/MyApi";
import {FrameworkIoc} from "../framework/ioc/framework_ioc";

FrameworkIoc.initApi(MyApi)


Framework.run()
