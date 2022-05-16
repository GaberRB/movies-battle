package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {


}
