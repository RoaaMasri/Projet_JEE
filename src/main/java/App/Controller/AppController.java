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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class AppController {

    @Autowired
    private EventService service;

    @Autowired
    private ParticService pservice;


    //Home Page
    @RequestMapping(" ")
    public String homePage(Model model) {
        return "index";
    }

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }


    //Event Controller
    @RequestMapping("/event")
    public String viewEventHomePage(Model model) {
        List<Evenement> listEvents = service.listAll();
        model.addAttribute("listEvents", listEvents);
        return "event_page";
    }

    @RequestMapping("/new")
    public String showNewEvenementPage(Model model) {
        Evenement evenement = new Evenement();
        model.addAttribute("evenement", evenement);

        return "new_event";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("evenement") Evenement evenement) {
        service.save(evenement);

        return "redirect:/event";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditEventPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("edit_event");
        Evenement evenement = service.get(id);
        mav.addObject("evenement", evenement);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteEvent(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/event";
    }


    //Participant Controller

    @RequestMapping("/participant")
    public String viewParticipantHomePage(Model model) {
        List<Participant> listParticipants = pservice.listAll();
        model.addAttribute("listParticipants", listParticipants);

        return "participant_page";
    }

    @RequestMapping("/new_participant")
    public String showNewParticipantPage(Model model) {
        List<Evenement> listOfEvents = service.listAll();
        Participant participant = new Participant();
        model.addAttribute("participant", participant);
        model.addAttribute("listOfEvents", listOfEvents);
        return "new_participant";
    }

    @RequestMapping(value = "/save_participant", method = RequestMethod.POST)
    public String saveParticipant(@ModelAttribute("participant") Participant participant) {
        pservice.save(participant);
        return "redirect:/participant";
    }

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
