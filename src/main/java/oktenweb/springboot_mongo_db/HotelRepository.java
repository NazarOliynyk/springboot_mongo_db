package oktenweb.springboot_mongo_db;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    // all query methods can be assigned by the names of methods:
    // https://docs.spring.io/spring-data/mongodb/docs/1.2.0.RELEASE/reference/html/mongo.repositories.html#mongodb.repositories.queries
    //@Query(value = "{_id:?0}")
    Optional<Hotel> findById(String id);

     List<Hotel> findByPricePerNightLessThan(int max);

    @Query(value = "{address.city:?0}")
    List<Hotel> findByCity(String city);
}
