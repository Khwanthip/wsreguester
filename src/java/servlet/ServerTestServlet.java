package servlet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.daehosting.webservices.isbn.ISBNService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.tempuri.Calculator;

/**
 *
 * @author 8402-01
 */
@WebServlet(urlPatterns = {"/ServerTestServlet"})
public class ServerTestServlet extends HttpServlet {
    
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.dneonline.com/calculator.asmx.wsdl")
    private Calculator service;

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
            out.println("<title>Servlet ServerTestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h1><center>Servlet ServerTestServlet at " + "</center></h1>");
            
            int a = 6;
            int b = 3;
            int result1 = add (a,b);
            int result2 = divide (a,b);
            int result3 = multiply (a,b);
            int result4 = subtract (a,b);
            out.println("<h2><center>Add 6+3 = " + result1 +"</center></h2>");
            out.println("<h2><center>Divide 6/3 = " + result2 +"</center></h2>");
            out.println("<h2><center>Multiply 6*3 = " + result3 +"</center></h2>");
            out.println("<h2><center>Subtract 6-3 = " + result4 +"</center></h2>");
            
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

    private int add(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.add(intA, intB);
    }

    private int divide(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.divide(intA, intB);
    }

    private int multiply(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.multiply(intA, intB);
    }

    private int subtract(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.subtract(intA, intB);
    }
    
}
