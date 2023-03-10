import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Form } from "react-bootstrap";

import { Snackbar } from "@mui/material";
import { IconButton } from "@mui/material";

export class EditDepModal extends Component {
    constructor(props) {
        super(props);
        this.state = { snackbaropen: false, snackbarmsg: '' };
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    snackbarClose = (event) => {
        this.setState({ snackbaropen: false });
    };

    handleSubmit(event) {

        event.preventDefault();

        fetch('http://localhost:8080/departments/update/' + this.props.depid, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                deptId: event.target.deptId.value,
                deptName: event.target.deptName.value

            })
        })
            .then(res => res.json())
            .then((result) => {
                //alert(result);
                this.setState({ snackbaropen: true, snackbarmsg: 'Updated!' });
            },
                (error) => {
                    //alert('Failed')
                    this.setState({ snackbaropen: true, snackbarmsg: 'failed' });
                }
            )

    }

    render() {
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
                            Edit Department
                        </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>

                        <Row>
                            <Col sm={6}>
                                <Form onSubmit={this.handleSubmit}>

                                    <Form.Group controlId="DepartmentId">
                                        <Form.Label>Departmant Id</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="deptId"
                                            required
                                            disabled
                                            defaultValue={this.props.depid}
                                            placeholder="deptId"
                                        />
                                    </Form.Group>
                                    <Form.Group controlId="DepartmentName">
                                        <Form.Label>Departmant Name</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="deptName"
                                            required
                                            defaultValue={this.props.depname}
                                            placeholder="deptName"
                                        />
                                    </Form.Group>

                                    <Form.Group>
                                        <Button variant="primary" type="submit">
                                            Update Department
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
        )
    }

}