package com.github.linsfilipe.controllers;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import com.github.linsfilipe.constants.Constantes;
import com.github.linsfilipe.domains.dtos.PessoaDTO;
import com.github.linsfilipe.domains.models.Pessoa;
import com.github.linsfilipe.services.IPessoaService;
import com.github.linsfilipe.services.IUserService;
import com.github.linsfilipe.utils.JWTUtil;
import com.github.linsfilipe.utils.Util;
import com.github.linsfilipe.domains.models.User;

@Path("/pessoa")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PessoaController extends BaseController {

    @Inject
    private IPessoaService pessoaService;
    @Inject
    private IUserService userService;

    @POST
    public Response createPessoa(PessoaDTO pessoaDTO, @Context HttpServletRequest httpRequest) {
    	final String token = JWTUtil.removeBearer(httpRequest.getHeader(HttpHeaders.AUTHORIZATION));
    	final String idUser = JWTUtil.decode(token).getBody().getSubject();
    	User userLogado = userService.findById(Integer.valueOf(idUser));
    	
		Pessoa pessoa = new Pessoa(pessoaDTO.getNome(), pessoaDTO.getDocumento(),
				Util.dateStringToLocalDate(pessoaDTO.getDataNascimento()), pessoaDTO.getNomePai(),
				pessoaDTO.getNomeMae(), userLogado.getLogin(), pessoaDTO.getTipoPessoa());
    	Pessoa pessoaOk = pessoaService.save(pessoa);
        return success(pessoaOk);
    }

    @PUT
    public Response updatePessoa(Pessoa pessoa) {
    	Pessoa pessoaOk = pessoaService.update(pessoa);
    	return success(pessoaOk);
    }
    
    @GET
    public Response getPessoas() {
        final List<Pessoa> pessoas = pessoaService.findAll();

        if (CollectionUtils.isNotEmpty(pessoas)) {
            return success(pessoas);
        } else {
            return failure(NOT_FOUND, Constantes.NENHUM_REGISTRO_ENCONTRADO);
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response deletePessoa(@PathParam("id") Integer id) {
    	Pessoa pessoa = pessoaService.findById(id);
    	if (pessoa != null) {
    		pessoaService.delete(pessoa);
			return success(pessoa);
		} else {
			return failure(NOT_FOUND, Constantes.NENHUM_REGISTRO_ENCONTRADO);
		}
    }
    
    @GET
    @Path("{id}")
    public Response getPessoa(@PathParam("id") Integer id) {
    	Pessoa pessoa = pessoaService.findById(id);
    	if (pessoa != null) {
    		return success(pessoa);
    	} else {
    		return failure(NOT_FOUND, Constantes.NENHUM_REGISTRO_ENCONTRADO);
    	}
    }


}
