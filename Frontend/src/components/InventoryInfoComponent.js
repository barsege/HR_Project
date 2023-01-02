import React, { Component } from "react";
import { Table } from "reactstrap";
import { Button, ButtonToolbar } from "react-bootstrap";
import InventoryInfoService from "../services/InventoryInfoService";
import { AddInvModal } from "./AddInvModal";
import { EditInvInfoModal } from "./EditInvInfoModal";
export class InventoryInfoComponent extends Component {
    constructor(props) {
        super(props);
        this.state = { invs: null, addModalShow: false, editModalShow: false };
    }
    componentDidMount() {
        InventoryInfoService.getInventoryInfo().then((response) => {
            this.setState({ inventories: response.data });
        });
    }
    refreshList() {
        if (!this.state.invs) {
            fetch("http://localhost:8080/inventoryInfo/search?query")
                .then((response) => response.json())
                .then((data) => {
                    this.setState({ invs: data });
                });
        }
    }
    componentDidUpdate() {
        this.refreshList();
    }
    render() {
        const { invs, invid, brnd, mdl, iid, sn, statid, invtype } = this.state;
        let addModalClose = () => this.setState({ addModalShow: false });
        let editModalClose = () => this.setState({ editModalShow: false });
        return (
            <div style={{ margin: "40px" }}>
                <h1 className="text-center">Inventory List</h1>
                <ButtonToolbar>
                    <Button
                        variant="primary"
                        onClick={() => this.setState({ addModalShow: true })}
                    >
                        Add Inventory
                    </Button>
                    <AddInvModal show={this.state.addModalShow} onHide={addModalClose} />
                </ButtonToolbar>
                <Table className="mt-4" striped bordered hover size="sm">
                    <thead>
                        <tr>
                            <th>Inventory Id</th>
                            <th>Brand</th>
                            <th>Model</th>
                            <th>Inventory in Date</th>
                            <th>Serial No</th>
                            <th>Status Id</th>
                            <th>Inventory Type</th>
                            <th>Options</th>
                        </tr>
                    </thead>
                    <tbody>
                        {invs?.map((inv) => (
                            <tr key={inv.inventoryId}>
                                <td>{inv.inventoryId}</td>
                                <td>{inv.brand}</td>
                                <td>{inv.model}</td>
                                <td>{inv.inventoryInDate}</td>
                                <td>{inv.serialNo}</td>
                                <td>{inv.statusId}</td>
                                <td>{inv.inventoryType}</td>
                                <td>
                                    <ButtonToolbar>
                                        <Button
                                            className="mr-2 "
                                            variant="info"
                                            onClick={() =>
                                                this.setState({
                                                    editModalShow: true,
                                                    invid: inv.inventoryId,
                                                    brnd: inv.brand,
                                                    mdl: inv.model,
                                                    iid: inv.inventoryInDate,
                                                    sn: inv.serialNo,
                                                    statid: inv.statusId,
                                                    invtype: inv.inventoryType,
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

                <EditInvInfoModal
                    show={this.state.editModalShow}
                    onHide={editModalClose}
                    invid={invid}
                    brnd={brnd}
                    mdl={mdl}
                    iid={iid}
                    sn={sn}
                    statid={statid}
                    invtype={invtype}
                />
            </div>
        );
    }
}
export default InventoryInfoComponent;