import { all, takeLatest, call, put } from 'redux-saga/effects';
import { toast } from 'react-toastify';

import api from '../../../services/api';
import history from '../../../services/history';

import { loginSuccess, loginFailure } from './actions';

export function* login({ payload }) {
  try {
    const { login, senha } = payload;

    const response = yield call(api.post, 'auth', {
      login,
      senha
    });
    
    const { token, perfil }  = response.data;

    api.defaults.headers.Authorization = `Bearer ${token}`;

    yield put(loginSuccess(token, perfil));
    history.push('/pessoas');
  } catch (err) {
    toast.error('O login e a senha fornecidos não correspondem às informações em nossos registros. Verifique-as e tente novamente.')
    yield put(loginFailure());
  }
}

export function setToken({ payload }) {
  if(!payload) return;

  const { token } = payload.auth;

  if (token) {
    api.defaults.headers.Authorization = `Bearer ${token}`;
  }
}

export default all([
  takeLatest('persist/REHYDRATE', setToken),
  takeLatest('@auth/LOGIN_REQUEST', login),
]);