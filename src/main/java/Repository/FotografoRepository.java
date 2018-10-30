package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodaline.model.Fotografo;

@Repository
public interface FotografoRepository extends JpaRepository<Fotografo, Long>{

}
