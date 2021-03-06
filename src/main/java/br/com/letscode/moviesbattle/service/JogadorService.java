package br.com.letscode.moviesbattle.service;

import br.com.letscode.moviesbattle.entity.Jogador;
import br.com.letscode.moviesbattle.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.naming.AuthenticationException;
import java.util.List;
import java.util.Optional;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    public Jogador salvar(Jogador jogador){
        return jogadorRepository.save(jogador);
    }

    public List<Jogador> lista(){
        return jogadorRepository.findAll();
    }

    public Optional<Jogador> buscarPorId(long id){
        return jogadorRepository.findById(id);
    }

    public void remover(Long id){
        jogadorRepository.deleteById(id);
    }

    public Jogador retornaCredencialLogin(String nickname, String senha) throws AuthenticationException {
        var login = jogadorRepository.findByNicknameSenha(nickname,senha);
        if(login !=null){
          return login;
        }else {
            throw new AuthenticationException("Erro ao autenticar o jogador");
        }
    }
}
