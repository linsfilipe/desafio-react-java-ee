import React from 'react';
import { Switch, Route } from 'react-router-dom';
import PrivateRoute from './PrivateRoute';
import { store } from '../store';

import Login from '../pages/Login';
import Home from '../pages/Home';

import Operator from '../pages/Operator';
import OperatorNew from '../pages/Operator/new';
import OperatorUpdate from '../pages/Operator/update';

import Pessoa from '../pages/Pessoa'
import PessoaNew from '../pages/Pessoa/new'

import { Container } from '@material-ui/core';

const Routes = () => (
    <>
      <Switch>
        <>
          <Container>
            <Route path="/" exact component={Login} />
            <PrivateRoute path="/home" exact component={Home}/>
            <PrivateRoute path="/pessoas" exact component={Pessoa}/>
            <PrivateRoute path="/pessoa" exact component={PessoaNew}/>
            <PrivateRoute path="/operators" exact component={Operator}/>
            <PrivateRoute path="/operator" exact component={OperatorNew} />
            <PrivateRoute path="/operator/:id" exact component={OperatorUpdate} />
          </Container>
        </>
      </Switch>
    </>
);

export default Routes;