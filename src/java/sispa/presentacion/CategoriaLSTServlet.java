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
import sispa.dto.categoriaDTO;
import sispa.entity.Categoria;
import sispa.persisntencia.CategoriaSessionBean;

@WebServlet(name = "CategoriaLSTServlet", urlPatterns = {"/categoriaLSTServlet"})
public class CategoriaLSTServlet extends HttpServlet {

    @EJB
    private CategoriaSessionBean objCategoriaSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        //List<categoriaDTO> listaCategorias = new LinkedList<>();
        List<Categoria> listaCategorias = new LinkedList<>();
        try {
            listaCategorias = this.objCategoriaSessionBean.categoriaGetALL2();
        } catch (Exception e) {
        }
        
        sesion.setAttribute("LSTCategoria", listaCategorias);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
