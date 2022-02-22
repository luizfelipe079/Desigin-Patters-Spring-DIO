package br.com.spring.dio.spring.design.patterns.repository;

import br.com.spring.dio.spring.design.patterns.model.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteRepository extends CrudRepository<Cliente, Long>
{

}
