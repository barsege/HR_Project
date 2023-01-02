import React from "react";
import './App.css';
import EmployeeInfoComponent from "./components/EmployeeInfoComponent";
import { BrowserRouter, Routes, Route,useParams } from 'react-router-dom';
import { Home } from './components/Home'
import DepartmentComponent, { Department } from './components/DepartmentComponent'
import { Navigation } from './components/Navigation'
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import { InventoryInfoComponent } from "./components/InventoryInfoComponent";
import {EmployeeInvInfo} from "./components/EmployeeInvInfo";
import Login from "./components/User/Login";
import Register from "./components/User/Register";


// function Id() {
//   let { id } = useParams();
//   return id
// }

function App() {


  return (
    <BrowserRouter>
      <div className="App">

        <h5 className="m-3 d-flex justify-content-center">
          Employee Managment Portal
        </h5>
        <Navigation />
        <Routes>
          <Route path='/welcome' element={<Home />} />
          <Route path='/departments' element={<DepartmentComponent />} />
          <Route path='/employee_info' exact element={<EmployeeInfoComponent />} />
          <Route path='/inventoryInfo' element={<InventoryInfoComponent />} />
          <Route path={`/employeeInventoryInfo/searchId/:id`} exact element={<EmployeeInvInfo />} />
          <Route path={`/employeeInventoryInfo/assign/:id/:id`} exact element={<EmployeeInvInfo />} />

          {/* <Route path = "/register" element = {<Register/>}/>
          <Route path = "/login" element = {<Login/>}/> */}
          
            
        </Routes>
      </div>
    </BrowserRouter>
  );
}

export default App;




/*
import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';

const App = () => {

  const [groups, setGroups] = useState([]);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    setLoading(true);

    fetch('employee_info/searchAll?query')
      .then(response => response.json())
      .then(data => {
        setGroups(data);
        setLoading(false);
      })
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <div className="App-intro">
          <h2>Employees</h2>
          {groups.map(group =>
            <div key={group.id}>
              {group.name}
            </div>
          )}
        </div>
      </header>
    </div>
  );
}

export default App;
*/