package com;

import com.lesson4.hw2.MyConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


//этот класс заменяет  web.xml
public class MySpringMvcServlet extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};  //для lesson4.hw2 правильно писать {MyConfig.class}
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
