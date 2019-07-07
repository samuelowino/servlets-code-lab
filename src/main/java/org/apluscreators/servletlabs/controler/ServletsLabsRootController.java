package org.apluscreators.servletlabs.controler;

import org.thymeleaf.ITemplateEngine;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ServletsLabsRootController {

    public void process(HttpServletRequest request, HttpServletResponse servletResponse,
                        ServletContext servletContext,
                        ITemplateEngine iTemplateEngine) throws IOException;
}
