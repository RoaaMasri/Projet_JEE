/**

 * ParticService class it uses the ParticRepository methods

 * It gets the requests from the controller and send it to repository(DAO)

 * @author Adrienne Zebaze

 */

package App.Service;



import App.Model.Participant;
import App.Repository.ParticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ParticService {

    /**
     * Creating ParticRepository variable with the @autowired annotation
     * this variable redirects the information from the Service to the DataBase
     */
    @Autowired
    private ParticRepository repo;

    /**
     * listAll function search for all participants that had been added
     * @return all the participants
     */
    public List<Participant> listAll() {
        return repo.findAll();
    }

    /**
     * save function allows to add a new participant
     * @param participant
     */
    public void save(Participant participant) {
        repo.save(participant);
    }

    /**
     * get function allows to find a participant by its id
     * @param id
     * @return participant
     */
    public Participant get(long id) {
        return repo.findById(id).get();
    }

    /**
     * delete methods allows to delete event by its id
     * @param id
     */
    public void delete(long id) {
        repo.deleteById(id);
    }

}
