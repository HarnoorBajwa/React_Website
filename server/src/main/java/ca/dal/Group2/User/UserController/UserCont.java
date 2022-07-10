package ca.dal.Group2.User.UserController;

import ca.dal.Group2.User.Entity.UserEntity;
import ca.dal.Group2.User.Service.UserService;
import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;

import java.io.Console;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserCont {

    @Autowired
    UserService userService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/save")
    //register
    public UserEntity signupUser(@RequestBody UserEntity model ){
        return userService.signupUser(model);
    }

    //login is getting
    //forgot is matching emails and returning the password

    //email and password return user
    //they both have to match
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/login")
    public UserEntity login(@RequestBody UserEntity model){
        System.out.println(userService.login(model));
        return userService.login(model);
        //check to see if the email and password match what's in the database
        //passing in a model that you check that the Email and the password match
    }
    //look up email then give password
    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/forgot")
    public String oops(@RequestBody String model){
        return userService.gimmePassword(model);
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/askQuestion")
    public String question(@RequestBody String model) {return userService.getQuestion(model);}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/checkAns")
    public String secAns(@RequestBody String email, String answer) {return userService.checkSecurityAns(email,answer);}

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/addWorkspace/{workspaceId}")
    public boolean addWorkspacetoUser(@PathVariable Integer workspaceId, @RequestParam Integer userId){
        userService.addWorkspacetoUser(userId, workspaceId);
        return true;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("/getWorkspaces/{userId}")
    public List<WorkSpaceEntity> getBoards(@PathVariable Integer userId){
        return userService.getWorkspaces(userId);
    }
}
