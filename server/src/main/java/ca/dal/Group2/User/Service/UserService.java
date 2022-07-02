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
        if(input.equals(alreadyThere.getEmailId())) {
            return alreadyThere.getPassword();
        }
        else {
            String error = "Not Found";
            return error;
        }
    }

}
