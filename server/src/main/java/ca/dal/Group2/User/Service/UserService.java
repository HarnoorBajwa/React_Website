package ca.dal.Group2.User.Service;

import ca.dal.Group2.User.Entity.Model;
import ca.dal.Group2.User.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@Service
@Repository
public class UserService {

    @Autowired
    UserRepo userRepo;
    public Model signupUser(Model input){
        //set up name
        //set up password
        //set up security question + answer
        return userRepo.save(input);
    }

    public Model login(Model input){
        Model alreadyThere;
        alreadyThere = userRepo.findByEmailId(input.getEmailId());
        //return all the user info
        if(input.getPassword().equals(alreadyThere.getPassword())){
            return alreadyThere;
        }
        return null;
    }
    //forgot password
    public String gimmePassword(String input){
        System.out.println(input);
        Model alreadyThere = userRepo.findByEmailId(input);


        //have email, then returning the password
        //it should be if the security ans match then return password
        if(input.equals(alreadyThere.getEmailId())) {
            System.out.println(alreadyThere.getSecurity());
            //get the answer
            //if ans.equals(alreadyThere.getAns()){
            //
            return alreadyThere.getPassword();
        }
        else {
            String error = "Not Found";
            return error;
        }
    }

    //takes email returns question
    public String getQuestion(String email){
        Model alreadyThere = userRepo.findByEmailId(email);
        if(email.equals(alreadyThere.getEmailId())){
            return alreadyThere.getSecurity();
        }
        else{
            String error = "You're not in the system";
            return error;
        }
    }
    public String checkSecurityAns(String email, String answer){
        Model alreadyThere = userRepo.findByEmailId(email);

        if(email.equals(alreadyThere.getEmailId())&&answer.equals(alreadyThere.getAns())){
            return alreadyThere.getPassword();
        }
        else{
            String error = "That's the wrong answer";
            return error;

        }
    }
    //take email and anser returns password
    //match anser + email





}
