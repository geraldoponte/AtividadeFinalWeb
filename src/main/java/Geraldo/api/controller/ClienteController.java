package Geraldo.api.controller;

import jakarta.validation.Valid;
import model.Cliente;
import model.ClienteDadosParaAlteracaoRecord;
import model.ClienteRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import repository.IClienteRepository;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private IClienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid ClienteRecord dados) {
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<ClienteDadosParaAlteracaoRecord> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(ClienteDadosParaAlteracaoRecord::new);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<HttpStatus> atualizar(@RequestBody @Valid ClienteDadosParaAlteracaoRecord dados) {
        try {
            Optional<Cliente> clienteProcurado = repository.findById(dados.cpf());
            if (clienteProcurado.isPresent()) {
                Cliente clienteEncontrado = clienteProcurado.get();
                clienteEncontrado.atualizar(dados);
                repository.save(clienteEncontrado);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception E) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity<HttpStatus> excluir(@RequestBody ClienteRecord clienteParaExclusao) {
        try {
            repository.deleteById(clienteParaExclusao.cpf());
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}