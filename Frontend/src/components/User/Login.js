// import React, { Component } from 'react';
// import { Row,
//     Col,
//     Card,
//     Form,
//     InputGroup,
//     FormControl,
//     Button,
//     Alert,} from 'react-bootstrap';
// import {} from "@fortawesome"
// import {FortAwesomeIcon} from "@fortawesome/react-fortawesome";
// import {faSignInAlt, faEnvolope, faLock} from "@fortawesome/free-solid-svg-icons";

// class Login extends Component {
//     render() {
//         return (
//             <div>
//                 <Row className = "justify-content-md-center">
//                     <Col xs = {5}>
//                         <Card>
//                             <Card.Header>
//                                 <FortAwesomeIcon icon = {faSignInAlt}/>
//                             </Card.Header>
//                             <Card.Body>
//                                 <Form.Row>
//                                     <Form.Group>
//                                         <InputGroup>
//                                             <InputGroup.Prepend>
//                                                 <InputGroup.Text><FortAwesomeIcon icon= {faEnvolope}/></InputGroup.Text>
//                                             </InputGroup.Prepend>
//                                             <FormControl required autoComplete = "off" type = "text" name = "name" value = {employeeName}
//                                             className={"bg-dark text-white"} placeholder= "Enter Name" />
//                                         </InputGroup>
//                                     </Form.Group>
//                                 </Form.Row>
//                                 <Form.Row>
//                                     <Form.Group>
//                                         <InputGroup>
//                                             <InputGroup.Prepend>
//                                                 <InputGroup.Text><FortAwesomeIcon icon= {faLock}/></InputGroup.Text>
//                                             </InputGroup.Prepend>
//                                             <FormControl required autoComplete = "off" type = "text" name = "password" value = {password}
//                                             className={"bg-dark text-white"} placeholder= "Enter Password" />
//                                         </InputGroup>
//                                     </Form.Group>
//                                 </Form.Row>
//                             </Card.Body>
//                         </Card>
//                     </Col>
//                 </Row>
//             </div>
//         );
//     }
// }

// export default Login;