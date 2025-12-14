import React from "react";
import Login from "./components/Login";
import Register from "./components/Register";
import './App.css';  // optional, agar tum CSS use karna chahte ho

function App() {
  return (
    <div>
      <h1>SweetShop Assignment</h1>
      <Register />
      <Login />
    </div>
  );
}

export default App;
