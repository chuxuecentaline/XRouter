package com.xrouter.compiler;


import com.google.auto.service.AutoService;
import com.xrouter.annotation.BindView;
import com.xrouter.annotation.Interceptor;
import com.xrouter.compiler.util.TextUtils;

import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;

/**
 * 编译时注解
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 21:00
 */
@AutoService(Processor.class)
public class InterceptorProcessor  extends AbstractProcessor {
    private Elements mElementUtils;
    private Filer mFiler;
    private final String KEY_MODULE_NAME = "moduleName";
    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);
        mFiler = processingEnv.getFiler();
        mElementUtils = processingEnv.getElementUtils();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> types = new LinkedHashSet<>();
        for (Class<? extends Annotation> annotation : getSupportedAnnotations()) {
            types.add(annotation.getCanonicalName());
        }
        return types;
    }

    private Set<Class<? extends Annotation>> getSupportedAnnotations() {
        Set<Class<? extends Annotation>> annotations = new LinkedHashSet<>();
        // 需要解析的自定义注解 BindView  OnClick
        annotations.add(Interceptor.class);
        return annotations;
    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // 1. 有没配置 modelName 防止 class 类冲突
        String moduleName = "";
        Map<String, String> options = processingEnv.getOptions();
        if(isNotEmpty(options)){
             moduleName = options.get(KEY_MODULE_NAME);

        }
        System.out.println("moduleName = " + moduleName);
        if (!TextUtils.isEmpty(moduleName)) {
            moduleName = moduleName.replaceAll("[^0-9a-zA-Z_]+", "");
        } else {
            String errorMessage = "These no module name, at 'build.gradle', like :\n" +
                    "apt {\n" +
                    "    arguments {\n" +
                    "        moduleName project.getName();\n" +
                    "    }\n" +
                    "}\n";
            throw new RuntimeException("DRouter::Compiler >>> No module name, for more information, look at gradle log.\n" + errorMessage);
        }
        //解析到所有的Action 信息
        Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Interceptor
                .class);
        for (Element element : elements) {

        }
        return false;
    }

    private boolean isNotEmpty(Map<String, String> options) {
        return options!=null&&!options.isEmpty();
    }
}
