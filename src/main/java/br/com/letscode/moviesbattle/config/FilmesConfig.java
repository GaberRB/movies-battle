package br.com.letscode.moviesbattle.config;

import br.com.letscode.moviesbattle.service.FilmesService;
import br.com.letscode.moviesbattle.service.ImbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilmesConfig {

    @Autowired
    FilmesService filmesService;

    @Autowired
    FilmesProperties filmesProperties;

    @Autowired
    ImbService imbService;

    @Bean
    public void CriarFilmes (){
        System.out.println("Iniciando o servico de busca");
        var filmes = filmesProperties.getFilmes();
        for (var filme:filmes) {
            var response = imbService.busca(filme);
            filmesService.salvar(response);
        }


    }
}
