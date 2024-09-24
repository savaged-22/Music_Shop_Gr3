package co.musicshop.fis.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import co.musicshop.fis.models.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
}
