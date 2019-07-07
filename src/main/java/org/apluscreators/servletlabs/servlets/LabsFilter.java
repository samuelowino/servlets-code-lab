package org.apluscreators.servletlabs.servlets;


import org.apluscreators.servletlabs.ServletLabsApplication;
import org.apluscreators.servletlabs.controler.ServletsLabsRootController;
import org.apluscreators.servletlabs.model.User;
import org.apluscreators.servletlabs.service.UsersService;
import org.thymeleaf.ITemplateEngine;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LabsFilter implements Filter {


    private ServletContext servletContext;
    private ServletLabsApplication application;

    public LabsFilter() {
        super();
    }

    private static void addUserToSession(final HttpServletRequest request) {
        UsersService usersService = new UsersService();
        User user = usersService.getUser();
        request.getSession(true).setAttribute("user", user);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
        this.application = new ServletLabsApplication(this.servletContext);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        addUserToSession((HttpServletRequest) request);

        if (!process((HttpServletRequest) request, (HttpServletResponse) response)) {
            chain.doFilter(request,response);
        }
    }

    private boolean process(HttpServletRequest request, HttpServletResponse response) throws ServletException {

        try {

            if (request.getRequestURI().startsWith("/css") ||
                    request.getRequestURI().startsWith("/images") ||
                    request.getRequestURI().startsWith("/favicon")) {
                return false;
            }

            /**
             * Query controller/URL mapping and obtain the controller
             * that will process the request. If no controller is available
             * return false and let other filters/servlets process the request
             */

            ServletsLabsRootController labsController = this.application.resolveControllerForRequest(request);

            if (labsController == null) {
                return false;
            }

            /**
             * Obtain the template engine instance
             */
            ITemplateEngine templateEngine = this.application.getTemplateEngine();

            /**
             * Write the response headers
             */
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Chache-Control","no-chache");
            response.setDateHeader("Expires",0);

            /**
             * Execute the controller and process view template,
             * writing the results to the response write
             */

            labsController.process(request,response,this.servletContext,templateEngine);

            return true;

        } catch (Exception ex) {
            try {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }catch (final IOException ignored) {

            }

            throw new ServletException(ex);
        }

    }

    @Override
    public void destroy() {

    }
}
