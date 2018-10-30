package Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodaline.model.Album;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>{

}
