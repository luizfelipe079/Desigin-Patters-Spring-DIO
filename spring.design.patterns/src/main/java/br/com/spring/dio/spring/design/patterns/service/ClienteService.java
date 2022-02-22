package br.com.spring.dio.spring.design.patterns.service;

import br.com.spring.dio.spring.design.patterns.model.Cliente;

public interface ClienteService
{
    Iterable<Cliente> buscarTodosClientes();

    Cliente buscarPorId(Long id);

    void inserir(Cliente cliente);

    void atualizar(Long id, Cliente cliente);

    void deletar(Long id);
}
