package sispa.persisntencia;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import sispa.dto.usuarioescuelaperfilDTO;

@Stateless
public class UsuarioSessionBean {

    @PersistenceContext(unitName = "sispaPU")
    private EntityManager em;
    
    public usuarioescuelaperfilDTO ValidarLogin(String login, String pass) throws ControladorExceptions {
        usuarioescuelaperfilDTO infousuarioescuelaperfilDTO = null;
        try {
            infousuarioescuelaperfilDTO = em.createNamedQuery("Usuario.validar", usuarioescuelaperfilDTO.class)
                    .setParameter("usernameUsuario", login)
                    .setParameter("passUsuario", pass)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infousuarioescuelaperfilDTO;
    }
}
