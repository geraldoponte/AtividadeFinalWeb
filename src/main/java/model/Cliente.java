package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clientes")
@Getter
@NoArgsConstructor
public class Cliente {
    private String nome;
    private String email;
    @Id
    private String cpf;
    private String logradouroEndereco;
    private String numeroEndereco;
    private String complementoEndereco;
    private String bairro;
    private String cidade;
    private UF uf;

    public Cliente(ClienteRecord dados) {
        super();
        this.nome = dados.nome();
        this.email = dados.email();
        this.cpf = dados.cpf();
        this.logradouroEndereco = dados.logradouroEndereco();
        this.numeroEndereco = dados.numeroEndereco();
        this.complementoEndereco = dados.complementoEndereco();
        this.bairro = dados.bairro();
        this.cidade = dados.cidade();
        this.uf = dados.uf();
    }

    public void atualizar(ClienteDadosParaAlteracaoRecord novosDados) {
        if (novosDados.nome() != null) {
            this.nome = novosDados.nome();
        }

        if (novosDados.email() != null) {
            this.email = novosDados.email();
        }

        if (novosDados.logradouroEndereco() != null) {
            this.logradouroEndereco = novosDados.logradouroEndereco();
        }

        if (novosDados.numeroEndereco() != null) {
            this.numeroEndereco = novosDados.numeroEndereco();
        }

        if (novosDados.complementoEndereco() != null) {
            this.complementoEndereco = novosDados.complementoEndereco();
        }

        if (novosDados.bairro() != null) {
            this.bairro = novosDados.bairro();
        }

        if (novosDados.cidade() != null) {
            this.cidade = novosDados.cidade();
        }

        if (novosDados.uf() != null) {
            this.uf = novosDados.uf();
        }
    }

}
