package co.musicshop.fis.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.musicshop.fis.models.Instrument;
import co.musicshop.fis.repositories.InstrumentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    public List<Instrument> findAll() {
        return instrumentRepository.findAll();
    }

    public Optional<Instrument> findById(Long id) {
        return instrumentRepository.findById(id);
    }

    public Instrument save(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    public void deleteById(Long id) {
        instrumentRepository.deleteById(id);
    }
}
