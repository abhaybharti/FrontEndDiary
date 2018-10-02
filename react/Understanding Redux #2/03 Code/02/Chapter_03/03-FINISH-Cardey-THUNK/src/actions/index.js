import axios from "axios";
import { SET_USER_PROFILE } from "./types";

export function fetchUserProfile() {
  return (dispatch, getState) => {
    axios.get("http://api.myjson.com/bins/17eyds").then(response => {
      dispatch(setUserProfile(response.data));
    });
  };
}

function setUserProfile(data) {
  return {
    type: SET_USER_PROFILE,
    payload: data
  };
}
