import { handleActions } from "redux-actions";

/**
 * NB: So far, we've only used "handleAction" for handling a single action type.
 * However, in real world apps, a reducer may handle multiple action types as seen in this example.
 *
 * To handle multiple action types, redux-actions exports the utility function, "handleActions" - note the plural form.
 * It works by passing an object with key-value pairs of the action type and reducer. i.e key = action type. value = reducer.
 *
 * e.g.
 *
 * handleActions({
 *   actionType: reducer,
 *   actionType2: reducer2,
 *   actionType3: reducer3
 * }, initialState)
 */

export default handleActions(
  {
    SET_ACTIVE_SESSION: (state, action) => ({
      ...state,
      activeSession: action.payload
    }),
    INCREASE_COUNTER: (state, action) => {
      const activeSession = action.payload.toLowerCase();
      return {
        ...state,
        [activeSession]: state[activeSession] + 1
      };
    },
    DECREASE_COUNTER: (state, action) => {
      const session = action.payload.toLowerCase();
      return {
        ...state,
        [session]: Math.max(0, state[session] - 1)
      };
    }
  },
  {}
);
