import { SET_USER_DETAILS } from "../actions/types";

const reducer = (state, action) => {
  switch (action.type) {
    case "WITHDRAW":
      return {
        ...state,
        totalAmount: state.totalAmount - action.payload
      };
    case SET_USER_DETAILS:
      return {
        ...action.payload,
        isLoading: false
      };
    default:
      return state;
  }
};
export default reducer;
