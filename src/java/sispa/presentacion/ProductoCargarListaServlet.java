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
import sispa.dto.productofullDTO;
import sispa.persisntencia.ProductoSessionBean;

@WebServlet(name = "ProductoCargarListaServlet", urlPatterns = {"/productoCargarListaServlet"})
public class ProductoCargarListaServlet extends HttpServlet {

    @EJB
    private ProductoSessionBean objProductoSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        List<productofullDTO> ListaProductos = new LinkedList<>();
        try {
            ListaProductos = this.objProductoSessionBean.getAll();
        } catch (Exception e) {
        }
        sesion.setAttribute("ListaProductos", ListaProductos);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
