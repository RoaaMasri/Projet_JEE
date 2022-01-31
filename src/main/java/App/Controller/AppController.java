/**

 * AppController class defines all the RequestMapping to redirect the app to the index or homepage

 * @author Roaa Masri

 */

package App.Controller;

import App.Model.Evenement;
import App.Model.Participant;
import App.Service.EventService;
import App.Service.ParticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class AppController {


    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "index page" when the web requests is empty
     * @param model
     */
    @RequestMapping(" ")
    public String homePage(Model model) {
        return "index";
    }

    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "index page" when the web requests is "/"
     * @param model
     */
    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }


    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "Home page" when the web requests is "/homePage"
     * @param model
     */
    @RequestMapping("/homePage")
    public String appHomePage(Model model) {
        return "home";
    }



}
