package br.com.letscode.moviesbattle.repository;

import br.com.letscode.moviesbattle.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    @Query("SELECT l FROM Login l WHERE l.nickname =:nickname")
    Login findByNickname(@Param("nickname")  String nickname);
}
