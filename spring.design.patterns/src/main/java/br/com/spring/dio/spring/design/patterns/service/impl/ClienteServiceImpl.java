package br.com.spring.dio.spring.design.patterns.service.impl;

import br.com.spring.dio.spring.design.patterns.exceptions.ObjectNotFoundException;
import br.com.spring.dio.spring.design.patterns.model.Cliente;
import br.com.spring.dio.spring.design.patterns.model.Endereco;
import br.com.spring.dio.spring.design.patterns.repository.ClienteRepository;
import br.com.spring.dio.spring.design.patterns.repository.EnderecoRepository;
import br.com.spring.dio.spring.design.patterns.service.ClienteService;
import br.com.spring.dio.spring.design.patterns.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService
{
    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Cliente> buscarTodosClientes()
    {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente buscarPorId(Long id)
    {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    @Override
    public void inserir(Cliente cliente)
    {
        salvarClienteComCep(cliente);
    }

    @Override
    public void atualizar(Long id, Cliente cliente)
    {
        Cliente c1 = buscarPorId(id);
        cliente.setId(id);
        salvarClienteComCep(cliente);
    }

    @Override
    public void deletar(Long id)
    {
        clienteRepository.deleteById(id);
    }

    private void salvarClienteComCep(Cliente cliente)
    {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep)
                .orElseGet(() -> {
                    Endereco novoEndereco = viaCepService.consultarCep(cep);
                    enderecoRepository.save(novoEndereco);
                    return novoEndereco;
                });

        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }

}
