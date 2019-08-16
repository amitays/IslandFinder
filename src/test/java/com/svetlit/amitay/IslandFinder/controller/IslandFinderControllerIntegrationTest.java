package com.svetlit.amitay.IslandFinder.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.svetlit.amitay.IslandFinder.model.BitMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IslandFinderControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;
	
	Random random = new Random();
	ObjectMapper objectMapper = new ObjectMapper();
	
	@Test
	public void whenRequestingRandomMapThenReceavingTheCorrectSizeMap() throws Exception{
		int width = random.nextInt(1000);
		int hight = random.nextInt(1000);
		mockMvc.perform(post("/islandfinder/randommap")
				.param("width", String.valueOf(width))
				.param("hight", String.valueOf(hight)))
		.andExpect(status().isOk())
		.andDo(mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            BitMap map = objectMapper.readValue(json, BitMap.class);
            assertThat(map.getMap().length).isEqualTo(width);
            assertThat(map.getMap()[0].length).isEqualTo(hight);
        });
	}
	
	@Test
	public void whenIdentifyingKnownMapThenReceavingKnownIsland() throws Exception{
		mockMvc.perform(post("/islandfinder/identify")
				.header("Content-Type", "application/json")
				.content("{\"map\":[[false,true],[false,false],[true,false]]}"))
		.andExpect(status().isOk())
		.andDo(mvcResult -> {
            String json = mvcResult.getResponse().getContentAsString();
            assertThat(json).isEqualTo("[{\"coordinates\":[{\"longitude\":0,\"latitude\":1}]},{\"coordinates\":[{\"longitude\":2,\"latitude\":0}]}]");
        });
	}
}