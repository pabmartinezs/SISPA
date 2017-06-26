package sispa.persisntencia;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sispa.dto.escuelaDTO;

@Stateless
public class EscuelaSessionBean {

    @PersistenceContext(unitName = "sispaPU")
    private EntityManager em;

    public List<escuelaDTO> escuelaGetALL() throws ControladorExceptions {
        return em.createNamedQuery("Escuela.getALL", escuelaDTO.class).getResultList();
    }
    
/*
    public void ADDComuna(ComunaDTO comunaDTO) throws ControladorExceptions {
        try {
            Comuna comunaEntity = new Comuna();
            comunaEntity.setNombreComuna(comunaDTO.getNombre_comuna());
            em.persist(comunaEntity);
        } catch (Exception e) {
        }
    }

    public void UPComuna(ComunaDTO comunaDTO) throws ControladorExceptions {
        try {
            Comuna comunaEntity = new Comuna();
            comunaEntity.setNombreComuna(comunaDTO.getNombre_comuna());
            comunaEntity.setIdComuna(comunaDTO.getId_comuna());
            em.merge(comunaEntity);
        } catch (Exception e) {
        }
    }

    public void DELCliente(int id) throws ControladorExceptions {
        try {
            Comuna comunaEntity = em.find(Comuna.class, id);
            em.remove(comunaEntity);
        } catch (Exception e) {
        }
    }

    public ComunaDTO comunaBuscarPorId(int id) throws ControladorExceptions {
        ComunaDTO infoComuna = null;
        try {
            infoComuna = em.createNamedQuery("Comuna.buscarPorID", ComunaDTO.class)
                    .setParameter("idComuna", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infoComuna;
    }

    public ComunaDTO comunaBuscarPorNombre(String id) throws ControladorExceptions {
        ComunaDTO infoComuna = null;
        try {
            infoComuna = em.createNamedQuery("Comuna.buscarPorNombre", ComunaDTO.class)
                    .setParameter("nombreComuna", id)
                    .getSingleResult();
        } catch (NoResultException ex) {
            return null;
        } catch (NonUniqueResultException ex) {
            throw ex;
        }
        return infoComuna;
    }*/
}
