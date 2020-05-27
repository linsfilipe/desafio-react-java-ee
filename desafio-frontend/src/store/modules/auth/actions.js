export function loginRequest(login, senha) {
  return{
    type: '@auth/LOGIN_REQUEST',
    payload: { login, senha }
  };
}

export function loginSuccess(token, perfil) {
  return {
    type: '@auth/LOGIN_SUCCESS',
    payload: { token, perfil },
  };
}

export function loginFailure() {
  return {
    type: '@auth/LOGIN_FAILURE',
  };
}