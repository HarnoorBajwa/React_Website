import { useHistory } from "react-router-dom";
import LoginForm from "../components/LoginForm";

function LoginPage(){
    const history = useHistory();
    function loginUserhandler(user){
        fetch('https://dummy.restapiexample.com/api/v1/create/user.json')
        .then(() => {
            history.replace('home')});
        }
    return(
        <div>
            <LoginForm loginUser ={loginUserhandler}/>
        </div>
         
    );
}

export default LoginPage;