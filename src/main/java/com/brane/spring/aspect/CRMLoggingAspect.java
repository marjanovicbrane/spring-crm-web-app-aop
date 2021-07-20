package com.brane.spring.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//We are using here AspectJ annotation for AOP, to tell our app that this class is ASPECT
@Aspect
@Component
public class CRMLoggingAspect {
	
	//we are using logger just for debugging aspects
	private Logger mylogger=Logger.getLogger(getClass().getName());
	
	
	//We are using @Before ADVICE TYPE.
	//Now we calling combined pointcut declaration forAppFlow() from class AopExpressions
	//JoinPoint will give us meta data about our target method (metgod signature).
	@Before("com.brane.spring.aspect.AopExpressions.forAppFlow()")
	public void before(JoinPoint joinpoint) {
		
		//we are going to show method which we are calling
		String method=joinpoint.getSignature().toShortString();
		mylogger.info("=====>We are in @Before advice, calling method is : "+method);
		
		//we are going to show arguments of the method
		Object[] arguments=joinpoint.getArgs();
		
		for(Object arg:arguments) {
			
			//log that arguments(objects)
			mylogger.info("=====>Method arguments are : "+arg);
		}
	}
	
}
