package sispa.persisntencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceContext;
import sispa.dto.categoriaDTO;
import sispa.entity.Categoria;

@Stateless
public class CategoriaSessionBean {

    @PersistenceContext(unitName = "sispaPU")
    private EntityManager em;

    public List<categoriaDTO> categoriaGetALL() throws ControladorExceptions {
        return em.createNamedQuery("Categoria.getALL", categoriaDTO.class).getResultList();
    }
    public List<Categoria> categoriaGetALL2() throws ControladorExceptions {
        return em.createNamedQuery("Categoria.findAll", Categoria.class).getResultList();
    }
    public void ADDCategoria(categoriaDTO catDTO) throws ControladorExceptions {
        try {
            Categoria categoriaEntity = new Categoria();
            categoriaEntity.setNombreCategoria(catDTO.getDescripcion_categoria());
            categoriaEntity.setEstadoCategoria(catDTO.getEstado_categoria());
            em.persist(categoriaEntity);
        } catch (Exception e) {
        }
    }
    
    public void UPCategoria(categoriaDTO catDTO) throws ControladorExceptions {
        try {
            Categoria catEntity = new Categoria();
            catEntity.setNombreCategoria(catDTO.getDescripcion_categoria());
            catEntity.setEstadoCategoria(catDTO.getEstado_categoria());
            catEntity.setIdCategoria(catDTO.getId_categoria());
            em.merge(catEntity);
        } catch (Exception e) {
        }
    }

    public void DELCategoria(int idCategoria) throws ControladorExceptions {
        try {
            Categoria catEntity = em.find(Categoria.class, idCategoria);
            em.remove(catEntity);
        } catch (Exception e) {
        }
    }

    public Categoria BuscarPorId(int id) throws ControladorExceptions {
        Categoria infoDTO = null;
        try {
            infoDTO = em.createNamedQuery("Categoria.findByIdCategoria", Categoria.class)
                    .setParameter("idCategoria", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infoDTO;
    }
}
