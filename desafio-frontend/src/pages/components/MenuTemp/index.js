import React from 'react';

import history from '../../../services/history';
import { store } from '../../../store'

import Button from '@material-ui/core/Button';

function MenuTemp() {
  const { perfil } = store.getState().auth;
  
  const onClickButton = (path) =>{ 
    history.push(path)
  }
  return (
    <> {perfil && perfil === 'Administrador' &&
        <Button hidden={true}
          variant="contained"
          color="default"
          onClick={() => {onClickButton('/operators')}}
        >Operadores</Button>
      }
      <Button
        variant="contained"
        color="default"
        onClick={() => {onClickButton('/pessoas')}}
      >Pessoas</Button>
    </>
  );
}

export default MenuTemp;