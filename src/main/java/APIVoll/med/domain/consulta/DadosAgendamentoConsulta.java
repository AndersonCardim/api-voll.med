package APIVoll.med.domain.consulta;

import APIVoll.med.domain.medico.Especialidade;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoConsulta(Long idMedico,

                                       @NotNull
                                        Long idPaciente,

                                       @NotNull
                                        @Future
                                       LocalDateTime data,

                                       Especialidade especialidade
                                       ) {
}
