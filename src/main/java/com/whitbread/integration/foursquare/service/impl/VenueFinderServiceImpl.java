package com.whitbread.integration.foursquare.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.whitbread.integration.foursquare.model.Venue;
import com.whitbread.integration.foursquare.service.VenueFinderService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by hakankurtulus on 17/10/2016.
 */
@Service
public class VenueFinderServiceImpl implements VenueFinderService {

    public List<Venue> findVenuesByName(final String name) throws Exception
    {
        if (StringUtils.isEmpty(name))
        {
            throw new IllegalArgumentException("Illegal Argument param");
        }

        final Client client = Client.create();

        final WebResource resource = client
                .resource("https://api.foursquare.com/v2/venues/search?"
                        + "oauth_token=JUN1121JURTDGCZNJVHQ4YI1XDAIQUWB5ETDBINFJCZVOZFH&v=20161018&near="
                        + name);

        ClientResponse response = resource.accept("application/json")
                .get(ClientResponse.class);

        if (response.getStatus() != 200)
        {
            throw new RuntimeException(
                    "Failed : HTTP error code : " + response.getStatus());
        }

        String output = response.getEntity(String.class);
        return convertToJava(output);
    }

    /**
     * Converts the json object into location pojo.
     *
     * @param jsonString as String
     * @return list of location
     */
    private List<Venue> convertToJava(final String jsonString)
            throws Exception
    {
        final List<Venue> places = new ArrayList<Venue>();

        // Create json related objects
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode rootNode = objectMapper.readTree(jsonString);
        JsonNode venuesNode = rootNode.findPath("venues");
        Iterator<JsonNode> venues = venuesNode.elements();

        while (venues.hasNext())
        {
            JsonNode venue = venues.next();
            JsonNode name = venue.findPath("name");
            JsonNode location = venue.findPath("location");

            Venue place = new Venue();
            place.setLatitude(location.findPath("lat").asText());
            place.setLongitude(location.findPath("lng").asText());
            place.setName(name.asText());
            places.add(place);
        }

        return places;
    }
}
