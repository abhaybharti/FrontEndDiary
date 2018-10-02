import { createStore, applyMiddleware } from "redux";
import logger from "redux-logger";
import reducer from "../reducers";

const initialState = { tech: "React " };
export const store = createStore(
  reducer,
  initialState,
  applyMiddleware(logger)
);
