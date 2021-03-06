package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Filmes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmesRepository extends JpaRepository<Filmes, Long> {
}
