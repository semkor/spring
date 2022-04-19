package com.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class MySpringMvcServlet extends AbstractAnnotationConfigDispatcherServletInitializer  {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {AppConfig.class};
    }


    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    //---------------------------- преобразования с Thymeleaf на UTF-8  -----------------------------------------------

    @Override
    protected Filter[] getServletFilters() {
        final CharacterEncodingFilter encodingFilter = new CharacterEncodingFilter();
            encodingFilter.setEncoding("UTF-8");
            encodingFilter.setForceEncoding(true);
        return new Filter[] { encodingFilter };
    }

    //------------------------------------ lessson7.hw ---------------------------------------------------------------
    @Override
    public void onStartup(ServletContext aServletContext) throws ServletException {
        super.onStartup(aServletContext);
        registerHiddenFieldFilter(aServletContext);
    }

    private void registerHiddenFieldFilter(ServletContext aContext) {
        aContext.addFilter("hiddenHttpMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null ,true, "/*");
    }
}
