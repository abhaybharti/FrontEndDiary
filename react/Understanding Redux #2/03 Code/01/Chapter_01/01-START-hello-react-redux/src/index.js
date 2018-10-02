import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./containers/App";
import { store } from "./store";
import registerServiceWorker from "./registerServiceWorker";

const render = () => ReactDOM.render(<App />, document.getElementById("root"));

render();
store.subscribe(render);

registerServiceWorker();
