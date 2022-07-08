
package ca.dal.Group2.Tests.Contoller;

import ca.dal.Group2.User.Entity.Model;
import ca.dal.Group2.User.Repository.UserRepo;
import ca.dal.Group2.User.Service.UserService;
import ca.dal.Group2.User.UserController.UserCont;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ContextConfiguration(classes = {UserCont.class})
@ExtendWith(SpringExtension.class)
@WebMvcTest(UserCont.class)
@Import(UserCont.class)
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class UserControllerTests {
    @MockBean
    private UserService service;

    @Autowired
    private MockMvc mockMvc;

    private Model empty = new Model("Birch","Birch@trees.com","Ilovetrees!", "Latin name?","Betula papyrifera");
    @Test
    void signupUserTest() throws Exception{
        when(service.signupUser(empty)).thenReturn(empty);
        mockMvc.perform(post("/user/save").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Birch\", \"emailId\":\"Birch@trees.com\", \"password\":\"Ilovetrees!\", \"secruityQ\":\"Latin name?\", \"answer\": \"Betula papyrifera\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void loginTest() throws  Exception{
        when(service.login(empty)).thenReturn(empty);
        mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Birch\", \"emailId\":\"Birch@trees.com\", \"password\":\"Ilovetrees!\", \"secruityQ\":\"Latin name?\", \"answer\": \"Betula papyrifera\"}"))
                .andExpect(status().isOk());
    }


    @Test
    void oopsTest() throws Exception{
        when(service.gimmePassword(empty.getEmailId())).thenReturn(empty.getPassword());
        mockMvc.perform(post("/user/login").contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Birch\", \"emailId\":\"Birch@trees.com\", \"password\":\"Ilovetrees!\", \"secruityQ\":\"Latin name?\", \"answer\": \"Betula papyrifera\"}"))
                .andExpect(status().isOk());
    }

    @Test
    void questionTest() throws Exception{
        when(service.getQuestion(empty.getEmailId())).thenReturn(empty.getSecuirty());
        mockMvc.perform(post("/user/askQuestion").contentType(MediaType.APPLICATION_JSON)
                .content("{\"name\": \"Birch\", \"emailId\":\"Birch@trees.com\", \"password\":\"Ilovetrees!\", \"secruityQ\":\"Latin name?\", \"answer\": \"Betula papyrifera\"}"))
                .andExpect(status().isOk());
    }

}
