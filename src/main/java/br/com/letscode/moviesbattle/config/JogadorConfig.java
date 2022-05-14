package br.com.letscode.moviesbattle.config;

import br.com.letscode.moviesbattle.entity.Jogador;
import br.com.letscode.moviesbattle.service.JogadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JogadorConfig {

    @Autowired
    JogadorService jogadorService;

    @Bean
    public void CriarJogadores (){
        var jogador1 = Jogador.builder()
                .nickname("Jogador1")
                .nome("Jogador 1")
                .senha("1234")
                .build();
        var jogador2 = Jogador.builder()
                .nickname("Jogador2")
                .nome("Jogador 2")
                .senha("1234")
                .build();
        jogadorService.salvar(jogador1);
        jogadorService.salvar(jogador2);
    }
}
