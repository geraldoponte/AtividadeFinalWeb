package model;

public record ClienteDadosParaAlteracaoRecord(
    String nome,
    String email,
    String cpf,
    String logradouroEndereco,
    String numeroEndereco,
    String complementoEndereco,
    String bairro,
    String cidade,
    UF uf) {

    public ClienteDadosParaAlteracaoRecord(Cliente cliente) {
        this(cliente.getNome(), cliente.getEmail(), cliente.getCpf(), cliente.getLogradouroEndereco(),
        cliente.getNumeroEndereco(), cliente.getComplementoEndereco(), cliente.getBairro(), cliente.getCidade(), cliente.getUf());
    }
}
