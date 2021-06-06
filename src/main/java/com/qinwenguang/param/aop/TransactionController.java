package com.qinwenguang.param.aop;

import java.lang.annotation.Target;
import java.lang.reflect.Method;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;


/**
 * 打印出controller所调用的方法：也就是请求路径<br>
 * 打印出controller方法传入的参数
 * 打印出controller方法传入的返回值
 * @author qinwenguang 
 */

@Aspect
@Component
public class TransactionController {

	/**
	 * 配置拦截规则
	 * 项目名称更改之后也不用管，只需要符合com.qinwenguang.项目名.模块名.controller配置即可
	 * */
	@Pointcut("execution(public * com.qinwenguang.*.*.*.*(..))")
	public void point(){
	}

	//环绕通知
	@Around("point()")
	public Object  around(ProceedingJoinPoint pjd) throws Throwable{
		System.out.println();
		
		// 获取目标类名
        String className = pjd.getTarget().getClass().getName();
        Logger log = Logger.getLogger(className);
        log.info("className: "+ className);
        
        //获取实现类中的方法名称
        Signature sig = pjd.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjd.getTarget();
        Method methodName = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        log.info("methodName: "+ methodName.getName()+"()");
        
        Object[] args = pjd.getArgs();
        String params = "params: ";
        //获取请求参数集合并进行遍历拼接
        for(int i=0;i<args.length&&args[i]!=null;i++) {
        	params += args[i].toString();
        	if(i != args.length-1) {
        		params +=  ",";
        	}
        }
        log.info(params);
        
		Object result = pjd.proceed();
        // 打印返回报文
        log.info("result:"+ result+"\n");
		return result;
	}
}
