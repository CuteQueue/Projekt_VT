
package tm;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
* <h1>UploadImageServlet</h1>
* Das Servlet lädt eine Bilddatei in 
* die profiles-Tabelle der Datenbank trvmate_db
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/

@MultipartConfig(maxFileSize = 16177215) // upload file bis zu 16MB
public class UploadImageServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/travelmate_vs/tmWebService.wsdl")
    private TmWebService_Service service;
    
    private String dbURL = "jdbc:mysql://localhost:3306/trvmate_db?zeroDateTimeBehavior=convertToNull";
    private String dbUser = "root";
    private String dbPass = "root";
    
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
        // gets values of text fields
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma","no-cache"); //HTTP 1.0 backward compatibility
        HttpSession session = request.getSession(true);
        
        InputStream inputStream = null; 
         
        Part filePart = request.getPart("image");
        if (filePart != null) {
            inputStream = filePart.getInputStream();
        }
         
        Connection conn = null; 
        String message = null; 
         
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
 
            String sql = "UPDATE profils SET image = ? WHERE user_id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            User user = (User)session.getAttribute("user");
            int userId = user.getId();
            statement.setInt(2, userId);
             
            if (inputStream != null) {
                statement.setBlob(1, inputStream);
            }
 
            int result = statement.executeUpdate();
            if (result > 0) {
                message = "File uploaded and saved into database";
            }
        } catch (Exception ex) {
            message = "ERROR: " + ex.getMessage();
            ex.printStackTrace();
        } finally {
            if (conn != null) {
                // schließt Datenbankverbindung
                try {
                    conn.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }       
            RequestDispatcher rd = request.getRequestDispatcher("profile.jsp");
            rd.forward(request, response);
        }
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
