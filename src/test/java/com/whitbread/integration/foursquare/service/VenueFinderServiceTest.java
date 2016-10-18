package com.whitbread.integration.foursquare.service;

import com.whitbread.integration.foursquare.model.Venue;
import com.whitbread.integration.foursquare.service.impl.VenueFinderServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hakankurtulus on 17/10/2016.
 */
@RunWith(MockitoJUnitRunner.class)
public class VenueFinderServiceTest {

    @Mock
    private VenueFinderService mockedVenueFinderService;

    private VenueFinderService venueFinderService;

    @Before
    public void setUp() throws Exception {
        venueFinderService = new VenueFinderServiceImpl();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWhenNameNotProvided() throws Exception
    {
        venueFinderService.findVenuesByName(null);
    }

    @Test
    public void testMockWhenNameProvided() throws Exception
    {
        List<Venue> expected = new ArrayList<>();
        Venue venue = new Venue();
        venue.setName("test");
        expected.add(venue);

        Mockito.when(mockedVenueFinderService.findVenuesByName("london"))
                .thenReturn(expected);
        List<Venue> actual = mockedVenueFinderService
                .findVenuesByName("london");
        Assert.assertNotNull(actual.get(0));
        Assert.assertEquals(actual.size(), expected.size());
    }

    @Test
    public void testWhenNameProvided() throws Exception
    {
        List<Venue> actual = venueFinderService
                .findVenuesByName("london");
        Assert.assertNotNull(actual.get(0));
        Assert.assertEquals(actual.size(), 30);
    }
}