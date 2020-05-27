export function createRequest(nome, login, senha, perfil) {
  return{
    type: '@operator/CREATE_REQUEST',
    payload: { nome, login, senha, perfil }
  };
}

export function createSuccess() {
  return {
    type: '@operator/CREATE_SUCCESS',
  };
}

export function createFailure() {
  return {
    type: '@operator/CREATE_FAILURE',
  };
}

export function deleteRequest(id) {
  return{
    type: '@operator/DELETE_REQUEST',
    payload: { id }
  };
}

export function updateRequest(id, nome, login, senha, perfil) {
  return{
    type: '@operator/UPDATE_REQUEST',
    payload: { id, nome, login, senha, perfil }
  };
}