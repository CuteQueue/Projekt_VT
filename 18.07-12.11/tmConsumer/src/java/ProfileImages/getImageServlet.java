
package ProfileImages;

import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* <h1>getImageServlet</h1>
* Das Servlet holt eine Bilddatei 
* zur passenden UserID aus der 
* profiles-Tabelle der Datenbank.
* <p>
*
* @author  Nina Gödde und Manuela Reker
* @version 1.0
* @since   2016-07-11
*/
public class getImageServlet extends HttpServlet {
    
    //Servlet holt Bild (wenn vorhanden) zur passenden UserID aus der Datenbank.
    
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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
       
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Connection con = null;
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/trvmate_db?zeroDateTimeBehavior=convertToNull", "root", "root");

        ResultSet rs = null;
        PreparedStatement pstmt = null;
        OutputStream image;
        try {
        pstmt = con.prepareStatement("SELECT image FROM profils WHERE user_id = ?");
        pstmt.setInt(1, user_id);
        rs = pstmt.executeQuery();
            if(rs.next()) {
                byte byteArray[] = rs.getBytes(1);
                response.setContentType("image/gif");
                image=response.getOutputStream();
                image.write(byteArray);
                image.flush();
                image.close();
            }
        }
        catch(Exception ex){
            System.out.println("No profile image found.");
        }finally {
            try{
            if(con!=null)
               con.close();
            }catch(Exception ex){
               System.out.println("getImage err 64");
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getImageServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getImageServlet.class.getName()).log(Level.SEVERE, null, ex);
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
