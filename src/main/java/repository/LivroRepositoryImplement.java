package repository;

import models.Livro;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LivroRepositoryImplement implements LivroRepository {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LivroRepositoryImplement() {
        entityManagerFactory = Persistence.createEntityManagerFactory("livraria");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public void salvar(Livro livro) {
        entityManager.getTransaction().begin();
        entityManager.persist(livro);
        entityManager.getTransaction().commit();
    }

    @Override
    public Livro buscarPorTitulo(String titulo) {
        TypedQuery<Livro> query = entityManager.createQuery("SELECT l FROM Livro l WHERE l.titulo = :titulo", Livro.class);
        query.setParameter("titulo", titulo);
        return query.getSingleResult();
    }

    @Override
    public Livro buscarPorIsbn(String isbn) {
        TypedQuery<Livro> query = entityManager.createQuery("SELECT l FROM Livro l WHERE l.isbn = :isbn", Livro.class);
        query.setParameter("isbn", isbn);
        return query.getSingleResult();
    }

    @Override
    public List<Livro> buscarTodos() {
        TypedQuery<Livro> query = entityManager.createQuery("SELECT l FROM Livro l", Livro.class);
        return query.getResultList();
    }

    @Override
    public void atualizar(Livro livro) {
        entityManager.getTransaction().begin();
        entityManager.merge(livro);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deletar(int id) {
        Livro livro = entityManager.find(Livro.class, id);
        entityManager.getTransaction().begin();
        entityManager.remove(livro);
        entityManager.getTransaction().commit();
    }
}
