package com.zhoujjtech.dubbo.consumer;


import com.zhoujjtech.dubbo.facade.IndexFacade;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

//@Component
public class IndexComsumer {

    @Reference
    private IndexFacade indexFacade;

    public void sayHello() {
        System.out.println(indexFacade.sayHello("zhoujj"));
    }
}
