package com.stackroute.SpringBootTask;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.SpringBootTask.domain.Muzix;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ConvertJson {
  ObjectMapper mapper = new ObjectMapper();

  // Read JSON file and convert to java object
  FileInputStream fileInputStream = new FileInputStream("muzix.json");
  Muzix muzix = mapper.readValue(fileInputStream, Muzix.class);

  public ConvertJson() throws IOException {
  }

}
