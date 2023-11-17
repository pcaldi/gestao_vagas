package com.pcaldi.gestao_vagas.modules.candidate.useCase;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.pcaldi.gestao_vagas.modules.candidate.CandidateRepository;
import com.pcaldi.gestao_vagas.modules.candidate.dto.AuthRequestCandidateDTO;
import com.pcaldi.gestao_vagas.modules.candidate.dto.AuthResponseCandidateDTO;

@Service
public class AuthCandidateUseCase {

    @Value("${security.token.secret.candidate}")
    private String secretKey;

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public AuthResponseCandidateDTO execute(AuthRequestCandidateDTO authRequestCandidateDTO)
            throws AuthenticationException {
        var candidate = this.candidateRepository.findByUsername(authRequestCandidateDTO.username()).orElseThrow(() -> {
            throw new UsernameNotFoundException("Usuário/Password incorretos");
        });
        // Verificar se as senhas são iguais
        var passwordMatches = this.passwordEncoder.matches(authRequestCandidateDTO.password(), candidate.getPassword());

        // Se não for iguais -> error
        if (!passwordMatches) {
            throw new AuthenticationException();
        }
        // Se forem iguais -> Gerar o token
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        var token = JWT.create()
                .withIssuer("javagas")
                .withSubject(candidate.getId().toString())
                .withClaim("roles", Arrays.asList("CANDIDATE"))
                .withExpiresAt(Instant.now().plus(Duration.ofMinutes(10)))
                .sign(algorithm);

        var authCandidateResponse = AuthResponseCandidateDTO.builder().access_token(token).build();

        return authCandidateResponse;

    }
}
