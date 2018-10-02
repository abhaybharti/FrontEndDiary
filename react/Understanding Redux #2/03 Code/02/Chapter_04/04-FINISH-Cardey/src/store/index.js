import { createStore, applyMiddleware } from "redux";
import promiseMiddleware from "redux-promise";
import reducer from "../reducers";

const initialState = {};

const store = createStore(
  reducer,
  initialState,
  applyMiddleware(promiseMiddleware)
);

export default store;
