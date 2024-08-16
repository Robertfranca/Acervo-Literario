package repository;

import models.Livro;
import java.util.List;

public interface LivroRepository {
    void salvar(Livro livro);
    Livro buscarPorTitulo(String titulo);
    Livro buscarPorIsbn(String isbn);
    List<Livro> buscarTodos();
    void atualizar(Livro livro);
    void deletar(int id);
}
