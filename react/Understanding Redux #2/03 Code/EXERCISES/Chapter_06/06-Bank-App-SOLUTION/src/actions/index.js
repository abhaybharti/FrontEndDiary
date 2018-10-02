import { createAction } from "redux-actions";

export const withdrawMoney = createAction("WITHDRAW");

/**
 * Remember that by default, invoking the action creator returned from calling createAction with a single parameter will have that parameter in the payload of the returned action.
 *
 * e.g. withdrawMoney(1000) === {
 *    type: "WITHDRAW",
 *    payload: 1000
 *  }
 */
