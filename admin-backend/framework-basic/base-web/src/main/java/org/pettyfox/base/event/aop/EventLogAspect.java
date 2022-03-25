package org.pettyfox.base.event.aop;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.pettyfox.base.event.PackagePettyTool;
import org.pettyfox.base.event.config.EventLogConfig;
import org.springframework.stereotype.Component;

/**
 * 打印事件对应的类、方法、参数、参数值信息，根据 注解@EventLong来启用日志，
 * 但是事件是否打印日志根据配置来决定
 *
 * @author eface
 * @see org.pettyfox.base.event.aop.EventLog
 */
@Aspect
@Component
@Slf4j
public class EventLogAspect {

    @Pointcut("@annotation(org.pettyfox.base.event.aop.EventLog)")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint joinPoint) {
        EventLog annotation = ((MethodSignature) joinPoint.getSignature()).getMethod().getAnnotation(EventLog.class);
        EventLogStrategy strategy = annotation.strategy();
        Object[] args = joinPoint.getArgs();
        if (args.length == 0) {
            return;
        }
        if (strategy == EventLogStrategy.DISABLE) {
            return;
        } else if (strategy == EventLogStrategy.CONFIG) {
            if (!EventLogConfig.hasEnableLog(args[0])) {
                return;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Object arg : args) {
            sb.append(arg.getClass().getTypeName())
                    .append("=>")
                    .append(JSON.toJSONString(arg));
            if (sb.length() > 1024) {
                sb.append("....");
                break;
            }
        }
        log.debug("event log : event:{}.{} params:{}", PackagePettyTool.packagePetty(joinPoint.getSignature().getDeclaringTypeName()), PackagePettyTool.packagePetty(joinPoint.getSignature().getName()), sb);
    }


}