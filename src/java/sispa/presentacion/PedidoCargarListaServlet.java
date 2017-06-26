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
import sispa.dto.solicitudFullDTO;
import sispa.dto.usuarioescuelaperfilDTO;
import sispa.persisntencia.PedidoSessionBean;

@WebServlet(name = "PedidoCargarListaServlet", urlPatterns = {"/pedidoCargarListaServlet"})
public class PedidoCargarListaServlet extends HttpServlet {

    @EJB
    private PedidoSessionBean objPedidoSessionBean;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        usuarioescuelaperfilDTO objusuarioescuelaperfilDTO = (usuarioescuelaperfilDTO)sesion.getAttribute("UsuarioConectado");
        List<solicitudFullDTO> ListaPedidos = new LinkedList<>();
        List<solicitudFullDTO> ListaPedidos2 = new LinkedList<>();
        try {
            ListaPedidos = this.objPedidoSessionBean.allSolicitud();
        } catch (Exception e) {
        }
        for(solicitudFullDTO solicitud:ListaPedidos){
            if(solicitud.getObjusuario().getIdUsuario().equals(objusuarioescuelaperfilDTO.getObjusuario().getIdUsuario())){
                ListaPedidos2.add(solicitud);
            }
        }
        sesion.setAttribute("SolicitudesUsuario", ListaPedidos2);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
