import React from 'react';
import { ToastContainer } from 'react-toastify';
import { PersistGate } from 'redux-persist/integration/react';
import { Router } from 'react-router-dom';
import { Provider } from 'react-redux';

import { CssBaseline, AppBar, Typography, Toolbar } from '@material-ui/core';

import Routes from './routes';
import history from './services/history'

import 'react-toastify/dist/ReactToastify.css';
import 'typeface-roboto';

import { store, persistor } from './store';

function App() {
  return(
    <>
      <CssBaseline />
      <AppBar position="static" color="primary">
        <Toolbar>
          <Typography component="h2" variant="h6" color="initial" gutterBottom>
            Cadastro de Pessoas
          </Typography>
        </Toolbar>
      </AppBar>
      <Provider store={store}>
        <PersistGate persistor={persistor}>
          <Router history={history}>
            <Routes />
            <ToastContainer autoClose={10000} />
          </Router>
        </PersistGate>
      </Provider>
    </>
  );
}

export default App;
