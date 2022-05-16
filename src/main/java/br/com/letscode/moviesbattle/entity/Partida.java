package br.com.letscode.moviesbattle.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.models.auth.In;
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
@Table(name = "partida")
public class Partida implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "titulo_1", nullable = false)
    private String titulo1;
    @Column(name = "titulo_2", nullable = false)
    private String titulo2;
    @Column(name = "pontuacao_1", nullable = false)
    private Integer pontuacao1;
    @Column(name = "pontuacao_2", nullable = false)
    private Integer pontuacao2;
    @Column(name = "jogador", nullable = false)
    private String jogador;
    @Column(name = "tentativa")
    private Integer tentativa;

}
