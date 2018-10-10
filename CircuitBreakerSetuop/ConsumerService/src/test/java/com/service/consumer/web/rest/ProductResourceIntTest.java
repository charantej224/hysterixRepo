package com.service.consumer.web.rest;

import com.service.consumer.ConsumerServiceApp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
/**
 * Test class for the ProductResource REST controller.
 *
 * @see ProductResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ConsumerServiceApp.class)
public class ProductResourceIntTest {

    private MockMvc restMockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        ProductResource productResource = new ProductResource();
        restMockMvc = MockMvcBuilders
            .standaloneSetup(productResource)
            .build();
    }

    /**
    * Test getRemoteResponse
    */
    @Test
    public void testGetRemoteResponse() throws Exception {
        restMockMvc.perform(get("/api/product/get-remote-response"))
            .andExpect(status().isOk());
    }

}
