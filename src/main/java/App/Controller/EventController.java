/**

 * EventController class defines all the RequestMapping to redirect the app to the Event's pages

 * @author Roaa Masri

 */

package App.Controller;

import App.Model.Evenement;
import App.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class EventController {

    /**
     * Creating EventService variable with the @autowired annotation
     * this variable redirects the information from the Controller to the Repository(DAO)
     */
    @Autowired
    private EventService service;


    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "event_page" when the web requests is "/event"
     * @param model
     */
    @RequestMapping("/event")
    public String viewEventHomePage(Model model) {
        List<Evenement> listEvents = service.listAll();
        model.addAttribute("listEvents", listEvents);
        return "event_page";
    }

    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "new_event" when the web requests is "/new"
     * It goes to the new_event page to add an event
     * @param model
     */
    @RequestMapping("/new")
    public String showNewEvenementPage(Model model) {
        Evenement evenement = new Evenement();
        model.addAttribute("evenement", evenement);

        return "new_event";
    }

    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "/event" when the web requests is "/save"
     * It goes back to the event page after saving or editing an event
     * @param evenement
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("evenement") Evenement evenement) {
        service.save(evenement);

        return "redirect:/event";
    }

    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "edit_event" when the web requests is "/edit/{id}"
     * It goes to the edit_event page to edit the event information
     * @param id
     */
    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEventPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_event");
        Evenement evenement = service.get(id);
        mav.addObject("evenement", evenement);

        return mav;
    }

    /**
     * This function is using RequestMapping annotation
     * It redirects the web page to "/event" when the web requests is /delete/{id}"
     * It goes back to the event page after deleting an event
     * @param id
     */
    @RequestMapping("/delete/{id}")
    public String deleteEvent(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/event";
    }

}
