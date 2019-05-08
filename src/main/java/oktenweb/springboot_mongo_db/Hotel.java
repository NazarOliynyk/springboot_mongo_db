package oktenweb.springboot_mongo_db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "Hotels")
public class Hotel {
    @Id
    private String id; // in mongo id is a set of numbers and letters
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING) // places properties in ascending order
    private int pricePerNight;
    private Address address;
    private List<Rewiev> rewievs;

    protected Hotel() {
        this.rewievs = new ArrayList<>();
    }

    public Hotel( String name, int pricePerNight, Address address, List<Rewiev> rewievs) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.address = address;
        this.rewievs = rewievs;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public Address getAddress() {
        return address;
    }

    public List<Rewiev> getRewievs() {
        return rewievs;
    }
}
