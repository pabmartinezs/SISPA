package sispa.persisntencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sispa.dto.productofullDTO;

@Stateless
public class ProductoSessionBean {

    @PersistenceContext
    private EntityManager em;
    
    public List<productofullDTO> getAll() {
        return em.createNamedQuery("Producto.getAll", productofullDTO.class)
                .getResultList();
    }
}
