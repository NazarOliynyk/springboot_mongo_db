package oktenweb.springboot_mongo_db;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


// we use this whole class to place a few
// hotels for the beginning to see them in the DB


@Component
public class DbSeeder implements CommandLineRunner {

    private HotelRepository hotelRepository;
    public DbSeeder(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    // we use it to place a few hotels for the beginning to see them in the DB
    @Override
    public void run(String... args) throws Exception {
        Hotel marriot = new Hotel(
                "Marriot",
                130,
                new Address("Paris", "France"),
                Arrays.asList(
                        new Rewiev("John", 8, false),
                        new Rewiev("Mary", 7, true)
                )
        );
        Hotel ibis = new Hotel(
                "Ibis",
                90,
                new Address("Buchares", "Romania"),
                Arrays.asList(
                        new Rewiev("Teddy", 9, true)
                )
        );
        Hotel sofitel = new Hotel(
                "Sofitel",
                200,
                new Address("Rome", "Italy"),
               new ArrayList<>()
        );
        // drop all hotels
        this.hotelRepository.deleteAll();
        // add our hotels to the database
        List<Hotel> hotels = Arrays.asList(marriot, ibis, sofitel);
        this.hotelRepository.save(marriot);
        this.hotelRepository.save(ibis);
        this.hotelRepository.save(sofitel);
    }
}
