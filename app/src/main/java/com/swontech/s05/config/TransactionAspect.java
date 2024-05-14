package com.swontech.s05.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.interceptor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class TransactionAspect {
    private final PlatformTransactionManager transactionManager;
    public TransactionAspect(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    private final String POINTCUT_EXPRESSION = "execution(* com.swontech.s05.domain.logic..*.*(..))";

    @Bean
    public TransactionInterceptor interceptor() {
        TransactionInterceptor transactionInterceptor = new TransactionInterceptor();
        NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource = new NameMatchTransactionAttributeSource();
        RuleBasedTransactionAttribute ruleBasedTransactionAttribute = new RuleBasedTransactionAttribute();

        ruleBasedTransactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
        ruleBasedTransactionAttribute.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);

        Map<String, TransactionAttribute> transactionMethods = new HashMap<String, TransactionAttribute>();
        transactionMethods.put("*", ruleBasedTransactionAttribute);
        nameMatchTransactionAttributeSource.setNameMap(transactionMethods);

        transactionInterceptor.setTransactionAttributeSource(nameMatchTransactionAttributeSource);
        transactionInterceptor.setTransactionManager(transactionManager);

        return transactionInterceptor;
    }

    @Bean
    public Advisor transactionAdvisor() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression(POINTCUT_EXPRESSION);
        return new DefaultPointcutAdvisor(pointcut, interceptor());
    }
}
