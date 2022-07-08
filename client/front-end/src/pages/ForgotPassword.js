import { useHistory } from "react-router-dom";
import ForgotPasswordForm from "../components/ForgotPasswordForm";

function ForgotPasswordPage(){
    const history = useHistory();
    function passwordHandler(user){
        fetch('https://dummy.restapiexample.com/api/v1/create/user.json')
        .then(() => {
            history.replace('/login')});
        }
    return(
        <div>
            <ForgotPasswordForm loginUser ={passwordHandler}/>
        </div>
         
    );
}

export default ForgotPasswordPage;