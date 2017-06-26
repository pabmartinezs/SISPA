package sispa.persisntencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sispa.dto.perfilDTO;

@Stateless
public class PerfilSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public List<perfilDTO> listarPerfilnAll() {
        return em.createNamedQuery("Perfil.getAll", perfilDTO.class)
                .getResultList();
    }
}
