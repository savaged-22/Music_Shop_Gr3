package co.musicshop.fis.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import co.musicshop.fis.models.Instrument;

public interface InstrumentRepository extends JpaRepository<Instrument, Long> {
}
