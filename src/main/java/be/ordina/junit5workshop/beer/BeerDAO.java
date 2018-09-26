package be.ordina.junit5workshop.beer;


import be.ordina.junit5workshop.beer.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BeerDAO extends JpaRepository<Beer, UUID> {
}
