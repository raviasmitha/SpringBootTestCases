package com.stackroute.SpringBootTask.controller;


import com.fasterxml.jackson.databind.ObjectMapper;

import com.stackroute.SpringBootTask.domain.Muzix;
import com.stackroute.SpringBootTask.exceptions.TrackAlreadyExistsException;
import com.stackroute.SpringBootTask.exceptions.TrackNotFoundException;
import com.stackroute.SpringBootTask.services.MuzixService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class MuzixControllerTest {

  @Autowired
  private MockMvc mockMvc;
  private Muzix muzix;
  private List<Muzix> muzixes;
  @MockBean
  private MuzixService muzixService;
  @InjectMocks
  private MuzixController muzixController;

  private List<Muzix> list =null;

  @Before
  public void setUp(){

    MockitoAnnotations.initMocks(this);
    mockMvc = MockMvcBuilders.standaloneSetup(muzixController).build();
    muzix = new Muzix();
    muzix.setId(26);
    muzix.setName("welcome");
    muzix.setRatings(10);
    muzix.setComment("good");
    list = new ArrayList();

    list.add(muzix);
  }

  @Test
  public void saveTrack() throws Exception {
    when(muzixService.saveMusix(any())).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/muzix")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isCreated())
      .andDo(MockMvcResultHandlers.print());


  }
  @Test
  public void saveTrackFailure() throws Exception {
    when(muzixService.saveMusix(any())).thenThrow(TrackAlreadyExistsException.class);
    mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/muzix")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isConflict())
      .andDo(MockMvcResultHandlers.print());
  }

  @Test
  public void getAllTracks() throws Exception {
    when(muzixService.getMusix()).thenReturn(list);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void getTrackById() throws Exception {
    when(muzixService.getById(1)).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void getTrackByIdFailure() throws Exception {
    when(muzixService.getById(1)).thenThrow (TrackNotFoundException.class);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isNotFound())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void getTrackByName() throws Exception {
    when(muzixService.getBYName("ashu")).thenReturn(muzixes);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/name/ashu")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void deleteById() throws Exception {
    when(muzixService.deleteById(1)).thenReturn(muzix);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void deleteByIdNotPresent() throws Exception {
    when(muzixService.deleteById(2)).thenThrow(TrackNotFoundException.class);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix/2")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }


  @Test
  public void updateById() throws Exception {
    when(muzixService.updateById(muzix,1)).thenReturn(true);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix/1")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }

  @Test
  public void updateByIdNotPresent() throws Exception {
    when(muzixService.updateById(muzix,2)).thenReturn(false);
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/muzix/2")
      .contentType(MediaType.APPLICATION_JSON).content(asJsonString(muzix)))
      .andExpect(MockMvcResultMatchers.status().isOk())
      .andDo(MockMvcResultHandlers.print());

  }



  private static String asJsonString(final Object obj)
  {
    try{
      return new ObjectMapper().writeValueAsString(obj);

    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }










}
