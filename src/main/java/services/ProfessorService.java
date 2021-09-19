package services;

import entities.Interaction;
import entities.Professor;
import entities.Video;
import exceptions.CredentialsException;
import exceptions.NonUniqueResultException;
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

    public Professor checkCredentials(String usrn, String pwd) throws CredentialsException, NonUniqueResultException {
        List<Professor> professorList = null;
        try {
            professorList = em.createNamedQuery("Professor.checkCredentials", Professor.class).setParameter(1, usrn).setParameter(2, pwd)
                    .getResultList();
        } catch (PersistenceException e) {
            throw new CredentialsException("Could not verify credentals");
        }
        if (professorList.isEmpty())
            return null;
        else if (professorList.size() == 1)
            return professorList.get(0);
        throw new NonUniqueResultException("More than one user registered with same credentials");

    }

    public void createProfessor(String username, String password){
        Professor professor = new Professor(username, password);
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
    }

}
