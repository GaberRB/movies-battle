package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {


    @Query("SELECT j FROM Jogador j WHERE j.nickname =:nickname AND j.senha=:senha")
    Jogador findByNicknameSenha(@Param("nickname")  String nickname, @Param("senha") String senha);
}
