package persistence;

import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAConnection {

    public static final String CASSANDRA = "cassandra_db";
    public static final String DERBY = "derby_db";

    public static final String DB = DERBY;

    private EntityManager entityManager;
    public static final JPAConnection CONNECTION = new JPAConnection();

    public JPAConnection() {
        if (entityManager == null) {
            EntityManagerFactory emf;
            if (DB.equals(DERBY)) {
                emf = Persistence.createEntityManagerFactory(DERBY);
            } else{
                emf = Persistence.createEntityManagerFactory(DERBY);
            }
            
            entityManager = emf.createEntityManager();
        }
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }

}
