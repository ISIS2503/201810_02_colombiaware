package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.ContrasenaEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ks.estupinan
 */
public class ContrasenaPersistence extends Persistencer<ContrasenaEntity, String>{
    
    EntityManager em;
    public ContrasenaPersistence(){
        this.em  = JPAConnection.CONNECTION.getEntityManager();
    }
    
    public ContrasenaEntity buscarPorHorarioInicial(String horario) {
        TypedQuery<ContrasenaEntity> q = em.createQuery("select p from ContrasenaEntity p where (p.horarioInicio = :horario)", ContrasenaEntity.class);
        q.setParameter("horario", horario);
        List<ContrasenaEntity> results = q.getResultList();
        ContrasenaEntity contrasena = null;
        if (results == null) {
            contrasena = null;
        } else if (results.isEmpty()) {
            contrasena = null;
        } else if (results.size() >= 1) {
            contrasena = results.get(0);
        }

        return contrasena;
    }

    public ContrasenaEntity buscarPorHorarioFinal(String horario) {
        TypedQuery<ContrasenaEntity> q = em.createQuery("select p from ContrasenaEntity p where (p.horarioFin = :horario)", ContrasenaEntity.class);
        q.setParameter("horario", horario);
        List<ContrasenaEntity> results = q.getResultList();
        ContrasenaEntity contrasena = null;
        if (results == null) {
            contrasena = null;
        } else if (results.isEmpty()) {
            contrasena = null;
        } else if (results.size() >= 1) {
            contrasena = results.get(0);
        }

        return contrasena;
    }
    
}
