import { persistReducer } from 'redux-persist';
import storage from 'redux-persist/lib/storage';

export default (reducers) => {
  const persistedReducer = persistReducer({
      key: 'desafio',
      storage,
      whitelist: ['auth']
    },
    reducers
  );

  return persistedReducer;
};