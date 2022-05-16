package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long> {
}
