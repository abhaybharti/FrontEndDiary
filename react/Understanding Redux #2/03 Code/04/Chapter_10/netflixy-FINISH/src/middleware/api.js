const api = ({ getState }) => next => action => {
  next(action);
};

export default api;
