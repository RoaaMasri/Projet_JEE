/**

 * Event Repository uses JPA (Java Persistence API) Repository.

 * It contains API for basic CRUD operations and also API for pagination and sorting.

 * @author Roaa Masri

 */

package App.Repository;

import App.Model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Evenement, Long>{

}
