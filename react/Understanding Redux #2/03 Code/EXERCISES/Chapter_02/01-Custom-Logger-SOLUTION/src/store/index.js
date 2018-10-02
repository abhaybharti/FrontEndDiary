import { createStore, applyMiddleware } from "redux";
import reducer from "../reducers";
import loggingMiddleware from "../middleware/loggingMiddleware";

const initialState = { tech: "React " };
export const store = createStore(
  reducer,
  initialState,
  applyMiddleware(loggingMiddleware)
);
