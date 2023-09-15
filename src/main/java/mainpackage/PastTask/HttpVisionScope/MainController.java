package mainpackage.PastTask.HttpVisionScope;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    private final LoggedUserManagmentService managmentService;
    private final LoginCountService countService;
    MainController(LoggedUserManagmentService loginService,LoginCountService countService){
        managmentService = loginService;
        this.countService = countService;
    }

    @GetMapping("/main")
    public String actionLogged(
            @RequestParam(required = false) String Logout,
            Model model){
        if(Logout != null){
            managmentService.setUser(null);
        }
        String user = managmentService.getUser();
        int count = countService.getDigit();
        if(user != null) {
            model.addAttribute("username",user);
            model.addAttribute("loginCount",count);
            return "main.html";
        }
        else
            return "redirect:/";
    }
}
