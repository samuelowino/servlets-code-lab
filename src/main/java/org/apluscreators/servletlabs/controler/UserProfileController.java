package org.apluscreators.servletlabs.controler;

import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.context.WebContext;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProfileController implements ServletsLabsRootController {


    public UserProfileController() {
        super();
    }

    @Override
    public void process(HttpServletRequest request, HttpServletResponse servletResponse,
                        ServletContext servletContext,
                        ITemplateEngine iTemplateEngine) throws IOException {

        final WebContext webContext = new WebContext(request,servletResponse,servletContext,request.getLocale());
        iTemplateEngine.process("userprofile",webContext,servletResponse.getWriter());

    }
}
