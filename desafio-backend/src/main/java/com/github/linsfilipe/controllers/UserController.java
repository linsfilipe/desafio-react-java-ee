package com.github.linsfilipe.controllers;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import com.github.linsfilipe.domains.dtos.UserDTO;
import com.github.linsfilipe.domains.models.User;
import com.github.linsfilipe.services.IUserService;

@Path("/operators")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class UserController extends BaseController {

    @Inject
    private IUserService userService;

    @POST
    public Response createOperator(User user) {
        User userOk = userService.save(user);
        return success(userOk);
    }

    @PUT
    public Response updateOperator(User user) {
    	User userOk = userService.update(user);
    	return success(userOk);
    }
    
    @GET
    public Response getOperators() {
        final List<User> users = userService.findAll();
		List<UserDTO> usersDTO = users.stream()
				.map(u -> new UserDTO(u.getId(), u.getNome(), u.getLogin(),
						u.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), u.getPerfil()))
				.collect(Collectors.toList());
        
        if (CollectionUtils.isNotEmpty(users)) {
            return success(usersDTO);
        } else {
            return failure(NOT_FOUND, "Nenhum registro encontrado");
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response deleteOperator(@PathParam("id") Integer id) {
    	User user = userService.findById(id);
    	if (user != null) {
    		userService.delete(user);
			return success(new UserDTO(user.getId(), user.getNome(), user.getLogin(),
					user.getDataCadastro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), user.getPerfil()));
		} else {
			return failure(NOT_FOUND, "Usuário não encontrado");
		}
    }
    
    @GET
    @Path("{id}")
    public Response getOperator(@PathParam("id") Integer id) {
    	User user = userService.findById(id);
    	if (user != null) {
    		return success(user);
    	} else {
    		return failure(NOT_FOUND, "Usuário não encontrado");
    	}
    }


}
