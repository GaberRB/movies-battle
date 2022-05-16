package br.com.letscode.moviesbattle.service;

import br.com.letscode.moviesbattle.entity.Filmes;
import br.com.letscode.moviesbattle.entity.Login;
import br.com.letscode.moviesbattle.entity.Partida;
import br.com.letscode.moviesbattle.repository.PartidaRepository;
import br.com.letscode.moviesbattle.response.CardVencedor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class PartidaService {

    @Autowired
    private FilmesService filmesService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private PartidaRepository partidaRepository;

    public Partida salvar () throws AuthException {
        var login = loginService.lista().get(0);
        if (!login.getAuth().isBlank()){
            var partida = builderPartida(filmesService.lista(), login);

            return partidaRepository.save(partida);
        }else {
            throw new AuthException("Jogador não logado");
        }

    }

    public Partida atualizar(Partida partida){
        return partidaRepository.save(partida);
    }

    public CardVencedor jogar(Integer card){
        var partida = partidaRepository.findAll().get(0);

        if (partida.getPontuacao1() > partida.getPontuacao2() && card == 1){
            var cardVencedor = CardVencedor.builder()
                    .titulo(partida.getTitulo1())
                    .pontuacao(partida.getPontuacao1())
                    .vencedor(true)
                    .build();

            return cardVencedor;
        }else if (partida.getPontuacao2() > partida.getPontuacao1() && card == 2){
            var cardVencedor = CardVencedor.builder()
                    .titulo(partida.getTitulo2())
                    .pontuacao(partida.getPontuacao2())
                    .vencedor(true)
                    .build();
            return cardVencedor;
        }
        return CardVencedor.builder()
                .vencedor(false)
                .build();

    }

    public Partida buscar(){
        return partidaRepository.findAll().get(0);
    }

    private Partida builderPartida(List<Filmes> filmes, Login login){
        String regex = "[^0-9]";
        Random rand = new Random();
        List<Filmes> filmesCard = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            var randomIndex = rand.nextInt(filmes.size());
            filmesCard.add(filmes.get(randomIndex));
            filmes.remove(randomIndex);
        }

        var builderFilmeCard1 = Filmes.builder()
                .id(filmesCard.get(0).getId())
                .titulo(filmesCard.get(0).getTitulo())
                .imdbRating(filmesCard.get(0).getImdbRating())
                .imdbVotes(filmesCard.get(0).getImdbVotes())
                .build();
        var builderFilmeCard2 = Filmes.builder()
                .id(filmesCard.get(1).getId())
                .titulo(filmesCard.get(1).getTitulo())
                .imdbRating(filmesCard.get(1).getImdbRating())
                .imdbVotes(filmesCard.get(1).getImdbVotes())
                .build();

        var builderPartida = Partida.builder()
                .titulo1(builderFilmeCard1.getTitulo())
                .titulo2(builderFilmeCard2.getTitulo())
                .pontuacao1(
                        Integer.parseInt(builderFilmeCard1.getImdbRating().replaceAll(regex, ""))
                                * Integer.parseInt(builderFilmeCard1.getImdbVotes().replaceAll(regex, "")))
                .pontuacao2(
                        Integer.parseInt(builderFilmeCard2.getImdbRating().replaceAll(regex, ""))
                                * Integer.parseInt(builderFilmeCard2.getImdbVotes().replaceAll(regex, "")))
                .tentativa(0)
                .jogador(login.getNickname())
                .build();

        return builderPartida;

    }
}
