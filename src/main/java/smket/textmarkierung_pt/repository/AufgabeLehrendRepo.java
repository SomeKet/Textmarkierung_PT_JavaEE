package smket.textmarkierung_pt.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import smket.textmarkierung_pt.model.AufgabeLehrend;




public class AufgabeLehrendRepo {

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;

    public AufgabeLehrendRepo() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("aufgabeLehrend_pu");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public AufgabeLehrendRepo(String name) {
        entityManagerFactory = Persistence.createEntityManagerFactory(name);
        this.entityManager = entityManagerFactory.createEntityManager();
    }




    public AufgabeLehrend addAufgabe(AufgabeLehrend aufgabe){
        entityManager.getTransaction().begin();
        entityManager.persist(aufgabe);
        entityManager.getTransaction().commit();
        return aufgabe;
    }

    public AufgabeLehrend findAufgabe(long id){
        return entityManager.find(AufgabeLehrend.class, id);
    }

    public AufgabeLehrend updateAufgabe(AufgabeLehrend aufgabe){
        AufgabeLehrend toUpdate = findAufgabe(aufgabe.getaId());
        this.entityManager.getTransaction().begin();

        toUpdate.setAufgabe(aufgabe.getAufgabe());
        toUpdate.setLoesung(aufgabe.getLoesung());

        this.entityManager.getTransaction().commit();
        return toUpdate;
    }

    public void deleteAufgabe(long id){
        this.entityManager.getTransaction().begin();
        this.entityManager.remove(findAufgabe(id));
        this.entityManager.getTransaction().commit();
    }

    public void close(){
        this.entityManager.close();
        this.entityManagerFactory.close();
    }
}
