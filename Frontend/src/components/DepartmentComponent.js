import React, { Component } from "react";
import { Table, Modal, ModalHeader, ModalBody, ModalFooter } from "reactstrap";
import { Button, ButtonToolbar } from "react-bootstrap";
import { AddDepModal } from "./AddDepModal";
import DepartmentService from "../services/DepartmentService";
import { EditDepModal } from "./EditDepModal";
export class DepartmentComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { deps: null, addModalShow: false, editModalShow: false };
    }
    componentDidMount() {
        this.refreshList();
    }
    refreshList() {
        if (!this.state.deps) {
            fetch("http://localhost:8080/departments/search?query")
                .then((response) => response.json())
                .then((data) => {
                    this.setState({ deps: data });
                });
        }
    }
    componentDidUpdate() {
        this.refreshList();
    }
    render() {
        const { deps, depid, depname } = this.state;
        let addModalClose = () => this.setState({ addModalShow: false });
        let editModalClose = () => this.setState({ editModalShow: false });
        return (
            <div style={{ margin: "40px" }}>
                <h1 className="text-center">Department List</h1>
                <ButtonToolbar>
                    <Button
                        variant="primary"
                        onClick={() => this.setState({ addModalShow: true })}
                    >
                        Add Department
                    </Button>
                    <AddDepModal show={this.state.addModalShow} onHide={addModalClose} />
                </ButtonToolbar>
                <Table className="mt-4" striped bordered hover size="sm">
                    <thead>
                        <tr>
                            <th>Department Id</th>
                            <th>Department Name</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        {deps?.map((dep) => (
                            <tr key={dep.deptId}>
                                <td>{dep.deptId}</td>
                                <td>{dep.deptName}</td>
                                <td>
                                    <ButtonToolbar>
                                        <Button
                                            className="mr-2 "
                                            variant="info"
                                            onClick={() =>
                                                this.setState({
                                                    editModalShow: true,
                                                    depid: dep.deptId,
                                                    depname: dep.deptName,
                                                })
                                            }
                                        >
                                            Edit
                                        </Button>

                                    </ButtonToolbar>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </Table>
                <EditDepModal
                    show={this.state.editModalShow}
                    onHide={editModalClose}
                    depid={depid}
                    depname={depname}
                />
            </div>


            /*
                 <Table className = "mt - 4" striped bordered hover size = "sm">
                      <thead>
                          <th>Department ID</th>
                          <th>Department Name</th>
                      </thead>
                      <tbody>
                          {
                              deps.map(dep => 
                                  <tr key = {dep.deptId}>
                                      <td>{dep.deptId}</td>
                                      <td>{dep.deptName}</td>    
                                  </tr>   
                              )
                          }
                      </tbody>
                 </Table>
                 */
        );
    }
}
export default DepartmentComponent;