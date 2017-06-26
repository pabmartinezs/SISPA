package sispa.persisntencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sispa.dto.menuperfilDTO;

@Stateless
public class MenuSessionBean {
    @PersistenceContext
    private EntityManager em;
    
    public List<menuperfilDTO>allMenu(){
        return em.createNamedQuery("Menu.Listar", menuperfilDTO.class)
                .getResultList();
    }  
}
