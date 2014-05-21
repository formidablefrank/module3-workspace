package com.example;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopAspect {
	
	@Pointcut("execution(* com.example.AopTargetInterface.getMessage(..))")
	//powerful wild carding: any return type with any params of getMessage
	public void pointCutMethod() {
		
	}
	
	@Before("pointCutMethod()")
	public void beforeEntry(){
		System.out.println("Hello from before advice of AopAspect");
	}
	
	@After("pointCutMethod()")
	public void afterExit(){
		System.out.println("Hello from after advice of AopAspect");
	}
	
	@Around("pointCutMethod()")
	public Object doSomethingAround(ProceedingJoinPoint joinPoint){
		System.out.println("Around-Before");
		Object retval = null;
		try{
			//control over the method execution
			System.out.println(joinPoint.getTarget());
			retval = joinPoint.proceed();
			retval = ((String) retval).toUpperCase();
		} catch(Throwable e) {
			System.out.println("something went wrong");
		}
		System.out.println("Around-After");
		return retval;
	}
}
