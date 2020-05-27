import { all, takeLatest, call, put } from 'redux-saga/effects';
import { toast } from 'react-toastify';

import api from '../../../services/api';
import history from '../../../services/history';

import { createSuccess, createFailure } from './actions';

export function* createPessoa({ payload }) {
  try {
    yield call(api.post, 'pessoa', payload);

    yield put(createSuccess());
    history.push('/pessoas');
  } catch (err) {
    toast.error('Falha ao criar Pessoa.')
    yield put(createFailure());
  }
}

export function* deletePessoa({ payload }) {
  try {
    const { id } = payload;
    
    yield call(api.delete, `pessoa/${id}`);


    history.go('/pessoas')
  } catch (err) {
    toast.error('Falha ao excluir Pessoa.')
  }
}

export function* updatePessoa({ payload }) {
  try {

    yield call(api.put, 'pessoa', {
      payload
    });

    history.push('/pessoas');
  } catch (err) {
    toast.error('Falha ao atualizar o operador.')
  }
}

export default all([
  takeLatest('@pessoa/CREATE_REQUEST', createPessoa),
  takeLatest('@pessoa/UPDATE_REQUEST', updatePessoa),
  takeLatest('@pessoa/DELETE_REQUEST', deletePessoa),
]);