package br.com.letscode.moviesbattle.controller;

import br.com.letscode.moviesbattle.entity.Jogador;
import br.com.letscode.moviesbattle.service.JogadorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Api Jogadores")
@RestController
@RequestMapping("/api/jogador/v1")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Cadastrar jogadores")
    public Jogador salvar(Jogador jogador){
        return jogadorService.salvar(jogador);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Listar jogadores")
    public List<Jogador> lista(){
        return jogadorService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation("Buscar jogador por id")
    public Jogador buscarPorId(@PathVariable("id") Long id){
        return jogadorService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado"));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Remover jogador por id")
    public void remover(@PathVariable("id") Long id){
        jogadorService.buscarPorId(id)
                .map(jogador -> {
                    jogadorService.remover(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualiza(@PathVariable("id") Long id, @RequestBody Jogador jogador){
        jogadorService.buscarPorId(id)
                .map(jogadorFind -> {
                    modelMapper.map(jogador, jogadorFind);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Jogador não encontrado"));
    }
}
