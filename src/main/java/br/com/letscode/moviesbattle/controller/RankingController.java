package br.com.letscode.moviesbattle.controller;

import br.com.letscode.moviesbattle.entity.Jogador;
import br.com.letscode.moviesbattle.entity.Ranking;
import br.com.letscode.moviesbattle.service.JogadorService;
import br.com.letscode.moviesbattle.service.RankingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Ranking dos jogadores")
@RestController
@RequestMapping("/api/raking/v1")
public class RankingController {

    @Autowired
    private RankingService rankingService;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Listar ranking")
    public List<Ranking> lista(){
        return rankingService.lista();
    }

}
