package ca.dal.Group2.Tests.Contoller;

import ca.dal.Group2.User.UserController.UserCont;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class);
@Import(UserCont.class);

public class UserControllerTests {
    @MockBean
    @Autowired


}
