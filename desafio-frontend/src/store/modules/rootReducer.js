import { combineReducers } from 'redux';

import auth from './auth/reducer';
import operator from './operator/reducer';
import pessoa from './pessoa/reducer';

export default combineReducers({
  auth, operator, pessoa
});
