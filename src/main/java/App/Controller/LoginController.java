/**

 * LoginController class defines all the RequestMapping to redirect the app to the connection's page

 * @author Adrienne Zebaze

 */
package App.Controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class LoginController {

    //for inscription : to display page
    @RequestMapping("/ConnexionPage")
    public String connexion(Model model) {
        return "connexion";
    }

    //to return on page home
    @RequestMapping(value = "/seConnecter", method = RequestMethod.POST)
    public String viewEventHome(@RequestParam(name="name", required=false) String name, Model model) {
        model.addAttribute("name", name);
        return "home";
    }
}
