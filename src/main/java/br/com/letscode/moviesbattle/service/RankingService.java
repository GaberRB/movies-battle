package br.com.letscode.moviesbattle.service;

import br.com.letscode.moviesbattle.entity.Ranking;
import br.com.letscode.moviesbattle.repository.RankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankingService {

    @Autowired
    private RankingRepository rankingRepository;

    public Ranking salvar(Ranking ranking){
        return rankingRepository.save(ranking);
    }

    public List<Ranking> lista(){
        return rankingRepository.findAll();
    }

}
