package br.com.spring.dio.spring.design.patterns.repository;

import br.com.spring.dio.spring.design.patterns.model.Endereco;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, String>
{

}
