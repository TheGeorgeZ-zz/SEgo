/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import controlador.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import modelo.Gasto;
import modelo.TipoGasto;

/**
 *
 * @author usuario
 */
public class GastoJpaController implements Serializable {

    public GastoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public GastoJpaController() {
        this.emf = Persistence.createEntityManagerFactory("EgoPU");
    }

    public void create(Gasto gasto) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoGasto codigoTipoGasto = gasto.getCodigoTipoGasto();
            if (codigoTipoGasto != null) {
                codigoTipoGasto = em.getReference(codigoTipoGasto.getClass(), codigoTipoGasto.getCodigoTipoGasto());
                gasto.setCodigoTipoGasto(codigoTipoGasto);
            }
            em.persist(gasto);
            if (codigoTipoGasto != null) {
                codigoTipoGasto.getGastoList().add(gasto);
                codigoTipoGasto = em.merge(codigoTipoGasto);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Gasto gasto) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gasto persistentGasto = em.find(Gasto.class, gasto.getCodigoGasto());
            TipoGasto codigoTipoGastoOld = persistentGasto.getCodigoTipoGasto();
            TipoGasto codigoTipoGastoNew = gasto.getCodigoTipoGasto();
            if (codigoTipoGastoNew != null) {
                codigoTipoGastoNew = em.getReference(codigoTipoGastoNew.getClass(), codigoTipoGastoNew.getCodigoTipoGasto());
                gasto.setCodigoTipoGasto(codigoTipoGastoNew);
            }
            gasto = em.merge(gasto);
            if (codigoTipoGastoOld != null && !codigoTipoGastoOld.equals(codigoTipoGastoNew)) {
                codigoTipoGastoOld.getGastoList().remove(gasto);
                codigoTipoGastoOld = em.merge(codigoTipoGastoOld);
            }
            if (codigoTipoGastoNew != null && !codigoTipoGastoNew.equals(codigoTipoGastoOld)) {
                codigoTipoGastoNew.getGastoList().add(gasto);
                codigoTipoGastoNew = em.merge(codigoTipoGastoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = gasto.getCodigoGasto();
                if (findGasto(id) == null) {
                    throw new NonexistentEntityException("The gasto with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Gasto gasto;
            try {
                gasto = em.getReference(Gasto.class, id);
                gasto.getCodigoGasto();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The gasto with id " + id + " no longer exists.", enfe);
            }
            TipoGasto codigoTipoGasto = gasto.getCodigoTipoGasto();
            if (codigoTipoGasto != null) {
                codigoTipoGasto.getGastoList().remove(gasto);
                codigoTipoGasto = em.merge(codigoTipoGasto);
            }
            em.remove(gasto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Gasto> findGastoEntities() {
        return findGastoEntities(true, -1, -1);
    }

    public List<Gasto> findGastoEntities(int maxResults, int firstResult) {
        return findGastoEntities(false, maxResults, firstResult);
    }

    private List<Gasto> findGastoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Gasto.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Gasto findGasto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Gasto.class, id);
        } finally {
            em.close();
        }
    }

    public int getGastoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Gasto> rt = cq.from(Gasto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
