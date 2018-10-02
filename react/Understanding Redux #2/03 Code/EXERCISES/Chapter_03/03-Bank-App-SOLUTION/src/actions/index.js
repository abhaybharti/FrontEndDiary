import axios from "axios";
import { SET_USER_DETAILS } from "./types";

export const withdrawMoney = amount => ({
  type: "WITHDRAW",
  payload: amount
});

export function fetchUserDetails() {
  return (dispatch, getState) => {
    axios.get("https://api.myjson.com/bins/y4q7g").then(response => {
      dispatch(setUserDetails(response.data));
    });
  };
}

function setUserDetails(data) {
  return {
    type: SET_USER_DETAILS,
    payload: data
  };
}
