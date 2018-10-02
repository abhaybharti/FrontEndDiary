import React from "react";
import { ActionCreators } from "redux-undo";
import store from "../store";
import "./Header.css";

function Header({ user }) {
  const { name, status } = user;

  //type can be either redo or undo
  const handleRedoUndo = type => {
    store.dispatch(ActionCreators[type]());
  };

  return (
    <header className="Header">
      <div>
        <h1 className="Header__name">{name}</h1>
        <p className="Header__status">{status}</p>
      </div>
      <div>
        <button onClick={handleRedoUndo.bind(null, "undo")}>undo</button>
        <button onClick={handleRedoUndo.bind(null, "redo")}>redo</button>
      </div>
    </header>
  );
}

export default Header;
