package APIVoll.med.domain.consulta.validacoes;

import APIVoll.med.domain.ValidacaoException;
import APIVoll.med.domain.consulta.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
     void validar(DadosAgendamentoConsulta dados);
}
