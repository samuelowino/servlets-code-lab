package org.apluscreators.servletlabs;

import org.apluscreators.servletlabs.controler.HomeController;
import org.apluscreators.servletlabs.controler.ServletsLabsRootController;
import org.apluscreators.servletlabs.controler.UserProfileController;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

public class ServletLabsApplication {

    private TemplateEngine templateEngine;
    private Map<String, ServletsLabsRootController> rootControllerByURL;

    public ServletLabsApplication(final ServletContext servletContext) {

        super();

        ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver(servletContext);

        templateResolver.setTemplateMode(TemplateMode.HTML);
        templateResolver.setPrefix("/WEB-INF/templates/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheTTLMs(3600000L);

        templateResolver.setCacheable(true);

        this.templateEngine = new TemplateEngine();

        this.templateEngine.setTemplateResolver(templateResolver);

        this.rootControllerByURL = new HashMap<>();
        this.rootControllerByURL.put("/", new HomeController());
        this.rootControllerByURL.put("/userprofile", new UserProfileController());
    }

    public ServletsLabsRootController resolveControllerForRequest(final HttpServletRequest request){
        final String path = getRequestPath(request);
        return this.rootControllerByURL.get(path);
    }

    public ITemplateEngine getTemplateEngine() {
        return this.templateEngine;
    }

    private static String getRequestPath(final HttpServletRequest request){

        String requestURI = request.getRequestURI();
        final String contextPath = request.getContextPath();

        final int fragmentIndex = requestURI.indexOf(';');

        if (fragmentIndex != -1){
            requestURI = requestURI.substring(0, fragmentIndex);
        }

        if (requestURI.startsWith(contextPath)) {
            return requestURI.substring(contextPath.length());
        }

        return requestURI;
    }
}
