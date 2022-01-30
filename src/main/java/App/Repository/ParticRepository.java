package App.Repository;


import App.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticRepository extends JpaRepository<Participant, Long> {
}
