import React, { useState, useEffect } from 'react';
import { useDispatch } from 'react-redux';

import { makeStyles } from '@material-ui/core/styles';
import { Table, 
         TableBody, 
         TableCell, 
         TableContainer, 
         TableHead, 
         TableRow, 
         Paper,
         Checkbox,
         Button,
         Typography } from '@material-ui/core';

import api from '../../services/api';
import history from '../../services/history';
import { deleteRequest } from '../../store/modules/operator/actions';

import MenuTemp from '../components/MenuTemp';

const useStyles = makeStyles((theme) => ({
  body: {
    width: '100%',
    margin: 'auto',
    marginTop: theme.spacing(10),
    display: 'flex',
    flexDirection: 'column',
    justify: 'space-between'
  },
  button_delete:{
    alignSelf: 'flex-end',
  },
  button_create:{
    alignItems: 'flex-start',
  },
}));

function Operator() {
  const dispatch = useDispatch();
  
  const classes = useStyles();
  const [operators, setOperators] = useState([]);
  const [selected, setSelected] = useState([]);


  useEffect(() => {
    async function loadOperators(){
      const response = await api.get('/operators');

      setOperators(response.data);
    };

    loadOperators();
  }, []);

  const handleClick = (event, id) => {
    const selectedIndex = selected.indexOf(id);
    let newSelected = [];

    if (selectedIndex === -1) {
      newSelected = newSelected.concat(selected, id);
    } else if (selectedIndex === 0) {
      newSelected = newSelected.concat(selected.slice(1));
    } else if (selectedIndex === selected.length - 1) {
      newSelected = newSelected.concat(selected.slice(0, -1));
    } else if (selectedIndex > 0) {
      newSelected = newSelected.concat(
        selected.slice(0, selectedIndex),
        selected.slice(selectedIndex + 1),
      );
    }

    setSelected(newSelected);
  };

  const onSubmit = () => {
    console.log(selected);
    selected.forEach(id => {
      dispatch(deleteRequest(id));
    })
  }

  const onClickEdit = (perfilId) =>{ 
    history.push(`/operator/${perfilId}`)
  }

  const onClickNew = () =>{ 
    history.push(`/operator/`)
  }

  return (
    <>
      <br />
      <MenuTemp></MenuTemp>
      <br />
      <Typography variant="h3" component="h2">
        Operadores
      </Typography>
      <div className={classes.body}>
        <div className={classes.button_create}>
          <Button
            variant="contained"
            color="primary"
            onClick={() => {onClickNew()}}
            className={classes.button_create}
          >
            Novo
          </Button>
        </div>
        <br />
        <TableContainer component={Paper}>
          <Table aria-label="simple table">
            <TableHead>
              <TableRow>
                <TableCell padding="checkbox" />
                <TableCell align="left">Nome</TableCell>
                <TableCell align="left">Login</TableCell>
                <TableCell align="left">Data de Cadastro</TableCell>
                <TableCell align="left">Editar</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {
                operators.map((operator) => (
                <TableRow key={operator.id}>
                  <TableCell padding="checkbox">
                    <Checkbox
                      onClick={(event) => handleClick(event, operator.id)} />
                  </TableCell>
                  <TableCell align="left">{operator.nome}</TableCell>
                  <TableCell align="left">{operator.login}</TableCell>
                  <TableCell align="left">{operator.dataCadastro}</TableCell>
                  <TableCell align="left">
                      <Button
                        variant="contained"
                        color="primary"
                        onClick={() => {onClickEdit(operator.id)}}
                      >
                        Editar
                      </Button>
                </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
        <br />
        <div className={classes.button_delete}>
          <Button onClick={onSubmit} variant="contained" color="secondary">Excluir</Button>
        </div>
      </div>
    </>
  );
}

export default Operator;