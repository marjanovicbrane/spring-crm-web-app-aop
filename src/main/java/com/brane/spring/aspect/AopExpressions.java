package com.brane.spring.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

//We are using here AspectJ annotation for AOP, to tell our app that this class is ASPECT
@Aspect
public class AopExpressions {
	
		//we are going to set here pointcut declarations

		@Pointcut("execution(* com.brane.spring.controller.*.*(..))")
		public void forControllerPackage() {}
		
		@Pointcut("execution(* com.brane.spring.service.*.*(..))")
		public void forServicePackage() {}
		
		@Pointcut("execution(* com.brane.spring.dao.*.*(..))")
		public void forDaoPackage() {}
		
		//we are going to combined pointcut declarations together,
		//because we want to have matching for these only 3 packages.
		@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
		public void forAppFlow() {}
}
