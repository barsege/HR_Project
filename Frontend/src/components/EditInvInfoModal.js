import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Form } from "react-bootstrap";
import Grid from '@mui/material/Grid';

export class EditInvInfoModal extends Component {
    constructor(props) {
        super(props);
        this.state = { snackbaropen: false, snackbarmsg: '' };
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    handleSubmit(event) {

        event.preventDefault();

        fetch('http://localhost:8080/inventoryInfo/update/' + this.props.invid, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                inventoryId: event.target.inventoryId.value,
                brand: event.target.brand.value,
                model: event.target.model.value,
                inventoryInDate: event.target.inventoryInDate.value,
                serialNo: event.target.serialNo.value,
                statusId: event.target.statusId.value,
                inventoryType: event.target.inventoryType.value

            })
        })/*
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
*/
    }

    render() {
        return (

            <div className="container">

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
                            <Col sm={12}>
                                <Form onSubmit={this.handleSubmit}>

                                <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                    <Form.Group controlId="inventoryId">
                                        <Form.Label>Inventory Id</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="inventoryId"
                                            required
                                            disabled
                                            defaultValue={this.props.invid}
                                            placeholder="inventoryId"
                                        />
                                    </Form.Group>

                                    </Grid>
                                    
                                    <Grid item xs={6}>
                                    <Form.Group controlId="brand">
                                        <Form.Label>Brand</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="brand"
                                            required
                                            defaultValue={this.props.brnd}
                                            placeholder="brand"
                                        />
                                    </Form.Group>

                                    </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>

                                    <Form.Group controlId="model">
                                        <Form.Label>Model</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="model"
                                            required
                                            defaultValue={this.props.mdl}
                                            placeholder="model"
                                        />
                                    </Form.Group>

                                    </Grid>
                                    <Grid item xs={6}>
                                    <Form.Group controlId="inventoryInDate">
                                        <Form.Label>Inventory In Date</Form.Label>
                                        <Form.Control
                                            type="Date"
                                            name="inventoryInDate"
                                            required
                                            defaultValue={this.props.iid}
                                            placeholder="inventoryInDate"
                                        />
                                    </Form.Group>

                                    </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                    <Form.Group controlId="serialNo">
                                        <Form.Label>Serial No</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="serialNo"
                                            required
                                            defaultValue={this.props.sn}
                                            placeholder="serialNo"
                                        />
                                    </Form.Group>

                                    </Grid>
                                    <Grid item xs={6}>
                                    <Form.Group controlId="statusId">
                                        <Form.Label>Status Id</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="statusId"
                                            required
                                            defaultValue={this.props.statid}
                                            placeholder="statusId"
                                        />
                                    </Form.Group>
                                    </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                    <Form.Group controlId="inventoryType">
                                        <Form.Label>Inventory Type</Form.Label>
                                        <Form.Control
                                            type="text"
                                            name="inventoryType"
                                            required
                                            defaultValue={this.props.invtype}
                                            placeholder="inventoryType"
                                        />
                                    </Form.Group>

                                    </Grid>
                                    </Grid>

                                    <Form.Group>
                                        <Button variant="primary" type="submit">
                                            Update Inventory
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