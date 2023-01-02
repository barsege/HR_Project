import React, { Component } from "react";
import { NavLink } from "react-router-dom";
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link } from "react-router-dom";

export class Navigation extends Component {
    render() {
        return (
            <nav className="navbar navbar-expand navbar-dark bg-dark" >

                <div className="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div className="navbar-nav">
                        <a className="nav-item nav-link" href="welcome">Home </a>
                        <a className="nav-item nav-link" href="employee_info">Employee Info</a>
                        <a className="nav-item nav-link" href="departments">Department</a>
                        <a className="nav-item nav-link" href="inventoryInfo">Inventory Info</a>
                    </div>
                </div>
                
            <Nav className=" navbar-right" id="navbarNavAltMarkup">
                <Link to = {"register"} className = "nav-item nav-link" >Register</Link>
                <Link to =  {"login"} className = "nav-item nav-link">Login</Link> 
            </Nav>

                
            </nav>
        )
    }
}