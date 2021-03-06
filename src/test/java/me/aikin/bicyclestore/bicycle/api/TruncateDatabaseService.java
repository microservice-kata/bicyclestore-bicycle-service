package me.aikin.bicyclestore.bicycle.api;

import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;
import org.hibernate.persister.entity.AbstractEntityPersister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@Profile("test")
public class TruncateDatabaseService {
    @Autowired
    private EntityManager entityManager;


    @Transactional
    public void truncate() {
        List<String> tableNames = new ArrayList<>();
        Session session = entityManager.unwrap(Session.class);
        Map<String, ClassMetadata> hibernateMetadata = session.getSessionFactory().getAllClassMetadata();

        for (ClassMetadata classMetadata : hibernateMetadata.values()) {
            AbstractEntityPersister aep = (AbstractEntityPersister) classMetadata;
            tableNames.add(aep.getTableName());
        }

        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = FALSE").executeUpdate();
        tableNames.forEach(tableName -> entityManager.createNativeQuery("TRUNCATE TABLE " + tableName.toUpperCase()).executeUpdate());
        entityManager.createNativeQuery("SET FOREIGN_KEY_CHECKS = TRUE").executeUpdate();
    }
}
