export function createRequest(payload) {
  return{
    type: '@pessoa/CREATE_REQUEST',
    payload: payload
  };
}

export function createSuccess() {
  return {
    type: '@pessoa/CREATE_SUCCESS',
  };
}

export function createFailure() {
  return {
    type: '@pessoa/CREATE_FAILURE',
  };
}

export function deleteRequest(id) {
  return{
    type: '@pessoa/DELETE_REQUEST',
    payload: { id }
  };
}

export function updateRequest(payload) {
  return{
    type: '@pessoa/UPDATE_REQUEST',
    payload: payload
  };
};