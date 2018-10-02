import { FETCH_USER_DETAILS } from "../actions/types";

const reducer = (state, action) => {
  switch (action.type) {
    case "WITHDRAW":
      return {
        ...state,
        totalAmount: state.totalAmount - action.payload
      };

    case FETCH_USER_DETAILS:
      return {
        ...action.payload.data,
        isLoading: false
      };

    default:
      return state;
  }
};
export default reducer;
