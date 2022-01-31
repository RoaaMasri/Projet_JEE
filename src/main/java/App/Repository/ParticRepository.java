/**

 * Participant Repository uses JPA (Java Persistence API) Repository.

 * It contains API for basic CRUD operations and also API for pagination and sorting.

 * @author Adrienne Zebaze

 */

package App.Repository;


import App.Model.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticRepository extends JpaRepository<Participant, Long> {
}
