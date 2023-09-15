package mainpackage.PastTask.HttpVisionScope;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

@Service
@RequestScope
public class LoginService {
    private final LoggedUserManagmentService managmentService;
    private final LoginCountService countService;
    LoginService(LoggedUserManagmentService loginService,LoginCountService countService){
        managmentService = loginService;
        this.countService = countService;
    }

    private String password;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(){
        countService.increment();
        boolean loginresult = false;
        if((password.equals("123") && username.equals("natalya")) || (password.equals("123") && username.equals("pedro"))){
            loginresult = true;
            managmentService.setUser(username);
        }

        return loginresult;

    }
}
