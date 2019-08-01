package com.zhoujjtech.imports;

import com.zhoujjtech.service.IndexService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 动态是否需要开启使用
 */
public class IndexImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[] {IndexService.class.getName()};
    }
}
