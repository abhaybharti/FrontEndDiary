import { handleAction } from "redux-actions";

export default handleAction(
  "WITHDRAW",
  (state, action) => ({
    ...state,
    totalAmount: state.totalAmount - action.payload
  }),
  {}
);

//NB: handleAction(type, reducer, initialState)
