import { handleAction } from "redux-actions";

export default handleAction(
  "SET_TECHNOLOGY",
  (state, action) => ({ ...state, tech: action.payload }),
  {}
);
