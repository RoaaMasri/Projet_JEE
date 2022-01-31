/**

 * EventService class it uses the EventRepository methods

 * It gets the requests from the controller and send it to repository(DAO)

 * @author Roaa Masri

 */

package App.Service;

import java.util.List;

import App.Model.Evenement;
import App.Repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class EventService {

    /**
     * Creating EventRepository variable with the @autowired annotation
     * this variable redirects the information from the Service to the DataBase
     */

    @Autowired
    private EventRepository repo;

    /**
     * listAll function search for all events that had been added
     * @return all the events
     */
    public List<Evenement> listAll() {
        return repo.findAll();
    }

    /**
     * save function allows to add a new event
     * @param evenement
     */
    public void save(Evenement evenement) {
        repo.save(evenement);
    }

    /**
     * get function allows to find an event by its id
     * @param id
     * @return evenement
     */
    public Evenement get(long id) {
        return repo.findById(id).get();
    }

    /**
     * delete function allows to delete an event by its id
     * @param id
     */
    public void delete(long id) {
        repo.deleteById(id);
    }
}
