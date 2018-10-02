import axios from "axios";
import { FETCH_USER_DETAILS } from "./types";

export const fetchUserDetails = () => ({
  type: FETCH_USER_DETAILS,
  payload: axios.get("https://api.myjson.com/bins/y4q7g")
});

export const withdrawMoney = amount => ({
  type: "WITHDRAW",
  payload: amount
});
