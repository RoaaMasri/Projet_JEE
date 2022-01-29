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
    @Autowired
    private EventRepository repo;

    public List<Evenement> listAll() {
        return repo.findAll();
    }

    public void save(Evenement evenement) {
        repo.save(evenement);
    }

    public Evenement get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }
}
