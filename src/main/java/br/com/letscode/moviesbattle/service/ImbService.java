package br.com.letscode.moviesbattle.service;

import br.com.letscode.moviesbattle.config.FilmesProperties;
import br.com.letscode.moviesbattle.entity.Filmes;
import br.com.letscode.moviesbattle.response.ImbResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ImbService {

    @Autowired
    private FilmesProperties filmesProperties;

    public Filmes busca(String titulo){
        var url = filmesProperties.getUrl() + filmesProperties.getApiKey() + "&t="+titulo.replace(" ", "+");
        RestTemplate restTemplate = new RestTemplate();
        var movies = restTemplate.getForObject(url, ImbResponse.class);

        return Filmes.builder()
                .titulo(movies.getTitle())
                .imdbRating(movies.getImdbRating())
                .imdbVotes(movies.getImdbVotes())
                .build();
    }

}
