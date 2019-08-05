package com.zhoujjtech.dubbo.productor;

import com.zhoujjtech.dubbo.facade.IndexFacade;
import org.apache.dubbo.config.annotation.Service;

@Service
public class IndexProductor implements IndexFacade {

    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}