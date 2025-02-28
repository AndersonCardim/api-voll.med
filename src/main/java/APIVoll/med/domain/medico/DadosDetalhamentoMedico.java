package APIVoll.med.domain.medico;

import APIVoll.med.domain.endereco.Endereco;

public record DadosDetalhamentoMedico(Long id, String crm, String email, String telefone, Especialidade especialidade, Endereco endereco) {
    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getCrm(), medico.getEmail(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}
