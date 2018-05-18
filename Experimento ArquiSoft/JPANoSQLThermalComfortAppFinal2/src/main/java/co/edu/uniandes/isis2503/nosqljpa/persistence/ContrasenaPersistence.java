package co.edu.uniandes.isis2503.nosqljpa.persistence;

import co.edu.uniandes.isis2503.nosqljpa.model.entity.PasswordEntity;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author ks.estupinan
 */
public class ContrasenaPersistence extends Persistencer<PasswordEntity, String>{
    
    EntityManager em;
    public ContrasenaPersistence(){
        this.em  = JPAConnection.CONNECTION.getEntityManager();
    }
    
    public PasswordEntity buscarPorHorarioInicial(String horario) {
        TypedQuery<PasswordEntity> q = em.createQuery("select p from ContrasenaEntity p where (p.horarioInicio = :horario)", PasswordEntity.class);
        q.setParameter("horario", horario);
        List<PasswordEntity> results = q.getResultList();
        PasswordEntity contrasena = null;
        if (results == null) {
            contrasena = null;
        } else if (results.isEmpty()) {
            contrasena = null;
        } else if (results.size() >= 1) {
            contrasena = results.get(0);
        }

        return contrasena;
    }

    public PasswordEntity buscarPorHorarioFinal(String horario) {
        TypedQuery<PasswordEntity> q = em.createQuery("select p from ContrasenaEntity p where (p.horarioFin = :horario)", PasswordEntity.class);
        q.setParameter("horario", horario);
        List<PasswordEntity> results = q.getResultList();
        PasswordEntity contrasena = null;
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
