package be.ordina.junit5workshop.beer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "BEER")
public class Beer {
    @Id
    private UUID uuid;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ALCOHOL_CONTENT")
    private double alcoholContent;

    protected Beer( ) {
        //JPA
    }

    public Beer(UUID uuid, String name, double alcoholContent) {
        this.uuid = uuid;
        this.name = name;
        this.alcoholContent = alcoholContent;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public double getAlcoholContent() {
        return alcoholContent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Beer beer = (Beer) o;
        return Double.compare(beer.alcoholContent, alcoholContent) == 0 &&
                Objects.equals(uuid, beer.uuid) &&
                Objects.equals(name, beer.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid, name, alcoholContent);
    }
}
