package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodaline.model.Fotos;

@Repository
public interface FotosRepository extends JpaRepository<Fotos, Long> {

}
