package APIVoll.med.domain.dto;

import APIVoll.med.domain.endereco.DadosEndereco;
import APIVoll.med.domain.endereco.Endereco;
import APIVoll.med.domain.entities.Paciente;

public record DadosDetalhamentoPaciente(String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(),paciente.getEmail(), paciente.getTelefone(), paciente.getTelefone(), paciente.getEndereco());
    }
}
