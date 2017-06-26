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
import sispa.persisntencia.CategoriaSessionBean;

@WebServlet(name = "CategoriaADDServlet", urlPatterns = {"/categoriaADDServlet"})
public class CategoriaADDServlet extends HttpServlet {

    @EJB
    private CategoriaSessionBean objCategoriaSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        String nombreCategoria = request.getParameter("txtNomrbeCategoriaADD");
        int estado = 1;
        if (nombreCategoria.length() > 1) {
            categoriaDTO catdto = new categoriaDTO(nombreCategoria,estado);
            try {
                this.objCategoriaSessionBean.ADDCategoria(catdto);
                sesion.setAttribute("MSGOKCATADD", "Se ingreso correctamente la nueva Categoria.");
            } catch (Exception e) {
            }
        } else {
            sesion.setAttribute("MSGERRORCATADD", "Se produjo un error al ingresar categoria.");
        }
        response.sendRedirect("CategoriaLST.jsp");
    }

}
