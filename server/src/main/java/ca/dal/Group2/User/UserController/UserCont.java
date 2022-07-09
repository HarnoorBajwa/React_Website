package ca.dal.Group2.User.UserController;

import ca.dal.Group2.User.Entity.UserEntity;
import ca.dal.Group2.User.Service.UserService;
import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;

import java.util.List;

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
    public UserEntity signupUser(@RequestBody UserEntity model ){
        return userService.signupUser(model);
    }

    //login is getting
    //forgot is matching emails and returning the password

    //email and password return user
    //they both have to match
    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity model){
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

    @PostMapping("/addWorkspace/{workspaceId}")
    public boolean addWorkspacetoUser(@PathVariable Integer workspaceId, @RequestParam Integer userId){
        userService.addWorkspacetoUser(userId, workspaceId);
        return true;
    }

    @GetMapping("/getBoards")
    public List<WorkSpaceEntity> getBoards(@RequestParam Integer userId){
        return userService.getBoards(userId);
    }
}
