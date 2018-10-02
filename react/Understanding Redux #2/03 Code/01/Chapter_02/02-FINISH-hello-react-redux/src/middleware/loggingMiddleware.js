const loggingMiddleware = ({ getState, dispatch }) => next => action => {
  //pass action on to the next middleware/reducers
  next(action);
  console.log(
    "%c current state of the app 👉 ",
    "background:purple;color:white",
    getState()
  );
};

export default loggingMiddleware;
