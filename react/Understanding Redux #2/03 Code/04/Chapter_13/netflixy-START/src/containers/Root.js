import React from "react";
import { Provider } from "react-redux";
import { BrowserRouter as Router } from "react-router-dom";
import store from "../store";
import DevTools from "./DevTools";
import StyledContainer from "../components/StyledContainer";
import { ThemeProvider } from "styled-components";
import { ToastContainer } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import theme from "../constants/theme";
import App from "../components/App";

const Root = () => {
  return (
    <Provider store={store}>
      <ThemeProvider theme={theme}>
        <StyledContainer>
          <Router>
            <App />
          </Router>
          <DevTools />
          <ToastContainer />
        </StyledContainer>
      </ThemeProvider>
    </Provider>
  );
};

export default Root;
