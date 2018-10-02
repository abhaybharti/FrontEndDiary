import { combineReducers } from "redux";
import ReduxUndo from "redux-undo";
import user from "./user";
import messages from "./messages";
import typing from "./typing";
import contacts from "./contacts";
import activeUserId from "./activeUserId";
import activeChatId from "./activeChatId";

export default combineReducers({
  user,
  messages: ReduxUndo(messages),
  typing,
  contacts,
  activeChatId,
  activeUserId
});
