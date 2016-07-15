package travelmate;

/**
 *
 * @author nina
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(urlPatterns = {"/TravelMateServer"})
public class LoginServlet extends HttpServlet {
    
    private Boolean changed = new Boolean(true);
    private Integer clients = new Integer(0);
    private final TravelMate tm = new TravelMate ("TravelMateServer");
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        
        synchronized(clients){
            clients = new Integer(clients.intValue()+1);
        }
        
        while(true){
            synchronized(changed){
                if(changed == true){
                    break;
                }
            }
        }
        
        String caller_ip = request.getRemoteAddr();
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String table;
        if(request.getHeader("Content-type").equals("application/json")){
            table = tm.readContentsJson(caller_ip);
        } else {
            table = tm.readContents(caller_ip);
        }
        try {
            out.println(table);
        } finally {
            out.close();
        }
        
        
        synchronized(clients){
            clients = new Integer(clients.intValue()-1);
            synchronized(changed){
                if(clients.intValue() == 0){
                    changed = new Boolean(false);
                }
            }
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
        //String message = request.getParameterValues("message")[0]; //request.getParameter("message"); //
        // TODO implementation of doPost()!
        BufferedReader br = request.getReader();
        String msg = br.readLine();
        String caller_ip = request.getRemoteAddr();
        response.setContentType("text/html;charset=UTF-8");

        tm.createEntry(msg, caller_ip); 
            synchronized(changed){
                changed = new Boolean(true);
        }
    }

    /**
     * Handles the HTTP <code>DELETE</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            BufferedReader br = request.getReader();
            String idString = request.getHeader("id");
            int id = Integer.parseInt(idString);
            tm.deleteEntry(id);
            synchronized(changed){
                changed = new Boolean(true);
        }
    }
    
    /**
     * Handles the HTTP <code>PUT</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BufferedReader br = request.getReader();
        String msg = br.readLine();
        
        String caller_ip = request.getRemoteAddr();
        String[] aufteilung = msg.split("id=");
        String message = aufteilung[0];
        String idString = aufteilung[1];
        int id = 0;
        if(aufteilung.length==2){
            id = Integer.parseInt(idString);
            response.setContentType("text/html;charset=UTF-8");
            tm.updateEntry(id, message, caller_ip);
        }
        synchronized(changed){
             changed = new Boolean(true);
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
