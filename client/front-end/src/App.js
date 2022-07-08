import { Container } from "@mui/material";
import React from "react";
import {Route, Switch } from "react-router-dom";
import Navigation from "./components/Navigation";
import Boards from "./pages/Boards";
import CreateBoard from "./pages/CreateBoard";
import ForgotPasswordPage from "./pages/ForgotPassword";
import HomePage from "./pages/Home";
import LoginPage from "./pages/Login";
import RegisterPage from "./pages/Register";


function App() {
  return (
    <div>
      <Navigation />
      <Container>
        <Switch>
          <Route path={["/", "/boards"]} exact>
            <Boards />
          </Route>
          <Route path='/forgot-password' exact>
            <ForgotPasswordPage />
          </Route>
          <Route path='/create-board' exact>
            <CreateBoard />
          </Route>
          <Route path="/register">
            <RegisterPage />
          </Route>
          <Route path={["/", "/login"]} exact>
            <LoginPage />
          </Route>
          <Route path="/home">
            <HomePage />
          </Route>
        </Switch>
      </Container>
    </div>
  );
}

export default App;
