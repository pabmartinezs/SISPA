package sispa.presentacion;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sispa.dto.escuelaDTO;
import sispa.persisntencia.EscuelaSessionBean;

@WebServlet(name = "EscuelaCargarListaServlet", urlPatterns = {"/escuelaCargarListaServlet"})
public class EscuelaCargarListaServlet extends HttpServlet {

    @EJB
    private EscuelaSessionBean objEscuelaSessionBean;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        List<escuelaDTO> listaEscuela = new LinkedList<>();
        try {
            listaEscuela = this.objEscuelaSessionBean.escuelaGetALL();
        } catch (Exception e) {
        }
        sesion.setAttribute("ListaEscuela", listaEscuela);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
