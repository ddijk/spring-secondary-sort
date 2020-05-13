package nl.dijkrosoft.jpa.secundarysort;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RennerController {

    @Autowired
    RennerRepository rennerRepository;

    @GetMapping("/all")
    public List<Renner> getAll(@RequestParam String primary, @RequestParam String secundary ) {

        System.out.println(String.format("Primary='%s', Secondary='%s'", primary, secundary));
        List<Renner> renners = new ArrayList<>();
        Sort sort = getSorting(primary, secundary);
        rennerRepository.findAll(sort).forEach(renners::add);

//        rennerRepository.findAll().forEach(renners::add);

        return renners;
    }

    private Sort getSorting(@RequestParam String primary, @RequestParam String secundary) {

        if ( secundary == null) {
            return Sort.by(Sort.Order.asc(primary));
        }

        return Sort.by(
                    Sort.Order.asc(primary),
                    Sort.Order.asc(secundary));
    }
}
