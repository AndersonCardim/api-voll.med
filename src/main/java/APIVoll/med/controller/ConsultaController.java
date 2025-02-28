package APIVoll.med.controller;

import APIVoll.med.domain.ValidacaoException;
import APIVoll.med.domain.consulta.AgendaDeConsultas;
import APIVoll.med.domain.consulta.DadosAgendamentoConsulta;
import APIVoll.med.domain.consulta.DadosCancelamentoConsulta;
import APIVoll.med.domain.consulta.DadosDetalhamentoConsulta;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("consultas")
public class ConsultaController{

    @Autowired
    private AgendaDeConsultas consultas;

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) throws ValidacaoException {
        System.out.println(dados);
        consultas.agendar(dados);
        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null, null, null));
    }

    @DeleteMapping
    @Transactional
    public ResponseEntity cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) throws ValidacaoException {
        consultas.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}
