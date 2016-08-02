package tm;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
 *
 * @author nina
 */
public class CreateProfileServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/travelmate_vs/tmWebService.wsdl")
    private TmWebService_Service service;

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
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            System.out.println("!!!!!!!!!!!!!!!!!!! SessionIP ChatOnServlet: " + session.getAttribute("serverIp"));
            if (session.getAttribute("email") == null) {
                out.println("<html><head><title>SessionError</title></head>");
                out.println("<body><h2>Keine Session vorhanden</h2>");
                //out.print("<form action=\"http://"+session.getAttribute("ip")+":8080/webChat\"");
                out.print("<form action=\"http://"+session.getAttribute("serverIp")+":8080/tmConsumer\"");
                out.println("\" method=\"POST\" >");
                out.println("<br><br><input type=\"submit\" value=\"Startseite\">");
                out.println("</form>");
                out.println("</body>");
                out.close();
                return;
            }
            String email = (String) session.getAttribute("email");
            User u = new User(email);
            session.setAttribute("user", u); //in Session gespeichert 
            User user = (User) session.getAttribute("user");

            System.out.println("CreateProfileServlet");

            String mobilenumber = request.getParameterValues("mobilenumber")[0];

            String ageString = request.getParameterValues("age")[0];
            int age = Integer.parseInt(ageString);

            String location = request.getParameterValues("location")[0];
            String sex = request.getParameterValues("sex")[0];
            String destination = request.getParameterValues("destination")[0];

            String startdate = request.getParameterValues("startdate")[0];
            // String startdate = java.sql.Date.valueOf(startdateString); 

            String interests = request.getParameterValues("interests")[0];
            String looking_for = request.getParameterValues("looking_for")[0];
            String about = request.getParameterValues("about")[0];

            String answer = createProfile(user.getId(), mobilenumber, age, location, sex, destination, startdate, interests, looking_for, about);

            if (answer.equals("ok")) {
                request.getRequestDispatcher("/Home").forward(request, response);
                //response.sendRedirect("Home");
            } else {
                //out.println("Ooooops, something went wrong!");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Please check all inputs, something seems to be missing.');");
                out.println("location='http://"+session.getAttribute("serverIp")+":8080/tmConsumer/Create\';");
                out.println("</script>");  
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

    private String createProfile(int id, java.lang.String mobilenumber, int age, java.lang.String location, java.lang.String sex, java.lang.String destination, java.lang.String startdate, java.lang.String interests, java.lang.String lookingFor, java.lang.String about) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.createProfile(id, mobilenumber, age, location, sex, destination, startdate, interests, lookingFor, about);
    }

}
