/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import dao.FileDao;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.OurFile;
import util.MyFileUtils;

/**
 *
 * @author glamb
 */
public class UploadServlet extends HttpServlet {

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
            out.println("<title>Servlet UploadServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UploadServlet at " + request.getContextPath() + "</h1>");
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

        String fileId = request.getParameter("fileId");

        FileDao fdao = new FileDao();
        OurFile f = fdao.getFileById(Integer.parseInt(fileId));

        //converting to inputStream in order to pass it to response's outputStream
        InputStream inputStream = new ByteArrayInputStream(f.getMyFile());
        //inputStream now has the file 

        //configuring the type of the file
        ServletContext context = getServletContext();
        String mimetype = context.getMimeType(f.getFileName());
        
        //checking if mimetype is null
        if (mimetype == null) {
            mimetype = "application/octet-stream";
        }
        
        response.setContentType(mimetype);
        //Output stream from response
        OutputStream outStream = response.getOutputStream();

        //fill outputStream
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            /*
             το condition θα παρει τα πρωτα 4096 bytes (4Kb) κ θα τα βαλει στ buffer, μετα θα τα 
             περασει στ outStream. To bytesRead κραταει ποσα bytes εχουν διαβαστει κ στην ουσια 
             τ λεει απο που να ξεκινησει το επομενο write. Για παραδειγμα μετα την πρωτη loopa θα εχει 
             τιμή 4097 αν το αρχειο ειναι μεγαλυτερο απο 4096 bytes 
             */
            outStream.write(buffer, 0, bytesRead);
        }

        inputStream.close();
        outStream.close();

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
        request.setCharacterEncoding("UTF-8");
        Part p = request.getPart("myfile");

        OurFile f = new OurFile();
        f.setFileName(p.getSubmittedFileName());
        f.setMyFile(MyFileUtils.convertInputStreamToByteArray(p.getInputStream()));

        FileDao fdao = new FileDao();
        fdao.insertFile(f);
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

}
