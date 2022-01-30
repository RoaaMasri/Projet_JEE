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

    @Autowired
    private ParticRepository repo;

    public List<Participant> listAll() {
        return repo.findAll();
    }

    public void save(Participant participant) {
        repo.save(participant);
    }

    public Participant get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }

}
