package com.fundamentos.springboot.fundamentos.bean;

import com.fundamentos.springboot.fundamentos.FundamentosApplication;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

    private MyOperation myOperation;

    private final Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    public MyBeanWithDependencyImplement( MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {

        LOGGER.info("printWithDependency");

        int number = 1;
        LOGGER.debug("number: "+number);
        System.out.println(myOperation.sum(number));
        System.out.println(myOperation.res(number));
        System.out.println("Hola desde bean con dependencia");
    }
}
