package ca.dal.Group2.User.UserController;

import ca.dal.Group2.User.Entity.Model;
import ca.dal.Group2.User.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserCont {

    @Autowired
    UserService userService;

    @PostMapping("/save")
    //register
    public Model signupUser(@RequestBody Model model ){
        return userService.signupUser(model);
    }

    //login is getting
    //forgot is matching emails and returning the password

    //email and password return user
    //they both have to match
    @PostMapping("/login")
    public Model login(@RequestBody Model model){
        return userService.login(model);
        //check to see if the email and password match what's in the database
        //passing in a model that you check that the Email and the password match
    }
    //look up email then give password
    @PostMapping("/forgot")
    public String oops(@RequestBody String model){
        return userService.gimmePassword(model);
    }


    @PostMapping("/askQuestion")
    public String question(@RequestBody String model) {return userService.getQuestion(model);}

    @PostMapping("/checkAns")
    public String secAns(@RequestBody String email, String answer) {return userService.checkSecurityAns(email,answer);}
}
