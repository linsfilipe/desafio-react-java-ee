import { all, takeLatest, call, put } from 'redux-saga/effects';
import { toast } from 'react-toastify';

import api from '../../../services/api';
import history from '../../../services/history';

import { createSuccess, createFailure } from './actions';

export function* createOperator({ payload }) {
  try {
    const { nome, login, senha, perfil } = payload;

    yield call(api.post, 'operators', {
      nome,
      login,
      senha,
      perfil
    });

    yield put(createSuccess());
    history.push('/operators');
  } catch (err) {
    toast.error('Falha ao criar o operador.')
    yield put(createFailure());
  }
}

export function* deleteOperator({ payload }) {
  try {
    const { id } = payload;
    
    yield call(api.delete, `operators/${id}`);


    history.go('/operators')
  } catch (err) {
    toast.error('Falha ao excluir o operador.')
  }
}

export function* updateOperator({ payload }) {
  try {
    const { id, nome, login, senha, perfil } = payload;

    const response = yield call(api.put, 'operators', {
      id,
      nome,
      login,
      senha,
      perfil
    });

    console.log(response);

    history.push('/operators');
  } catch (err) {
    toast.error('Falha ao atualizar o operador.')
  }
}

export default all([
  takeLatest('@operator/CREATE_REQUEST', createOperator),
  takeLatest('@operator/UPDATE_REQUEST', updateOperator),
  takeLatest('@operator/DELETE_REQUEST', deleteOperator),
]);