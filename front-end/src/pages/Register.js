import { useHistory } from "react-router-dom";
import RegisterForm from "../components/RegisterForm";

function RegisterPage(){   

    const history = useHistory(); 

    function registerUserHandler(user) {
        fetch('https://reqres.in/api/register.json',{
            method: 'POST',
            bodt :JSON.stringify(user),
            headers: { 'Content-Type': 'application/json'}

        }).then(() => history.replace('/login'));

    }    
    return(
        <div>
            <RegisterForm registerUser ={registerUserHandler}/>
        </div>
    );
}
export default RegisterPage;