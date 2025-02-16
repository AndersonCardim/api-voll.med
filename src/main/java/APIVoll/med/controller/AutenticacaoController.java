package APIVoll.med.controller;

import APIVoll.med.domain.dto.DadosAtualizacaoMedico;
import APIVoll.med.domain.dto.DadosAutenticacao;
import APIVoll.med.domain.usuario.Usuario;
import APIVoll.med.infra.security.DadosTokeJWT;
import APIVoll.med.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@Valid @RequestBody DadosAutenticacao dados) {
        var autheticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authetication = manager.authenticate(autheticationToken);

        var tokeJWT = tokenService.gerarToken((Usuario) authetication.getPrincipal());
        return ResponseEntity.ok(new DadosTokeJWT(tokeJWT));
    }
}
