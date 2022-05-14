package br.com.letscode.moviesbattle.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "imb")
public class FilmesProperties {

    private String url;
    private String apiKey;
    private List<String> filmes;
}
