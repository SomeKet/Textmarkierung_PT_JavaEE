package smket.textmarkierung_pt;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import smket.textmarkierung_pt.model.AufgabeLehrend;
import smket.textmarkierung_pt.repository.AufgabeLehrendRepo;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


public class HelloServlet extends HttpServlet {

    public static void main(String[] args){

        String name = "persistence";
        AufgabeLehrendRepo repo = new AufgabeLehrendRepo(name);

        AufgabeLehrend test = new AufgabeLehrend();
        test.setAufgabe("Test");
        test.setLoesung("Lösung");

        repo.addAufgabe(test);
        repo.close();








    }

}