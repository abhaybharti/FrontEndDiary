import { createAction } from "redux-actions";

export const setActiveSession = createAction("SET_ACTIVE_SESSION");

export const updateCounter = (type, activeSession) =>
  createAction(type)(activeSession);
