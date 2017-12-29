package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import model.ModelProduct;

public class FirstAspect {
    // SLF4J Logging
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    // Method Before Advice
    public void Before(JoinPoint jp) {
        logger.debug("################## Before ##################");
        // getSignature().getName() : 호출되는 메서드 명을 리턴
        logger.debug("호출되는 메서드 : " + jp.getSignature().getName());
        // jp.getArgs().toString() : 매개변수로 넘어오는 것을 출력
        logger.debug("매개변수 : " + jp.getArgs().toString());
        logger.debug("################## Before ##################");
    }
    
    // Method After Advice
    // 반환값이 없는 경우 사용
    public void After() {
        logger.debug("################## After ##################");
        logger.debug("Method After");
        logger.debug("################## After ##################");
    }
    
    // Method After Returning Advice
    // 반환값이 있는경우 사용
    // ModelProduct product가 반환되는 값
    public void AfterReturning(JoinPoint jp, ModelProduct product) {
        logger.debug("################## After Returning ##################");
        logger.debug("호출되는 메서드 : " + jp.getSignature().getName());
        logger.debug("매개변수 : " + jp.getArgs().toString());
        logger.debug("################## After Returning ##################");
    }
    
    // Method Around Advice
    // Method 실행 전후에 실행됨
    public Object Around(ProceedingJoinPoint jp) throws Throwable {
        logger.debug("################## Around Before ##################");
        logger.debug("################## Around Before ##################");
        
        Object p = jp.proceed();
        
        logger.debug("################## Around After ##################");
        logger.debug("################## Around After ##################");
        
        return p;
    }
    
    // Method AfterThrowing(Throwable e)
    // Method 실행 중 예외가 발생 했을 때 실행
    public void AfterThrowing(Throwable e) {
        logger.debug("################## AfterThrowing ##################");
        logger.debug("Exception value :" + e.getMessage());
        logger.debug("################## AfterThrowing ##################");
    }
}
