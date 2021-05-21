package training.cassandra.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import training.cassandra.entity.Chevron;
import training.cassandra.entity.ChevronPrimaryKey;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ChevronRepositorySpec {

    @Autowired
    private ChevronRepository chevronRepository;

    @Test
    public void returnsAllChevrons() {
        List<Chevron> allChevrons = chevronRepository.findAll();
        assertNotNull(allChevrons);
    }

    @Test
    public void returnChevronsByArea() {
        List<Chevron> matchingChevrons = chevronRepository.findByKeyArea("Milky Way");
        assertNotNull(matchingChevrons);
    }

    @Test
    public void returnChevronsByAreaAndCode() {
        Optional<Chevron> chevronOptional = chevronRepository.findById(new ChevronPrimaryKey("Milky Way", 1));
        assertTrue(chevronOptional.isPresent());
    }
}
