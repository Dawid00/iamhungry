package com.depe.iamhungry;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class RecipeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void httpGet_returnsOneRecipeAndResponseStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes/one")).andExpect(status().is2xxSuccessful());
    }

    @Test
    void httpGet_returnsRecipesByQueryParamAndResponseStatus200() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/recipes")
                .param("name","chicken")
                .param("limit","3")
        ).andExpect(status().is2xxSuccessful());
    }
}
