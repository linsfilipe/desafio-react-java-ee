import React, { useEffect, useState } from 'react';
import { useDispatch } from 'react-redux';

import { useForm } from 'react-hook-form';
import { Button } from '@material-ui/core'

import api from '../../services/api'

import { updateRequest } from '../../store/modules/operator/actions';


function Operator(props) {
  const operatorId = props.match.params.id;
  
  const [operator, setOperator] = useState();
  const [profiles, setProfiles] = useState([]);
  
  const dispatch = useDispatch();
  
  useEffect(() => {
    async function loadProfiles(){
      const response = await api.get('/profiles');

      setProfiles(response.data);
    };

    loadProfiles();
  }, []);
  

  useEffect(() => {
    async function loadOperator() {
      const response = await api.get(`/operators/${operatorId}`);
      const operator = response.data;
      setOperator(operator);

      setValue("nome", operator.nome);
      setValue("login", operator.login);
      setValue("senha", operator.senha);
      setValue("perfilId", operator.perfil.id);
    }

    loadOperator();
  }, [operatorId]);

  const { register, handleSubmit, setValue, errors } = useForm(operator);

  const onSubmit = ({ nome, login, senha, perfilId }) => {
    const perfil = {
      id: perfilId
    }
    dispatch(updateRequest(operatorId, nome, login, senha, perfil));
  }

  return (
    <>
      <h1>Atualizar Operador</h1>

      <form onSubmit={handleSubmit(onSubmit)} autoComplete="off">
        <input type="text" placeholder="Nome" name="nome" ref={register({ required: true }) } />
          {errors.nome && <small>O Nome é obrigatório</small>}
          <br />
          
          <input type="text" placeholder="Login" name="login" ref={register({ required: true }) } />
          {errors.login && <small>O Login é obrigatório</small>}
          <br />
          

          <input placeholder="Senha" type="password" name="senha" ref={register({ required: true })} />
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

        <Button type="submit">Atualizar</Button>
      </form>
    </>
  );
}

export default Operator;