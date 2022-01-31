/**

 * ParticipantController class defines all the RequestMapping to redirect the app to the Participant's pages

 * @author Roaa Masri & Adrienne Zebaze

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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class ParticipantController {

    /**
     * Creating EventService and ParticService variables with the @autowired annotation
     * these variables redirect the information from the Controller to the Repository(DAO)
     */
    @Autowired
    private EventService service;

    @Autowired
    private ParticService pservice;

    /**
     * This function is using @RequestMapping annotation
     * It redirects the web page to "participant_page" when the web requests is "/participant"
     * @param model
     */
    @RequestMapping("/participant")
    public String viewParticipantHomePage(Model model) {
        List<Participant> listParticipants = pservice.listAll();
        model.addAttribute("listParticipants", listParticipants);

        return "participant_page";
    }

    /**
     * This function is using @RequestMapping annotation
     * It redirects the web page to "new_participant" when the web requests is "/new_participant"
     * It goes to the new_participant page to add a participant with the event he wants to participate at
     * @param model
     */
    @RequestMapping("/new_participant")
    public String showNewParticipantPage(Model model) {
        List<Evenement> listOfEvents = service.listAll();
        Participant participant = new Participant();
        model.addAttribute("participant", participant);
        model.addAttribute("listOfEvents", listOfEvents);
        return "new_participant";
    }

    /**
     * This function is using @RequestMapping annotation
     * It redirects the web page to "participant" when the web requests is "/save_participant"
     * It goes to the participant page after adding the new participant
     * @param participant
     * @return
     */
    @RequestMapping(value = "/save_participant", method = RequestMethod.POST)
    public String saveParticipant(@ModelAttribute("participant") Participant participant) {
        pservice.save(participant);
        return "redirect:/participant";
    }

    /**
     * This function is using @RequestMapping annotation
     * It redirects the web page to "participant" when the web requests is "/participant/delete/{id}"
     * It goes back to the participant page after deleting the participant
     * @param id
     * @return
     */
    @RequestMapping("/participant/delete/{id}")
    public String deletePartic(@PathVariable(name = "id") long id) {
        pservice.delete(id);
        return "redirect:/participant";
    }

/*
    @RequestMapping("/participant/edit/{id}")
    public ModelAndView showEditParticPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_participant");
        Participant participant = pservice.get(id);
        mav.addObject("participant", participant);

        return mav;
    }
*/

}
