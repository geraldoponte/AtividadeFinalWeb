package model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;

public record ClienteRecord(
    @NotBlank String nome,
    @NotBlank @Email String email,
    @Id @NotBlank @CPF String cpf,
    @NotBlank String logradouroEndereco,
    @NotBlank String numeroEndereco,
    String complementoEndereco,
    @NotBlank String bairro,
    @NotBlank String cidade,
    @NotNull UF uf
) { }
