package tm;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;
import webservice.TmWebService_Service;

/**
 *
 * @author nina & manuela
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
        request.setCharacterEncoding("UTF-8");
        response.setHeader("Cache-Control", "no-cache"); //Forces caches to obtain a new copy of the page from the origin server
        response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance
        response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale"
        response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
        try (PrintWriter out = response.getWriter()) {
            
            HttpSession session = request.getSession(true);
            if (session.getAttribute("email") == null) {
                out.println("<html><head><title>SessionError</title></head>");
                out.println("<body><h2>Keine Session vorhanden</h2>");
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
            
            String mobilenumber,location,ageString,sex,destination,startdate,interests,looking_for,about;
            int age;
            
            try{mobilenumber = request.getParameterValues("mobilenumber")[0];}catch(Exception err){mobilenumber=null;};
            try{ageString = request.getParameterValues("age")[0];
                age = Integer.parseInt(ageString);}catch(Exception err){age=0;};
            try{location = request.getParameterValues("location")[0];
                location = location.replaceAll("ß", "ss");
                }catch(Exception err){location=null;};
            try{sex = request.getParameterValues("sex")[0];}catch(Exception err){sex=null;};
            try{destination = request.getParameterValues("destination")[0];
                destination = destination.replaceAll("ß", "ss");
                }catch(Exception err){destination=null;};
            try{startdate = request.getParameterValues("startdate")[0];}catch(Exception err){startdate=null;};
            try{interests = request.getParameterValues("interests")[0];
                destination = destination.replaceAll("ß", "ss");
                }catch(Exception err){interests=null;};
            try{looking_for = request.getParameterValues("looking_for")[0];
                looking_for = looking_for.replaceAll("ß", "ss");
                }catch(Exception err){looking_for=null;};
            try{about = request.getParameterValues("about")[0];
                about = about.replaceAll("ß", "ss");
                }catch(Exception err){about=null;};

            String answer = createProfile(user.getId(), mobilenumber, age, location, sex, destination, startdate, interests, looking_for, about);

            if (answer.equals("ok")) {
                request.getRequestDispatcher("/toProfil").forward(request, response);
            } else {
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
        webservice.TmWebService port = service.getTmWebServicePort();
        return port.createProfile(id, mobilenumber, age, location, sex, destination, startdate, interests, lookingFor, about);
    }

}
