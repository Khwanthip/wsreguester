/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.daehosting.webservices.isbn.ISBNService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author 8402-01
 */
@WebServlet(name = "ISBNServlet", urlPatterns = {"/ISBNServlet"})
public class ISBNServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://webservices.daehosting.com/services/isbnservice.wso?WSDL")
    private ISBNService service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ISBNServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1>Servlet ISBNServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet ISBN10 " + isValidISBN10("0486284735") + "</h1>");
            out.println("<h1>Servlet ISBN13 " + isValidISBN13("979-123456-789-6") + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private boolean isValidISBN10(java.lang.String sISBN) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.daehosting.webservices.isbn.ISBNServiceSoapType port = service.getISBNServiceSoap12();
        return port.isValidISBN10(sISBN);
    }

    private boolean isValidISBN13(java.lang.String sISBN) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.daehosting.webservices.isbn.ISBNServiceSoapType port = service.getISBNServiceSoap12();
        return port.isValidISBN13(sISBN);
    }

    private boolean isValidISBN10_1(java.lang.String sISBN) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.daehosting.webservices.isbn.ISBNServiceSoapType port = service.getISBNServiceSoap12();
        return port.isValidISBN10(sISBN);
    }

    private boolean isValidISBN10_2(java.lang.String sISBN) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.daehosting.webservices.isbn.ISBNServiceSoapType port = service.getISBNServiceSoap12();
        return port.isValidISBN10(sISBN);
    }

    private boolean isValidISBN13_1(java.lang.String sISBN) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.daehosting.webservices.isbn.ISBNServiceSoapType port = service.getISBNServiceSoap12();
        return port.isValidISBN13(sISBN);
    }

}
