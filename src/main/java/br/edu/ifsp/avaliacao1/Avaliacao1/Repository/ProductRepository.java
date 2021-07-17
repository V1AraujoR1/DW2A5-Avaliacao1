package br.edu.ifsp.avaliacao1.Avaliacao1.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import br.edu.ifsp.avaliacao1.Avaliacao1.Model.*;

public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNome(String nome);
    List<Product> findByDescricao(String descricao);
    List<Product> findByMarca(String marca);
    List<Product> findByReferencia(String referencia);
    List<Product> findByPreco(float preco);

}