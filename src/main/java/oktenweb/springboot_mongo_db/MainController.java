package oktenweb.springboot_mongo_db;

import com.mongodb.util.JSON;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private HotelRepository hotelRepository;

    @RequestMapping("/")
    private String showHotels(Model model){
        List<Hotel> h = hotelRepository.findAll();
        List<String> hotels = new ArrayList<>();
        for (Hotel hotel : h) {
           hotels.add(hotel.getId()+", "+hotel.getName()+", "+hotel.getPricePerNight()+
                   ","+hotel.getAddress());
        }
        model.addAttribute("hotels", hotels);
        return "index";
    }

    @PostMapping("/save")
    public String save(@RequestParam("name") String name,
                       @RequestParam("pricePerNight") int pricePerNight,
                       @RequestParam("city") String city,
                       @RequestParam("country") String country,
                       @RequestParam("userName") String userName,
                       @RequestParam("rating") int rating){

        Address address = new Address(city, country);
        Rewiev rewiev = new Rewiev(userName, rating, true);
        List<Rewiev> rewievs = new ArrayList<>();
        rewievs.add(rewiev);
        Hotel hotelToSave = new Hotel(name, pricePerNight, address, rewievs);
        this.hotelRepository.insert(hotelToSave);
        return "redirect:/";
    }
}
