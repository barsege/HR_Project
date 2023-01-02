import React, { Component, useState } from "react";
import { Modal, Button, Row, Col, Form } from "react-bootstrap";
import Grid from '@mui/material/Grid';


export class AddInvModal extends Component {
    constructor(props) {
        super(props);
        this.state = { snackbaropen: false, snackbarmsg: '' };
        this.handleSubmit = this.handleSubmit.bind(this);
    }


    componentDidMount() {
        fetch('http://localhost:8080/inventoryInfo/search?query')
            .then(response => response.json())
            .then(data => {
                this.setState({ inventories: data });
            })
    }

    handleSubmit(event) {

        event.preventDefault();

        fetch('http://localhost:8080/inventoryInfo/addInventory', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                inventoryId: null,
                brand: event.target.brand.value,
                model: event.target.model.value,
                inventoryInDate: event.target.inventoryInDate.value,
                serialNo: event.target.serialNo.value,
                statusId: event.target.statusId.value,
                inventoryType: event.target.inventoryType.value

            })
        })
        /*
            .then(res => res.json())
            .then((result) => {
                //alert(result);
                this.setState({ snackbaropen: true, snackbarmsg: 'Added department' });
            },
                (error) => {
                    //alert('Failed')
                    this.setState({ snackbaropen: true, snackbarmsg: 'failed' });
                }
            )*/
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
                            Add Inventory
                        </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>

                        <Row>
                            <Col sm={12}>
                                <Form onSubmit={this.handleSubmit}>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="Brand">
                                                <Form.Label>Brand</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="brand"
                                                    required
                                                    placeholder="Brand"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="Model">
                                                <Form.Label>Model</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="model"
                                                    required
                                                    placeholder="model"
                                                />
                                            </Form.Group>

                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="InventoryInDate">
                                                <Form.Label>Inventory In Date</Form.Label>
                                                <Form.Control
                                                    type="Date"
                                                    name="inventoryInDate"
                                                    required
                                                    placeholder="inventoryInDate"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="SerialNo">
                                                <Form.Label>Serial No</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="serialNo"
                                                    required
                                                    placeholder="serialNo"
                                                />
                                            </Form.Group>

                                        </Grid>
                                    </Grid>

                                    <Grid container spacing={2}>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="statusId">
                                                <Form.Label>Status Id</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="statusId"
                                                    required
                                                    placeholder="statusId"
                                                />
                                            </Form.Group>

                                        </Grid>
                                        <Grid item xs={6}>
                                            <Form.Group controlId="inventoryType">
                                                <Form.Label>Inventory Type</Form.Label>
                                                <Form.Control
                                                    type="text"
                                                    name="inventoryType"
                                                    required
                                                    placeholder="inventoryType"
                                                />
                                            </Form.Group>

                                        </Grid>
                                    </Grid>
                                    <Form.Group>
                                        <Button variant="primary" type="submit">
                                            Add Inventory
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