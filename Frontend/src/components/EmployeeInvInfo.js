import { Table } from 'react-bootstrap';
import React from "react";
import { Component } from 'react';
import { useParams } from "react-router-dom"
import { ButtonToolbar } from 'reactstrap';
import { Button } from 'react-bootstrap';
import { AssignInvModal } from './AssignInvModal';
import * as moment from 'moment';


export class EmployeeInvInfo extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            employees: null,
            invs: null,
            assignModalShow: false,
            uninvs: [],
        };
    }

    componentDidMount() {
        this.refreshList();
    }

    refreshList() {

        if (!this.state.invs) {
            fetch('http://localhost:8080/employeeInventoryInfo/searchId/' + window.location.pathname.split("/")[3])
                .then((response) => response.json())
                .then((data) => {
                    this.setState({ invs: data });
                });
                fetch('http://localhost:8080/employeeInventoryInfo/unassignedInv?query')
                .then((response) => response.json())
                .then((data) => {
                    this.setState({ uninvs: data })

                })

                fetch(`http://localhost:8080/employeeInventoryInfo/assign/${this.props.employeeId}/${this.props.inventoryid}` + this.props.employeeId, +this.props.inventoryid, {
                    method: 'POST',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
        
                })

        }
        
    }

    componentDidUpdate() {
        this.refreshList();
    }
    render() {

        const {
            inventorites,
            inventoryid,
            brnd,
            mdl,
            invindate,
            serialno,
            statusid,
            inventorytype,
        } = this.state;

        let assignModalClose = () => this.setState({ assignModalShow: false });
        
        console.log(window.location.pathname.split("/")[3])
        return (
            <div style={{ margin: "40px" }}>
                <h1 className="text-center">Assigned List</h1>

                {/* <ButtonToolbar>
                    <Button
                        variant="primary"
                        onClick={() => this.setState({ assignModalShow: true })}
                    >
                        Assign Inventory
                    </Button>
                </ButtonToolbar>

                <AssignInvModal
                show={this.state.assignModalShow}
                onHide={assignModalClose}
                /> */}
                <div>
                    <Table className="mt-4" striped bordered hover size="sm" >
                        <thead>
                            <tr>
                                <th>Inventory Id</th>
                                <th>Brand</th>
                                <th>Model</th>
                                <th>Inventory In Date</th>
                                <th>SerailNo</th>
                                <th>statusId</th>
                                <th>Inventory Type</th>
                            </tr>
                        </thead>
                        <tbody>
                            {this.state.invs?.map((inv, key) => (
                                <tr key={key}>
                                    <td>{inv.inventoryId}</td>
                                    <td>{inv.brand}</td>
                                    <td>{inv.model}</td>
                                    <td>{moment(inv.inventoryInDate).format('YYYY-MM-DD')}</td>
                                    <td>{inv.serialNo}</td>
                                    <td>{inv.statusId}</td>
                                    <td>{inv.inventoryType}</td>

                                </tr>
                            ))}
                        </tbody>

                    </Table>

                </div>
                <div >
                    <h2 className="text-center">Unassigned List</h2>

                    <div>
                        <Table className="mt-4" striped bordered hover size="sm" >
                            <thead>
                                <tr>
                                    <th>Inventory Id</th>
                                    <th>Brand</th>
                                    <th>Model</th>
                                    <th>Inventory In Date</th>
                                    <th>SerailNo</th>
                                    <th>statusId</th>
                                    <th>Inventory Type</th>
                                    <th>Assign</th>

                                </tr>
                            </thead>
                            <tbody>
                                {this.state.uninvs?.map((uinv, key) => (
                                    <tr key={key}>
                                        <td>{uinv.inventoryId}</td>
                                        <td>{uinv.brand}</td>
                                        <td>{uinv.model}</td>
                                        <td>{moment(uinv.inventoryInDate).format('YYYY-MM-DD')}</td>
                                        <td>{uinv.serialNo}</td>
                                        <td>{uinv.statusId}</td>
                                        <td>{uinv.inventoryType}</td>
                                        <td>
                                        <ButtonToolbar>
                                            <Button
                                            className="mr-2 "
                                            variant='info'
                                             onClick={() =>
                                                this.setState({
                                                  inventoryid: uinv.inventoryId,
                                                  brnd: uinv.brand,
                                                  mdl: uinv.model,
                                                  invindate: uinv.invindate,
                                                  serialno: uinv.serialNo,
                                                  statusid: uinv.statusId,
                                                  inventorytype: uinv.inventoryType,                                                 
                                                })
                                              }
                                            >
                                                Assign
                                            </Button>
                                        </ButtonToolbar>
                                    </td>

                                    </tr>
                                ))}
                            </tbody>

                        </Table>

                        <AssignInvModal
                            inventoryid = {inventoryid}
                            brnd = {brnd}
                            mdl = {mdl}
                            invindate = {invindate}
                            serialno = {serialno}
                            statusid = {statusid}
                            inventorytype = {inventorytype}
                        />

                        

                    </div>
                </div>
            </div>



        )
    }
}

export default EmployeeInvInfo