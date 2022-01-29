package App.Controller;

import App.Model.Evenement;
import App.Service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppController {

    @Autowired
    private EventService service;


    @RequestMapping("/event")
    public String viewHomePage(Model model) {
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
        ModelAndView mav = new ModelAndView("edit_product");
        Evenement evenement = service.get(id);
        mav.addObject("evenement", evenement);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteEvent(@PathVariable(name = "id") long id) {
        service.delete(id);
        return "redirect:/event";
    }
}
