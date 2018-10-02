import { FETCH_USER_PROFILE, SET_USER_PROFILE } from "./types";

export const fetchUserProfile = () => ({
  type: FETCH_USER_PROFILE
});

export const setUserProfile = data => ({
  type: SET_USER_PROFILE,
  payload: data
});
