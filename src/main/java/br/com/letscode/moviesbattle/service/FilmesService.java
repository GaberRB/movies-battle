package br.com.letscode.moviesbattle.service;

import br.com.letscode.moviesbattle.entity.Filmes;
import br.com.letscode.moviesbattle.repository.FilmesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmesService {

    @Autowired
    private FilmesRepository filmesRepository;

    public Filmes salvar(Filmes filmes){
        return filmesRepository.save(filmes);
    }

    public List<Filmes> lista(){
        return filmesRepository.findAll();
    }

    public Optional<Filmes> buscarPorId(long id){
        return filmesRepository.findById(id);
    }

    public void remover(Long id){
        filmesRepository.deleteById(id);
    }
}
