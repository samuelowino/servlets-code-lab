package org.apluscreators.servletlabs.controler;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;

public class HomeController implements ServletsLabsRootController {


    public HomeController() {
        super();
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse servletResponse, ServletContext servletContext, ITemplateEngine iTemplateEngine) throws IOException {
        WebContext webContext = new WebContext(request,servletResponse,servletContext,request.getLocale());
        webContext.setVariable("today", Calendar.getInstance());

        iTemplateEngine.process("home",webContext,servletResponse.getWriter());
    }
}
