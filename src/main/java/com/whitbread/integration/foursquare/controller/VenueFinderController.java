package com.whitbread.integration.foursquare.controller;

import com.whitbread.integration.foursquare.model.Venue;
import com.whitbread.integration.foursquare.service.VenueFinderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by hakankurtulus on 18/10/2016.
 */
@Controller
public class VenueFinderController {

    @Autowired
    private VenueFinderService venueFinderService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public String findVenue(@RequestParam("location") String location, Model model)
    {
        try {
            final List<Venue> searchedResults = venueFinderService
                    .findVenuesByName(location);
            if (searchedResults != null && searchedResults.size() > 0) {
                model.addAttribute("searchedResults", searchedResults);
                model.addAttribute("location", location);
            }
        } catch(Exception e){
            model.addAttribute("errorMessage", "No results found.");
        }
        return "venueFinder";
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home()
    {
        return "venueFinder";
    }

}
