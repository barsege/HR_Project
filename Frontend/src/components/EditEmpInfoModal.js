import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Form } from "react-bootstrap";

import { Snackbar } from "@mui/material";
import { IconButton } from "@mui/material";
import Grid from '@mui/material/Grid';
import * as moment from 'moment';


export class EditEmpInfoModal extends Component {
    constructor(props) {
        super(props);
        this.state = { deps: [], jobs: [], grads: [], snackbaropen: false, snackbarmsg: '' };
        this.handleSubmit = this.handleSubmit.bind(this);


    }

    snackbarClose = (event) => {
        this.setState({ snackbaropen: false });
    };



    componentDidMount() {
        fetch('http://localhost:8080/employee_info/searchAll?query')
            .then(response => response.json())
            .then(data => {
                this.setState({ emps: data });
            })

        fetch('http://localhost:8080/departments/search?query')
            .then(response => response.json())
            .then(data => {
                this.setState({ deps: data });
            });

        fetch('http://localhost:8080/jobs/search?query')
            .then(response => response.json())
            .then(data => {
                this.setState({ jobs: data });
            });

        fetch('http://localhost:8080/graduation/search?query')
            .then(response => response.json())
            .then(data => {
                this.setState({ grads: data });
            });


    }

    handleSubmit(event) {

        event.preventDefault();

        fetch('http://localhost:8080/employee_info/update/' + this.props.empid, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                employeeId: event.target.employeeId.value,
                employeeName: event.target.employeeName.value,
                employeeSurname: event.target.employeeSurname.value,
                gender: event.target.employeeGender.value,
                dateOfBirth: event.target.dateOfBirth.value,
                marriedOrNot: event.target.empMarried.value,
                tckn: event.target.tckn.value,
                gradstatusId: event.target.gradstatusId.value,
                gradDate: event.target.gradDate.value,
                deptId: event.target.deptId.value,
                jobId: event.target.jobId.value,
                workingOrNot: event.target.isEmpWorking.value
            })
        })
            .then(res => res.json())
            .then((result) => {
                //alert(result);
                this.props.update(result);
                this.props.onHide()
                this.setState({ snackbaropen: true, snackbarmsg: 'Updated!' });
            },
                (error) => {
                    //alert('Failed')
                    this.setState({ snackbaropen: true, snackbarmsg: 'Failed' });
                }
            )

    }

    render() {
        console.log(this.props.empid)   

        return (

            <div className="container">

                <Snackbar
                    anchorOrigin={{ vertical: 'bottom', horizontal: 'center' }}
                    open={this.state.snackbaropen}
                    autoHideDuration={3000}
                    onClose={this.snackbarClose}

                    message={<span id="message-id">{this.state.snackbarmsg}</span>}
                    action={[
                        <IconButton
                            key="close"
                            arial-label="Close"
                            color="inherit"
                            onClick={this.snackbarClose}
                        >
                            x
                        </IconButton>
                    ]}
                />
                <Modal
                    {...this.props}
                    size="lg"
                    aria-labelledby="contained-modal-title-vcenter"
                    centered
                >
                    <Modal.Header closeButton>
                        <Modal.Title id="contained-modal-title-vcenter">
                            Edit Employee
                        </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>

                        <Row>
                            <Col sm={12}>
                                <Form onSubmit={this.handleSubmit}>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="EmployeeId">
                                                <Form.Label>Employee ID</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="employeeId"
                                                    disabled
                                                    defaultValue={this.props.empid}
                                                    placeholder="EmployeeId"
                                                />
                                            </Form.Group>
                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="EmployeeName">
                                                <Form.Label>Employee Name</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="employeeName"
                                                    required
                                                    defaultValue={this.props.empname}
                                                    placeholder="EmployeeName"
                                                />
                                            </Form.Group>
                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="EmployeeSurname">
                                                <Form.Label>Employee Surname</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="employeeSurname"
                                                    required
                                                    defaultValue={this.props.empsurname}
                                                    placeholder="employeeSurname"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="Gender">
                                                <Form.Label>Gender</Form.Label>
                                                <Form.Select name="employeeGender"
                                                    required
                                                    defaultValue={this.props.empgender}>
                                                    <option value="Male"> Male</option>
                                                    <option value="Female"> Female</option>

                                                </Form.Select >
                                            </Form.Group>

                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="DateOfBirth">
                                                <Form.Label>Date Of Birth</Form.Label>
                                                <Form.Control
                                                    type="Date"
                                                    name="dateOfBirth"
                                                    required
                                                    defaultValue={moment(this.props.dOB).format('YYYY-MM-DD')}

                                                    placeholder="dateOfBirth"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="marriedOrNot">
                                                <Form.Label>Married Or Not</Form.Label>
                                                <Form.Select name="empMarried"
                                                    required
                                                    defaultValue={this.props.mON}>
                                                    <option value="Yes"> Yes</option>
                                                    <option value="No"> No</option>
                                                </Form.Select >
                                            </Form.Group>

                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="tckn">
                                                <Form.Label>TCKN</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="tckn"
                                                    required
                                                    defaultValue={this.props.empTckn}
                                                    placeholder="tckn"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="gradstatusId">
                                                <Form.Label>Graduation Status Id</Form.Label>
                                                <Form.Control as="select">
                                                    defaultValue = {this.props.empGrad}
                                                    {this.state.grads.map(grad =>
                                                        <option value={grad.graduationId} key={grad.graduationId}>{grad.graduationName}</option>
                                                    )}

                                                </Form.Control>
                                            </Form.Group>

                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="gradDate">
                                                <Form.Label>Graduation Date</Form.Label>
                                                <Form.Control
                                                    type="Date"
                                                    name="gradDate"
                                                    required
                                                    defaultValue={moment(this.props.empGradDate).format('YYYY-MM-DD')}
                                                    placeholder="gradDate"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="deptId">
                                                <Form.Label>Dept Id</Form.Label>
                                                <Form.Control as="select"
                                                    defaultValue={this.props.depid}>
                                                    {this.state.deps.map(dep =>
                                                        <option value={dep.deptId} key={dep.deptId}>{dep.deptName}</option>
                                                    )}

                                                </Form.Control>
                                            </Form.Group>

                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="jobId">
                                                <Form.Label>Job Id</Form.Label>
                                                <Form.Control as="select">
                                                    defaultValue = {this.props.jobid}
                                                    {this.state.jobs.map(job =>
                                                        <option value={job.jobId} key={job.jobId}>{job.jobName}</option>
                                                    )}

                                                </Form.Control>
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="workingOrNot">
                                                <Form.Label>Working Or Not</Form.Label>
                                                <Form.Select name="isEmpWorking"
                                                    required
                                                    defaultValue={this.props.wON}>
                                                    <option value="Yes"> Yes</option>
                                                    <option value="No"> No</option>
                                                </Form.Select >
                                            </Form.Group>

                                        </Grid>
                                    </Grid>
                                    <Form.Group>
                                        <Button variant="primary" type="submit">
                                            Update Employee
                                        </Button>
                                    </Form.Group>
                                </Form>
                            </Col>
                        </Row>

                    </Modal.Body>
                    <Modal.Footer>
                        <Button variant="danger" onClick={this.props.onHide}>Close</Button>
                    </Modal.Footer>
                </Modal>

            </div>
        );
    }
}
