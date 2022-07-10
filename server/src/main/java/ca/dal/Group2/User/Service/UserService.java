package ca.dal.Group2.User.Service;

import ca.dal.Group2.User.Entity.UserEntity;
import ca.dal.Group2.User.Repository.UserRepo;
import ca.dal.Group2.Workspace.Entity.WorkSpaceEntity;
import ca.dal.Group2.Workspace.Repository.WorkspaceRepo;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;



@Service
@Repository
public class UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired WorkspaceRepo workspaceRepo;

    public UserEntity signupUser(UserEntity input){
        //set up name
        //set up password
        //set up security question + answer
        return userRepo.save(input);
    }

    public UserEntity login(UserEntity input){
        UserEntity alreadyThere;
        alreadyThere = userRepo.findByEmailId(input.getEmailId());
        //return all the user info
        if(alreadyThere != null && input.getPassword().equals(alreadyThere.getPassword())){
            return alreadyThere;
        }
        return null;
    }
    //forgot password
    public String gimmePassword(String input){
        System.out.println(input);
        UserEntity alreadyThere = userRepo.findByEmailId(input);


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
        UserEntity alreadyThere = userRepo.findByEmailId(email);
        if(email.equals(alreadyThere.getEmailId())){
            return alreadyThere.getSecurity();
        }
        else{
            String error = "You're not in the system";
            return error;
        }
    }
    public String checkSecurityAns(String email, String answer){
        UserEntity alreadyThere = userRepo.findByEmailId(email);

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


    public boolean addWorkspacetoUser(int userId, int workspaceId){
        Optional<UserEntity> user = userRepo.findById((long)userId);
        Optional<WorkSpaceEntity> workspace = workspaceRepo.findById((long)workspaceId);

        if(user.isPresent() && workspace.isPresent()){
            List<WorkSpaceEntity> workspaces = user.get().getWorkspaces();
            if(workspace.get() == null){
                workspaces = new ArrayList<WorkSpaceEntity>();
            }
            workspaces.add(workspace.get());
            user.get().setWorkspaces(workspaces);
            userRepo.save(user.get());
        }
        return false;
    }

    public List<WorkSpaceEntity> getWorkspaces(int userId){
        Optional<UserEntity> user = userRepo.findById((long)userId);
        if(user.isPresent()){
            return user.get().getWorkspaces();
        }
        // List<WorkSpaceEntity> workspaces
        return null;
    }

}
