package com.github.linsfilipe.controllers;

import static com.github.linsfilipe.utils.JWTUtil.encode;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.github.linsfilipe.domains.dtos.AuthDTO;
import com.github.linsfilipe.domains.dtos.CredentialsDTO;
import com.github.linsfilipe.domains.models.User;
import com.github.linsfilipe.services.IUserService;

@Path("/auth")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class AuthController extends BaseController {

    @Inject
    private IUserService userService;

    @POST
    public Response login(CredentialsDTO credentials) {
        final User user = userService.findByLoginSenha(credentials.getLogin(), credentials.getSenha());
        
        if (user != null) {
        	final String token = encode(user.getId().toString());
            return success(new AuthDTO(token, user.getPerfil().getNome()));
        } else {
            return failure(UNAUTHORIZED, "Credenciais Inválidas");
        }
    }


}
