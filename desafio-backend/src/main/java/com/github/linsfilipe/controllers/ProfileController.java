package com.github.linsfilipe.controllers;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import static javax.ws.rs.core.Response.Status.NOT_FOUND;

import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.apache.commons.collections4.CollectionUtils;

import com.github.linsfilipe.domains.dtos.ProfileDTO;
import com.github.linsfilipe.domains.models.Profile;
import com.github.linsfilipe.services.IProfileService;

@Path("/profiles")
@Produces(APPLICATION_JSON)
public class ProfileController extends BaseController {

    @Inject
    private IProfileService profileService;

    @GET
    public Response getOperators() {
        final List<Profile> profiles = profileService.findAll();
        
		List<ProfileDTO> profilesNaoAdministrador = profiles.stream()
				.filter(p -> !p.getNome().equalsIgnoreCase("Administrador"))
				.map(p -> new ProfileDTO(p.getId(), p.getNome())).collect(Collectors.toList());
        
        if (CollectionUtils.isNotEmpty(profilesNaoAdministrador)) {
            return success(profilesNaoAdministrador);
        } else {
            return failure(NOT_FOUND, "Nenhum registro encontrado");
        }
    }

}
