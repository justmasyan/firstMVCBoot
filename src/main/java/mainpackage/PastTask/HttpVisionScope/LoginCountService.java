package mainpackage.PastTask.HttpVisionScope;

import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.ApplicationScope;

@Controller
@ApplicationScope
public class LoginCountService {

    private int digit;

    public void increment(){
        digit++;
    }

    public int getDigit() {
        return digit;
    }


}
