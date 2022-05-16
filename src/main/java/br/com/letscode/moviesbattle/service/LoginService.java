package br.com.letscode.moviesbattle.service;

import br.com.letscode.moviesbattle.entity.Jogador;
import br.com.letscode.moviesbattle.entity.Login;
import br.com.letscode.moviesbattle.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private JogadorService jogadorService;

    public Login salvar(Login login){
        return loginRepository.save(login);
    }

    public List<Login> lista(){
        return loginRepository.findAll();
    }

    public Optional<Login> buscarPorId(long id){
        return loginRepository.findById(id);
    }

    public void remover(long id){
        loginRepository.deleteById(id);
    }

    public Login buscaPorNickname(String nickname){
        return loginRepository.findByNickname(nickname);
    }

    public Login logar(String nickname, String senha) throws AuthenticationException {
        var credencialLogin = jogadorService.retornaCredencialLogin(nickname, senha);
        UUID uuid = UUID.randomUUID();
        return Login.builder()
                .auth(uuid.toString())
                .nickname(credencialLogin.getNickname())
                .build();
    }
}
