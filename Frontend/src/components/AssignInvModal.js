import React from "react";
import { Component } from 'react';
import { Modal, Button, Row, Col, Form } from "react-bootstrap";
import Grid from '@mui/material/Grid';



export class AssignInvModal extends Component {
    constructor(props) {
        super(props);
        this.state = { invs: [], snackbaropen: false, snackbarmsg: '' };
        this.handleSubmit = this.handleSubmit.bind(this);

    }

    componentDidMount() {
        fetch('http://localhost:8080/employeeInventoryInfo/unassignedInv?query')
            .then(response => response.json())
            .then(data => {
                this.setState({ inv: data });
            })
    }
 
    handleSubmit(event) {

        event.preventDefault();

        fetch(`http://localhost:8080/employeeInventoryInfo/assign/${this.props.employeeId}/${this.props.inventoryid}` + this.props.employeeId, +this.props.inventoryid, {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },

        })
    }


    render() {
        return (
            console.log(this.props.inventoryid)
            // <div className="container">
            //     <Modal
            //         {...this.props}
            //         size="lg"
            //         aria-labelledby="contained-modal-title-vcenter"
            //         centered
            //     >
            //         <Modal.Header closeButton>
            //             <Modal.Title id="contained-modal-title-vcenter">
            //                 Edit Employee
            //             </Modal.Title>
            //         </Modal.Header>
            //         <Row>
            //             <Col sm={12}>
            //                 <Form onSubmit={this.handleSubmit}>

            //                     <Grid container spacing={2}>
            //                         <Grid item xs={6}>
            //                             <Form.Group controlId="EmployeeId">
            //                                 <Form.Label>Employee ID</Form.Label>
            //                                 <Form.Control
            //                                     type="text"
            //                                     name="employeeId"
            //                                     disabled
            //                                     defaultValue={this.props.inventoryid}
            //                                     placeholder="EmployeeId"
            //                                 />
            //                             </Form.Group>
            //                         </Grid>
            //                     </Grid>
            //                 </Form>
            //             </Col>
            //         </Row>
            //     </Modal>
            // </div>
        )
    }

}