import { FETCH_USER_DETAILS, SET_USER_DETAILS } from "./types";

export const fetchUserDetails = () => ({
  type: FETCH_USER_DETAILS
});

export const withdrawMoney = amount => ({
  type: "WITHDRAW",
  payload: amount
});

export const setUserDetails = data => ({
  type: SET_USER_DETAILS,
  payload: data
});
