package sispa.persisntencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sispa.dto.solicitudFullDTO;

@Stateless
public class PedidoSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public List<solicitudFullDTO>allSolicitud(){
        return em.createNamedQuery("SolicitudPedido.Listar", solicitudFullDTO.class)
                .getResultList();
    }
}
