import { FETCH_USER_PROFILE } from "../actions/types";

const reducer = (state, action) => {
  console.log(action);
  switch (action.type) {
    case FETCH_USER_PROFILE:
      return {
        ...action.payload.data,
        isLoading: false
      };

    default:
      return state;
  }
};

export default reducer;
