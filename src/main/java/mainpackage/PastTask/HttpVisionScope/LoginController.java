package mainpackage.PastTask.HttpVisionScope;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private static LoginService loginService;

    LoginController(LoginService loginService){
        this.loginService = loginService;
    }

    @GetMapping("/")
    public String loginGET(){
        return "home.html";
    }

    @PostMapping("/")
    public String loginPOST(
            @RequestParam String username,
            @RequestParam String password,
            Model model){
        System.out.println(loginService.getClass().getName());
        loginService.setPassword(password);
        loginService.setUsername(username);

        boolean logIn = loginService.login();

        if(logIn)
            return "redirect:/main";
        else {
            model.addAttribute("message", "FAILED");
            return "home.html";
        }
    }
}
