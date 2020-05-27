import produce from 'immer';

const INITIAL_STATE = {
  token: null,
  authenticated: false,
  perfil: null,
  loading: false,
}

export default function auth(state = INITIAL_STATE , action) {
  return produce(state, draft => {
    switch(action.type){
      case '@auth/LOGIN_REQUEST': {
        draft.loading = true;
        break;
      }
      case '@auth/LOGIN_SUCCESS': {
        draft.token = action.payload.token; 
        draft.authenticated = true;
        draft.perfil = action.payload.perfil; 
        draft.loading = false;
        break;
      }
      default:
    }
  });
}