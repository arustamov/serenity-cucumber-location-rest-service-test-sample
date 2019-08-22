package arustamov.ws.controller;

import arustamov.entity.Location;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class LocationController {

    private List<Location> locations = Stream.of(
        new Location(
            "1842347-1560779940",
            "£829.99",
            "LON"
        ),
        new Location(
            "1936481-1560779940",
            "£150.29",
            "MAN"
        ),
        new Location(
            "1936504-1560779940",
            "£1164.74",
            "CAM"
        ),
        new Location(
            "1936527-1560779940",
            "£279.99",
            "LCS"
        )
    )
        .collect(Collectors.toList());;

    @GetMapping("/get/all")
    public List<Location> getAll() {
        return locations;
    }

    @GetMapping("/get/{code}")
    public Location get(@PathVariable(value="code") final String code) {
        return getAll()
            .stream()
            .filter(location -> code.equals(location.getCode()))
            .findFirst()
            .get();
    }

    @PostMapping("/post")
    public List<Location> post(@RequestBody final Location location) {
        locations.add(location);
        return locations;
    }
}
