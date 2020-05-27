package com.github.linsfilipe.controllers;

import java.io.Serializable;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.github.linsfilipe.domains.dtos.ResponseErrorDTO;

public abstract class BaseController {

    protected <T extends Serializable> Response success(final List<T> objects) {
        return Response.ok()
                .entity(objects)
                .build();
    }
    
    protected <T extends Serializable> Response success(final T body) {
    	return Response.ok()
    			.entity(body)
    			.build();
    }

	protected <T extends Serializable> Response failure(final Status code, final String errorMessage) {
		ResponseErrorDTO responseErrorDTO = new ResponseErrorDTO(code.getStatusCode(), errorMessage);
		return Response.status(code)
				.entity(responseErrorDTO)
				.build();
	}

}
