package br.com.letscode.moviesbattle.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CardVencedor {

    private String titulo;

    private Integer pontuacao;

    private Integer tentativa;

    private boolean vencedor;
}
