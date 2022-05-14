package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmesRepository extends JpaRepository<Filmes, Long> {
}
