package dbms.railway.controllers;

import dbms.railway.dao.StationJdbcDao;
import dbms.railway.dao.UserJdbcDao;
import dbms.railway.models.User;
import dbms.railway.models.station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class main {
    @Autowired
    private StationJdbcDao stationJdbcDao;

    private final UserJdbcDao userJdbcDao;

    @Autowired
    public main(UserJdbcDao userJdbcDao) {
        this.userJdbcDao = userJdbcDao;
    }

@GetMapping("/")
    public String index(Model model) {

        model.addAttribute("welcomeMessage", "Welcome, User!");
        System.out.println("lola");
        List<station> stations = stationJdbcDao.getAllStations();
        model.addAttribute("stations", stations);
        return "index";
    }
@GetMapping("/signup")
public String showSignupForm(Model model) {
    model.addAttribute("user", new User());
    return "signup";
}
    @PostMapping("/signup")
    public String signup(@ModelAttribute User user, Model model) {
        try {
            userJdbcDao.createUser(user);
            return "redirect:/signin";
        } catch (DuplicateKeyException e) {
            model.addAttribute("errorMessage", "Username already exists. Please choose a different username.");
            return "signup";
        }
    }

    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }





//    @PostMapping("/search")
//    public String searchTrains(@RequestParam("date") String date,
//                               @RequestParam("sourceStation") String sourceStation,
//                               @RequestParam("destinationStation") String destinationStation) {
//        // Implement your train search logic here
//        // You can return a view to display search results
//        return "searchResults"; // Create a searchResults.html Thymeleaf template
//}

}