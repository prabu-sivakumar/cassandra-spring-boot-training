package training.cassandra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import training.cassandra.entity.Chevron;
import training.cassandra.entity.ChevronPrimaryKey;
import training.cassandra.repository.ChevronRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chevrons")
public class ChevronController {

    @Autowired
    private ChevronRepository chevronRepository;

    @GetMapping
    public List<Chevron> findAll() {
        return chevronRepository.findAll();
    }

    @GetMapping("/{area}")
    public List<Chevron> findByArea(String area) {
        return chevronRepository.findByKeyArea(area);
    }

    @GetMapping("/{area}/{code}")
    public ResponseEntity<Chevron> findByAreaAndCode(String area, int code) {
        Optional<Chevron> chevronOptional = chevronRepository.findById(new ChevronPrimaryKey(area, code));
        if (chevronOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(chevronOptional.get());
    }
}
