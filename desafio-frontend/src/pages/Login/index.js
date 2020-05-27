import React from 'react';
import { useDispatch } from 'react-redux';

import { useForm } from 'react-hook-form';

import { loginRequest } from '../../store/modules/auth/actions';

function SignIn() {
  const dispatch = useDispatch();

  const { register, handleSubmit, errors } = useForm();
  const onSubmit = ({ login, senha }) => {
    dispatch(loginRequest(login, senha));
  }


  return (
    <>
      <h1>Login</h1>

      <form onSubmit={handleSubmit(onSubmit)}>
        <input type="text" placeholder="Login" name="login" ref={register({ required: true }) } />
        {errors.email && <small>O Email é obrigatório</small>}
        <br />

        <input type="password" placeholder="Senha" name="senha" ref={register({ required: true })} />
        {errors.password && <small>O Senha é obrigatória</small>}
        <br />

        <button type="submit">Login</button>

      </form>
    </>
  );
}

export default SignIn;