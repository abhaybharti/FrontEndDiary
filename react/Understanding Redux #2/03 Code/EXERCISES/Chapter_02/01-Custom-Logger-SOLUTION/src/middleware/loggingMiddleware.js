const loggingMiddleware = ({ getState, dispatch }) => next => action => {
  //pass action on to the next middleware/reducers
  const beforeState = getState();
  next(action);
  const afterState = getState();

  console.group("state logger");
  console.log(
    "%c state upon reaching middleware 👉 ",
    "background:purple;color:white",
    beforeState
  );
  console.log(
    "%c current state of the app 👉 ",
    "background:yellow;color:black",
    afterState
  );
  console.groupEnd("state logger");
};

export default loggingMiddleware;
