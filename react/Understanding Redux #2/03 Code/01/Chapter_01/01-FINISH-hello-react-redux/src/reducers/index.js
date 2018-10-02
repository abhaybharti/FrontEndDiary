export default (state, action) => {
  switch (action.type) {
    case "SET_TECHNOLOGY":
      console.log(action);
      return {
        ...state,
        tech: action.tech
      };

    default:
      return state;
  }
};
