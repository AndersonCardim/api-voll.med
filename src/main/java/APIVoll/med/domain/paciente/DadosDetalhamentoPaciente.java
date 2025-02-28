package APIVoll.med.domain.paciente;

import APIVoll.med.domain.endereco.Endereco;

public record DadosDetalhamentoPaciente(String nome, String email, String cpf, String telefone, Endereco endereco) {
    public DadosDetalhamentoPaciente(Paciente paciente) {
        this(paciente.getNome(),paciente.getEmail(), paciente.getTelefone(), paciente.getTelefone(), paciente.getEndereco());
    }
}
