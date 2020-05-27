import React, { useEffect, useState } from 'react';
import { useDispatch } from 'react-redux';

import { useForm } from 'react-hook-form';
import { Button } from '@material-ui/core';

import { createRequest } from '../../store/modules/operator/actions';

import api from '../../services/api';

function Operator() {
  const dispatch = useDispatch();
  const [profiles, setProfiles] = useState([]);

  useEffect(() => {
    async function loadProfiles(){
      const response = await api.get('/profiles');

      setProfiles(response.data);
    };

    loadProfiles();
  }, []);

  const { register, handleSubmit, errors } = useForm();

  const onSubmit = ({ nome, login, senha, perfilId }) => {
    const perfil = {
      id: perfilId
    }
    dispatch(createRequest(nome, login, senha, perfil));
  }

  return (
    <>
      <h1>Criar Operador</h1>

      <form onSubmit={handleSubmit(onSubmit)} autoComplete="off">
        <input type="text" placeholder="Nome" name="nome" maxLength="100" ref={register({ required: true }) } />
        {errors.nome && <small>O Nome é obrigatório</small>}
        <br />
        
        <input type="text" placeholder="Login" name="login" maxLength="15" ref={register({ required: true }) } />
        {errors.login && <small>O Login é obrigatório</small>}
        <br />

        <input placeholder="Senha" type="password" name="senha" minLength="6" maxLength="15" ref={register({ required: true })} />
        {errors.senha && <small>O Senha é obrigatória</small>}
        <br />

        <label id="lbPerfil">Perfil</label>

        <select name="perfilId" ref={register ({ required: true })}>
        <option value="">Selecione</option>
          { profiles &&
            profiles.map((profile) => (
              <option key={profile.id} value={profile.id}>{profile.nome}</option>
            ))
          }
        </select>
        {errors.perfilId && <small>O Perfil é obrigatório</small>}
        <br />

        <Button type="submit">Criar</Button>
      </form>
    </>
  );
}

export default Operator;