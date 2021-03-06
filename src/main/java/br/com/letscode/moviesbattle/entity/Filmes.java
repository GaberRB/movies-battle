package br.com.letscode.moviesbattle.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "filmes")
public class Filmes implements Serializable {
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

