package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
