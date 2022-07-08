// import{Link} from "react-router-dom";
import {Navbar,Nav,Container} from 'react-bootstrap';


 function Navigation(){
    return(
        <Navbar bg="dark" expand="lg">
            <Container>
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="me-auto">
                        <Nav.Link href="/home">Home</Nav.Link>
                        <Nav.Link href="/login">Log In</Nav.Link>
                        <Nav.Link href="/register">Sign Up</Nav.Link>
                        <Nav.Link href="/boards">Boards</Nav.Link>
                        <Nav.Link href="/create-board"> Create Board</Nav.Link>

                        
                    </Nav>
                </Navbar.Collapse>
            </Container>
        </Navbar>
    )
    
 }

 export default Navigation; 