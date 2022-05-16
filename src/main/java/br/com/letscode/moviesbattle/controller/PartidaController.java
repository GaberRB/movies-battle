package br.com.letscode.moviesbattle.controller;

import br.com.letscode.moviesbattle.entity.Partida;
import br.com.letscode.moviesbattle.entity.Ranking;
import br.com.letscode.moviesbattle.response.CardVencedor;
import br.com.letscode.moviesbattle.service.LoginService;
import br.com.letscode.moviesbattle.service.PartidaService;
import br.com.letscode.moviesbattle.service.RankingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.security.auth.message.AuthException;


@Api(tags = "Partida")
@RestController
@RequestMapping("/api/partida/v1")
public class PartidaController {

    @Autowired
    private PartidaService partidaService;

    @Autowired
    private RankingService rankingService;

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Iniciar Partida")
    public Partida iniciar() throws AuthException {
        return partidaService.salvar();
    }

    @GetMapping("/{card}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Jogar Partida")
    public CardVencedor jogar(@PathVariable("card") Integer card){
        var partida = partidaService.buscar();
        var jogo = partida.getTentativa();
        if (jogo <= 3) {
            jogo++;
        }
        var jogada = partidaService.jogar(card);
        partida.setTentativa(jogo);
        partidaService.atualizar(partida);
        jogada.setTentativa(jogo);
        if (partida.getTentativa() >= 3) {
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Não há mais tentativas Validas " + "Partida: " + partida);
        }else if (jogada.isVencedor()){
            partidaService.atualizar(partida);
            rankingService.salvar(
                    Ranking.builder()
                            .nickname(partida.getJogador())
                            .rank((1 / partida.getTentativa() ) * 100 )
                            .build()
            );

            return jogada;
        }
        return null;
    }
}
