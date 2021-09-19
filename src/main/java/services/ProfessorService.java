package services;

import entities.Interaction;
import entities.Professor;
import entities.Video;
import exceptions.CredentialsException;
import exceptions.UserNotRegisteredException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;

import java.util.List;

public class ProfessorService {
    @PersistenceContext
    private EntityManager em;

    public ProfessorService(EntityManager em) {
        this.em = em;
    }

    public Professor checkCredentials(String usrn, String pwd) throws CredentialsException, UserNotRegisteredException {
        Professor professor;
        try {
            professor = em.createNamedQuery("Professor.checkCredentials", Professor.class).setParameter(1, usrn).setParameter(2, pwd)
                    .getSingleResult();
        } catch (PersistenceException e) {
            if(findProfessorByUsername(usrn))
                throw new CredentialsException("Password incorrect. Please retry");
            else
                throw new UserNotRegisteredException("The user is not registered yet. Please register and retry");
        }

        return professor;
    }

    public void createProfessor(String username, String password){
        Professor professor = new Professor(username, password);
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
    }

    public boolean findProfessorByUsername(String username) throws UserNotRegisteredException {
        try {
            Professor p = em.createNamedQuery("Professor.findProfessorByUserame", Professor.class).setParameter("username", username)
                    .getSingleResult();
            return p!=null;
        } catch (PersistenceException e) {
            throw new UserNotRegisteredException("The user is not registered yet. Please register and retry");
        }
    }


}
