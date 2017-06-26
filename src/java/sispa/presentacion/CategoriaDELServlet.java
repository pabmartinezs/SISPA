package sispa.presentacion;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sispa.persisntencia.CategoriaSessionBean;

@WebServlet(name = "CatedoriaDELServlet", urlPatterns = {"/categoriaDELServlet"})
public class CategoriaDELServlet extends HttpServlet {

    @EJB
    private CategoriaSessionBean objCategoriaSessionBean;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        int id = Integer.parseInt(request.getParameter("IDCAT"));
        try {
            this.objCategoriaSessionBean.DELCategoria(id);
        } catch (Exception e) {
        }
        response.sendRedirect("CategoriaLST.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
