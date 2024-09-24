package co.musicshop.fis.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import co.musicshop.fis.models.Instrument;
import co.musicshop.fis.services.InstrumentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @GetMapping
    public List<Instrument> getAllInstruments() {
        return instrumentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Instrument> getInstrumentById(@PathVariable Long id) {
        Optional<Instrument> instrument = instrumentService.findById(id);
        return instrument.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument) {
        return instrumentService.save(instrument);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Instrument> updateInstrument(@PathVariable Long id, @RequestBody Instrument instrumentDetails) {
        Optional<Instrument> instrumentOptional = instrumentService.findById(id);
        if (instrumentOptional.isPresent()) {
            Instrument instrument = instrumentOptional.get();
            instrument.setName(instrumentDetails.getName());
            instrument.setType(instrumentDetails.getType());
            instrument.setBrand(instrumentDetails.getBrand());
            instrument.setPrice(instrumentDetails.getPrice());
            instrument.setPhoto(instrumentDetails.getPhoto());
            Instrument updatedInstrument = instrumentService.save(instrument);
            return ResponseEntity.ok(updatedInstrument);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
