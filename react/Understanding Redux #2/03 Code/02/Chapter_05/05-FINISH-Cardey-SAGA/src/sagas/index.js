// this is tiny project, so we'll have all sagas in this one folder
import axios from "axios";
import { all, call, put, takeEvery } from "redux-saga/effects";
import { FETCH_USER_PROFILE } from "../actions/types";
import { setUserProfile } from "../actions";

//worker saga - async generator
function* fetchUserProfile() {
  const response = yield call(axios.get, "http://api.myjson.com/bins/17eyds");
  yield put(setUserProfile(response.data));
}

//watcher saga
function* watchFetchUserProfile() {
  yield takeEvery(FETCH_USER_PROFILE, fetchUserProfile);
}

//random saga - hello world!
function* helloSaga() {
  yield console.log("Hello Saga!");
}

// add all sagas required to be run on start 👇
export default function* rootSaga() {
  yield all([watchFetchUserProfile(), helloSaga()]);
}
