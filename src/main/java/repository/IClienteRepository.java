package repository;

import model.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IClienteRepository extends MongoRepository<Cliente, String> {

    @Query("{nome:'?0}")
    List<Cliente> encontrarClientePeloNome(String nome);

    @Query("{email:'?0}")
    List<Cliente> encontrarClientePeloEmail(String email);

    @Query("{cpf='?0}")
    List<Cliente> encontrarClientePeloCPF(String cpf);

    public long count();
}
