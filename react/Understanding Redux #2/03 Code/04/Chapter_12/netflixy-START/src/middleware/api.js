const api = ({ getState }) => next => action => {
  console.log("api middleware on point");
  next(action);
};

export default api;
