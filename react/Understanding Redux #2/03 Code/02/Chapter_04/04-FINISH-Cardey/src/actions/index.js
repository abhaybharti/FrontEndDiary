import axios from "axios";
import { FETCH_USER_PROFILE } from "./types";

export function fetchUserProfile() {
  return {
    type: FETCH_USER_PROFILE,
    payload: axios.get("http://api.myjson.com/bins/17eyds")
  };
}
