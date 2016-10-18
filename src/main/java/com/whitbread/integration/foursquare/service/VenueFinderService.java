package com.whitbread.integration.foursquare.service;

import com.whitbread.integration.foursquare.model.Venue;

import java.util.List;

/**
 * Created by hakankurtulus on 17/10/2016.
 */
public interface VenueFinderService {

    List<Venue> findVenuesByName(String name) throws Exception;
}
