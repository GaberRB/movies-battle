package br.com.letscode.moviesbattle.controller;

import br.com.letscode.moviesbattle.entity.Filmes;
import br.com.letscode.moviesbattle.entity.Jogador;
import br.com.letscode.moviesbattle.service.FilmesService;
import br.com.letscode.moviesbattle.service.JogadorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Api(tags = "Filmes")
@RestController
@RequestMapping("/api/filmes/v1")
public class FilmesController {

    @Autowired
    private FilmesService filmesService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Salvar filme na base")
    public Filmes salvar(Filmes filmes){
        return filmesService.salvar(filmes);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Listar todos os Filmes")
    public List<Filmes> lista(){
        return filmesService.lista();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Buscar filme por ID")
    public Filmes buscarPorId(@PathVariable("id") Long id){
        return filmesService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Remover filme por ID")
    public void remover(@PathVariable("id") Long id){
        filmesService.buscarPorId(id)
                .map(jogador -> {
                    filmesService.remover(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation(value = "Atualizar filmes na base")
    public void atualiza(@PathVariable("id") Long id, @RequestBody Filmes filmes){
        filmesService.buscarPorId(id)
                .map(filmesFind -> {
                    modelMapper.map(filmes, filmesFind);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
        filmesService.salvar(filmes);
    }
}
