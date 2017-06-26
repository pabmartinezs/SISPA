package sispa.presentacion;

import java.io.IOException;
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

@WebServlet(name = "CategoriaUPServlet", urlPatterns = {"/categoriaUPServlet"})
public class CategoriaUPServlet extends HttpServlet {

    @EJB
    private CategoriaSessionBean objCategoriaSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int id = Integer.parseInt(request.getParameter("IDCAT"));
        Categoria infoDTO = null;
        try {
           infoDTO = this.objCategoriaSessionBean.BuscarPorId(id);
        } catch (Exception e) {
        }
        sesion.setAttribute("INFOCAT", infoDTO);
        response.sendRedirect("CategoriaUP2.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String nomcat = request.getParameter("txtNomrbeCategoriaUP");
        int estado = Integer.parseInt(request.getParameter("txtEstadoCategoriaup"));
        categoriaDTO catdto = new categoriaDTO(nomcat,estado);
        Categoria infocatdto = (Categoria) sesion.getAttribute("INFOCAT");
        if (infocatdto != null) {
            catdto.setId_categoria(infocatdto.getIdCategoria());
            try {
                this.objCategoriaSessionBean.UPCategoria(catdto);
            } catch (Exception e) {
            }
        }
        response.sendRedirect("CategoriaLST.jsp");
    }
}
