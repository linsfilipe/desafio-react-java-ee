import produce from 'immer';

const INITIAL_STATE = {};

export default function operator(state = INITIAL_STATE , action) {
  return produce(state, draft => {
    switch(action.type){
      case '@operator/CREATE_SUCCESS': {
        break;
      }
      default:
    }
  });
}