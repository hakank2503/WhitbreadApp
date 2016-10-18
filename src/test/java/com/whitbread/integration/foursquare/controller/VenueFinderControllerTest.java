package com.whitbread.integration.foursquare.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by hakankurtulus on 17/10/2016.
 */
public class VenueFinderControllerTest {

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(new VenueFinderController())
                .build();
    }


    @Test
    public void home() throws Exception {
        this.mockMvc
                .perform(get("/home").accept(MediaType
                        .parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(view().name("venueFinder"));
    }
}