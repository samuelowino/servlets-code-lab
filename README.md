# Servlet

Public interface servlet
Define methods that all servlets must implement.
A servlet is a small java program that runs within a web server. Servlets receive and respond to requests from Web clients, usually across HTTP, the hypertext Transfer Protocol.

To implement this interface, you can write a generic servlet that extends javax.servlet.GenericServlet or an HTTP servlet that extends java.servlet.HttpServlet.

This interface defines methods to initialize a servlet, to service requests, and to remove a servlet from the server. These are known as life-cycle methods and are called in the following sequence:

The servlet is constructed, then initialized with the init method.
Any calls from clients to the service method are handled.
The servlet is taken out of service, then destroyed with the destroy method, then garbage collected and finalized.

In addition to the life cycle methods, this interface provides the getServletConfig method, which the servlet can use to get any startup information, and the getServletInfo method, which allows the servlet to return basic information about itself, such as author, version and copyright.



# Servlet Config

Public interface ServletConfig

A servlet configuration object used by a servlet container to pass information to a servlet during initialization.

# Method Summary

getInitParameter(String paramName) -> String
Gets the value of the initialization parameter with the given name.
getInitParameterNames()
Returns the names of the servlet’s initialization parameters as an Enumeration of String objects, or an empty Enumeration of the servlet has no initialization parameters.
getServletContext
Returns a reference to the ServletContext in which the caller is executing.
getServletName
Returns the name of this servlet instance.

# Servlet Context

Public interface ServletContext

Defines a set of methods that a servlet uses to communicate with its servlet container, for example, to get the MIME type of a file, dispatch requests, or write to a log file.

There is one context per web application.

The servletContext object is contained within the ServletConfig object, which the web server provides the servlet when the servlet is initialized.

Generic Servlet

Public abstract class GenericServlet

Defines a generic, protocol independent servlet. To write an HTTP servlet for use in the web, extend HttpServlet instead.

GenericServlet implements the Servlet and ServletConfig interface may be directly extended by a servlet, although its more common to extend a protocol-specific subclass such as HttpServlet. 
