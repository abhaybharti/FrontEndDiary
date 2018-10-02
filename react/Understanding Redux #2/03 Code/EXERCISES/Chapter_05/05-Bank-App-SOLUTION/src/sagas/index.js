import axios from "axios";
import { takeEvery, put, call, all } from "redux-saga/effects";
import { FETCH_USER_DETAILS } from "../actions/types";
import { setUserDetails } from "../actions";

//worker saga
function* fetchUserDetails() {
  const response = yield call(axios.get, "https://api.myjson.com/bins/y4q7g");
  yield put(setUserDetails(response.data));
}
//watcher saga
function* watchFetchUserDetails() {
  yield takeEvery(FETCH_USER_DETAILS, fetchUserDetails);
}

//test saga - hello world!
function* helloSaga() {
  yield console.log("Hello Saga!");
}

export default function* rootSaga() {
  yield all([watchFetchUserDetails(), helloSaga()]);
}
