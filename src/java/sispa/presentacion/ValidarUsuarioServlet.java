package sispa.presentacion;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sispa.dto.usuarioescuelaperfilDTO;
import sispa.persisntencia.UsuarioSessionBean;

@WebServlet(name = "ValidarUsuarioServlet", urlPatterns = {"/validarUsuarioServlet"})
public class ValidarUsuarioServlet extends HttpServlet {

    @EJB
    private UsuarioSessionBean objUsuarioSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String login = request.getParameter("txtUsername");
        String pass = request.getParameter("txtPass");
        usuarioescuelaperfilDTO infousuarioescuelaperfilDTO =null;
        try {
            infousuarioescuelaperfilDTO = this.objUsuarioSessionBean.ValidarLogin(login, pass);
        } catch (Exception e) {
        }
        if(infousuarioescuelaperfilDTO != null){
            sesion.setAttribute("UsuarioConectado", infousuarioescuelaperfilDTO);
            response.sendRedirect("Home.jsp");
        }else{
            sesion.setAttribute("MsgError", "El usuario no existe");
            response.sendRedirect("Login.jsp");
        }
    }

}
