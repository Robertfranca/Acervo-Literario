package repository;

import models.Livro;
import java.util.List;

public interface LivroRepository {
    void salvar(Livro livro)throws RepositoryException;
    Livro buscarPorTitulo(String titulo) throws RepositoryException;
//    Livro buscarPorIsbn(String isbn) throws RepositoryException;
//    List<Livro> buscarPorAutor(String autor) throws RepositoryException;
    List<Livro> buscarTodos() throws RepositoryException;
    void atualizar(Livro livro) throws RepositoryException;
    void deletarLivro(int id) throws RepositoryException;
    Livro buscarLivroInfo(int id) throws RepositoryException;
    void editarLivro(Livro livroAtualizado) throws RepositoryException;
}
