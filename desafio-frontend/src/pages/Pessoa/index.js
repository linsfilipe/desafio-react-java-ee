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
         Button,
         Typography 
        } from '@material-ui/core';
import MenuTemp from '../components/MenuTemp';

import api from '../../services/api';
import history from '../../services/history';
import { deleteRequest } from '../../store/modules/pessoa/actions';

const useStyles = makeStyles((theme) => ({
  body: {
    width: '100%',
    margin: 'auto',
    marginTop: theme.spacing(10),
    display: 'flex',
    flexDirection: 'column',
    justify: 'space-between'
  },
  button_create:{
    alignItems: 'flex-start',
  },
}));

function Pessoa() {
  const dispatch = useDispatch();
  
  const classes = useStyles();
  const [pessoas, setPessoas] = useState([]);

  useEffect(() => {
    async function loadPessoas(){
      const response = await api.get('/pessoa');
      setPessoas(response.data);
    };

    loadPessoas();
  }, []);

  const onClickEdit = (pessoaId) =>{ 
    history.push(`/pessoa/${pessoaId}`)
  }

  const onClickDelete = (pessoaId) =>{ 
    dispatch(deleteRequest(pessoaId));
  }

  const onClickNew = () =>{ 
    history.push(`/pessoa/`)
  }

  return (
    <>
      <br />
      <MenuTemp></MenuTemp>
      <br />
      <Typography variant="h3" component="h2">
        Pessoas
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
                <TableCell align="left">Nome</TableCell>
                <TableCell align="left">Documento</TableCell>
                <TableCell align="left">Data de Nascimento</TableCell>
                <TableCell align="left">Data de Cadastro</TableCell>
                <TableCell align="left">Tipo de Pessoa</TableCell>
                <TableCell align="left">Login do Operador</TableCell>
                <TableCell align="left">Ações</TableCell>
                <TableCell align="left"></TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {
                pessoas.map((pessoa) => (
                <TableRow key={pessoa.id}>
                  <TableCell align="left">{pessoa.nome}</TableCell>
                  <TableCell align="left">{pessoa.documento}</TableCell>
                  <TableCell align="left">{pessoa.dataNascimentoFormatada}</TableCell>
                  <TableCell align="left">{pessoa.dataCadastroFormatada}</TableCell>
                  <TableCell align="left">{pessoa.tipoPessoa}</TableCell>
                  <TableCell align="left">{pessoa.loginOperador}</TableCell>
                  <TableCell align="left">
                      <Button
                        variant="contained"
                        color="primary"
                        onClick={() => {onClickEdit(pessoa.id)}}
                        disabled
                      >
                        Editar
                      </Button>
                </TableCell>
                  <TableCell align="left">
                      <Button
                        variant="contained"
                        color="secondary"
                        onClick={() => {onClickDelete(pessoa.id)}}
                      >
                        Excluir
                      </Button>
                </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </TableContainer>
        <br />
      </div>
    </>
  );
}

export default Pessoa;