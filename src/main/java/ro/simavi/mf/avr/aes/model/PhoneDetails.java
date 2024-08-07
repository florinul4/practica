package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

 public class PhoneDetails {
    @JsonProperty("name")
    public String name;
    @JsonProperty("phone")
    public int phone;
    @JsonProperty("time")
    public int time;
    //@JsonProperty("date")
  //  public String date;

    public int id;
}