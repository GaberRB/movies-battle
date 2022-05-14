package br.com.letscode.moviesbattle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Filmes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "titulo", nullable = false)
    private String titulo;
    @Column(name = "imdb_rating", nullable = false)
    private String imdbRating;
    @Column(name = "imdb_votes", nullable = false)
    private String imdbVotes;
}

