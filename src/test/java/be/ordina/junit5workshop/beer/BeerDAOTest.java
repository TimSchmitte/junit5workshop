package be.ordina.junit5workshop.beer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class BeerDAOTest {
    @Test
    void saveDuvelAndRetrieve(@Autowired BeerDAO beerDAO) {
        final UUID uuid = UUID.randomUUID();
        final Beer beerBeforeSave = new Beer(uuid, "Duvel", 8.0);
        beerDAO.save(beerBeforeSave);

        final Optional<Beer> beerOptional = beerDAO.findById(uuid);
        assertTrue(beerOptional.isPresent());
        assertThat(beerBeforeSave, is(beerOptional.get()));
        assertThat(beerDAO.findAll().size(), is(1));
    }
}
