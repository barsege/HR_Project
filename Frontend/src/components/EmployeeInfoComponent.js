import { Table } from "react-bootstrap";

import React from "react";
import EmployeeInfoService from "../services/EmployeeInfoService";

import { Button, ButtonToolbar } from "react-bootstrap";
import { AddEmpInfoModal } from "./AddEmpInfoModal";
import { EditEmpInfoModal } from "./EditEmpInfoModal";
import { DetailEmpInfoModal } from "./DetailEmpInfoModal";

import EmployeeInvInfo from "./EmployeeInvInfo";

class EmployeeInfoComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: null,
      addModalShow: false,
      editModalShow: false,
      detailModalShow: false,
    };
  }

  componentDidMount() {
    this.refreshList();
  }

  refreshList() {
    if (!this.state.employees) {
      fetch("http://localhost:8080/employee_info/searchAll?query")
        .then((response) => response.json())
        .then((data) => {
          this.setState({ employees: data });
        });
    }
  }

  componentDidUpdate() {
    this.refreshList();
  }
  render() {

    const {
      employees,
      empid,
      empname,
      empsurname,
      empgender,
      dOB,
      mON,
      empTckn,
      empGrad,
      empGradDate,
      depid,
      jobid,
      wON,
    } = this.state;

    let addModalClose = () => this.setState({ addModalShow: false });
    let editModalClose = () => this.setState({ editModalShow: false });
    let detailModalClose = () => this.setState({ detailModalShow: false });

    const update = (employe) => {
      this.setState({
        employees: this.state.employees.map((e) => e.employeeId === employe.employeeId ? employe : e)
      })
    }
    const insert = (employe) => {
      const tempData = this.state.employees;
      tempData.push(employe);
      this.setState({
        employees: tempData
      })
    }

    console.log("asdasd");
    return (
      <div style={{ margin: "40px" }}>
        <h1 className="text-center">Employee List</h1>

        <ButtonToolbar>
          <Button
            variant="primary"
            onClick={() => this.setState({ addModalShow: true })}
          >
            Add Employee
          </Button>

          <AddEmpInfoModal
            insert={insert}
            show={this.state.addModalShow}
            onHide={addModalClose}
          />
        </ButtonToolbar>
        <div>
          <Table className="mt-4" striped bordered hover size="sm">
            <thead>
              <tr>
                <th>Employee Id</th>
                <th>Employee Name</th>
                <th>Employee Surname</th>
                <th>Gender</th>
                {/*<th>Date Of Birth</th>*/}
                {/*<th>Married Or Not</th>*/}
                <th>TCKN</th>
                {/* <th>Graduatiton Status Id</th> */}
                {/*<th>Graduation Date</th>*/}
                {/* <th>Dept Id</th>
                                <th>Job Id</th> */}
                {/*<th>Working Or Not</th>*/}
                <th>Options</th>
              </tr>
            </thead>
            <tbody>
              {employees?.map((employee) => (
                <tr key={employee.employeeId}>
                  <td>{employee.employeeId}</td>
                  <td>{employee.employeeName}</td>
                  <td>{employee.employeeSurname}</td>
                  <td>{employee.gender}</td>
                  {/*<td>{employee.dateOfBirth}</td>*/}
                  {/*<td>{employee.marriedOrNot}</td>*/}
                  <td>{employee.tckn}</td>
                  {/* <td>{employee.gradstatusId}</td> */}
                  {/*<td>{employee.gradDate}</td>*/}
                  {/* <td>{employee.deptId}</td>
                                            <td>{employee.jobId}</td> */}
                  {/*<td>{employee.workingOrNot}</td>*/}
                  <td>
                    <ButtonToolbar>
                      <Button
                        className="mr-2 "
                        variant="info"
                        onClick={() =>
                          this.setState({
                            editModalShow: true,
                            empid: employee.employeeId,
                            empname: employee.employeeName,
                            empsurname: employee.employeeSurname,
                            empgender: employee.gender,
                            dOB: employee.dateOfBirth,
                            mON: employee.marriedOrNot,
                            empTckn: employee.tckn,
                            empGrad: employee.gradstatusId,
                            empGradDate: employee.gradDate,
                            depid: employee.deptId,
                            jobid: employee.jobId,
                            wON: employee.workingOrNot,
                          })
                        }
                      >
                        Edit
                      </Button>


                      {/* <Button>
                          <Link to = {`employee_info/searchId/${this.props.empid}`  } className="mr-2" variant="contained"></Link>
                          Link
                        </Button> */}

                      <Button
                        className="mr-2"
                        variant="contained"
                        href={`employeeInventoryInfo/searchId/${employee.employeeId}`}

                      // <Link to = "" ></Link>
                      // onClick={() => 
                      //   this.setState({
                      // empid : employee.employeeId,
                      // empname: employee.employeeName,
                      // empsurname: employee.employeeSurname,
                      // })
                      // }
                      >
                        Link
                      </Button>

                      <Button
                        className="mr-2 "
                        variant="info"
                        onClick={() =>
                          this.setState({
                            detailModalShow: true,
                            empid: employee.employeeId,
                            empname: employee.employeeName,
                            empsurname: employee.employeeSurname,
                            empgender: employee.gender,
                            dOB: employee.dateOfBirth,
                            mON: employee.marriedOrNot,
                            empTckn: employee.tckn,
                            empGrad: employee.gradstatusId,
                            empGradDate: employee.gradDate,
                            depid: employee.deptId,
                            jobid: employee.jobId,
                            wON: employee.workingOrNot,
                          })
                        }
                      >
                        Detail
                      </Button>


                    </ButtonToolbar>
                  </td>

                </tr>
              ))}
            </tbody>
          </Table>

          <EditEmpInfoModal
            update={update}
            show={this.state.editModalShow}
            onHide={editModalClose}
            empid={empid}
            empname={empname}
            empsurname={empsurname}
            empgender={empgender}
            dOB={dOB}
            mON={mON}
            empTckn={empTckn}
            empGrad={empGrad}
            empGradDate={empGradDate}
            depid={depid}
            jobid={jobid}
            wON={wON}
          />

          <DetailEmpInfoModal
            show={this.state.detailModalShow}
            onHide={detailModalClose}
            empid={empid}
            empname={empname}
            empsurname={empsurname}
            empgender={empgender}
            dOB={dOB}
            mON={mON}
            empTckn={empTckn}
            empGrad={empGrad}
            empGradDate={empGradDate}
            depid={depid}
            jobid={jobid}
            wON={wON}
          />


        </div>

      </div>
    );
  }
}

export default EmployeeInfoComponent;