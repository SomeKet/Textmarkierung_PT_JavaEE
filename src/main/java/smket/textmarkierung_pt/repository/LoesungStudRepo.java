package smket.textmarkierung_pt.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import smket.textmarkierung_pt.model.LoesungStud;
import smket.textmarkierung_pt.model.LoesungStud;


public class LoesungStudRepo {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public LoesungStudRepo() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public LoesungStudRepo(String name) {
        entityManagerFactory = Persistence.createEntityManagerFactory(name);
        this.entityManager = entityManagerFactory.createEntityManager();
    }


    public LoesungStud addloesung(LoesungStud loesung){
        entityManager.getTransaction().begin();
        entityManager.persist(loesung);
        entityManager.getTransaction().commit();
        return loesung;
    }

    public LoesungStud findloesung(long id){
        return entityManager.find(LoesungStud.class, id);
    }

    public LoesungStud updateloesung(LoesungStud loesung){
        LoesungStud toUpdate = findloesung(loesung.getlId());
        this.entityManager.getTransaction().begin();

        toUpdate.setLoesung(loesung.getLoesung());
        toUpdate.setLoesung(loesung.getLoesung());

        this.entityManager.getTransaction().commit();
        return toUpdate;
    }

    public void deleteloesung(long id){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(findloesung(id));
        this.entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.entityManagerFactory.close();
    }
}
