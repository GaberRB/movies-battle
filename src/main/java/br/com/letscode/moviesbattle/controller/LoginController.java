package br.com.letscode.moviesbattle.controller;

import br.com.letscode.moviesbattle.entity.Login;
import br.com.letscode.moviesbattle.service.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.naming.AuthenticationException;

@Api(tags = "Login")
@RestController
@RequestMapping("/api/login/v1")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation("Logar jogador")
    public Login login(String nickname, String senha) throws AuthenticationException {
        var auth =loginService.logar(nickname, senha);
        return loginService.salvar(auth);
    }

    @DeleteMapping("/{nickname}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ApiOperation("Logout jogador")
    public void logout(@PathVariable("nickname") String nickname) {
        var login = loginService.buscaPorNickname(nickname);
        loginService.remover(login.getId());
    }

}
