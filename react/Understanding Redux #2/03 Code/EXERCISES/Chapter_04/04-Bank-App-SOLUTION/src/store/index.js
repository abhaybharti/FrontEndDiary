import { createStore, applyMiddleware } from "redux";
import reduxPromise from "redux-promise";
import reducer from "../reducers";

const initialState = {};

const store = createStore(reducer, initialState, applyMiddleware(reduxPromise));
export default store;
