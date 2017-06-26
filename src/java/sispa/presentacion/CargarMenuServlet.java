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
import sispa.dto.menuperfilDTO;
import sispa.dto.usuarioescuelaperfilDTO;
import sispa.persisntencia.MenuSessionBean;

@WebServlet(name = "CargarMenuServlet", urlPatterns = {"/cargarMenuServlet"})
public class CargarMenuServlet extends HttpServlet {

    @EJB
    private MenuSessionBean objMenuSessionBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        usuarioescuelaperfilDTO objusuarioescuelaperfilDTO = (usuarioescuelaperfilDTO)sesion.getAttribute("UsuarioConectado");
        List<menuperfilDTO> listaMenu = objMenuSessionBean.allMenu();
        List<menuperfilDTO> listaMenu2=new LinkedList<>();
        for (menuperfilDTO menuPerfilDTO : listaMenu) {
            if (menuPerfilDTO.getObjmenu().getPerfilCodPerfil().getIdPerfil().equals(objusuarioescuelaperfilDTO.getObjperfil().getIdPerfil())) {
                listaMenu2.add(menuPerfilDTO);
            }
        }
        sesion.setAttribute("listaMenu", listaMenu2);    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
