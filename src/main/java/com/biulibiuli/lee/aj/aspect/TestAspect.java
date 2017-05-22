package com.biulibiuli.lee.aj.aspect;

import android.util.Log;

import com.biulibiuli.lee.aj.Tools.StopWatch;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;



/**
 * Created by lee on 2017/5/17.
 */
@Aspect
public class TestAspect  {

//  define point cut methods, execution and call methods;
    private static final String EXECUTION_METHOD = "execution(* org.gnucash.android..*(..))";
    private static final String CALL_METHOD = "call(* org.gnucash.android..*(..))";
    private static final String CONSTRUCT_METHOD = "execution(*.new(..)) && within(org.gnucash.android..*)";

    //point cuts
    @Pointcut(EXECUTION_METHOD)
    public void TimingMethod(){}
    @Pointcut(CALL_METHOD)
    public void CallMethod(){}
    @Pointcut(CONSTRUCT_METHOD)
    public void ObjectCreateMethod(){}


    /**
     * Use StopWatch Class to
     * time every method executed in the package
     * print out start time, end time and the time duration
     * and Method name and class name
     * */
    @Around("TimingMethod()")
    public Object aronudWeaverPoint(ProceedingJoinPoint joinPoint) throws Throwable {

//        time the method
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object obj = joinPoint.proceed();
        stopWatch.stop();

        // get the class name and the method name
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();

//        print out the info to the logcat
        Log.i("Time:","Method of "+methodName+" at the class" + className + "" +
                "  start at :" + stopWatch.getStartTime() +"    end at :" + stopWatch.getEndTime() +""
                + "    running for :" + stopWatch.getTotalTimeMillis() + "ns"
            );

//        return the returned object of the original method
        return  obj;
    }


    /**
     * before each method is called, log the caller class and caller method
     * */
    @Before("CallMethod()")
    public void beforecall(JoinPoint joinPoint){

        String callerClass = "";
        String callerMethod = "";

        // get the method name and class name
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String className = signature.getDeclaringType().getSimpleName();
        String methodName = signature.getName();


        // caller name and caller method
        // use the stack info to get the caller info
        StackTraceElement element = Thread.currentThread().getStackTrace()[3];
        callerMethod = element.getMethodName();
        callerClass = element.getClassName();

        // log out the relation
        Log.i("Call!!!",
                "method :"+methodName+"  at "+className+"---------is called by "+callerClass+" with :"+callerMethod );
    }

    /**
     * Listen to all the construction method is calling
     * and note the object is going to create at the certain time point
     * */
    @Before("ObjectCreateMethod()")
    public void constructLisener(JoinPoint joinPoint){

        String className = joinPoint.getTarget().getClass().getName();

        Log.e("Create", "--------------Object create--------- " +
                        "     "+className +"at "+ System.nanoTime());
    }
}
