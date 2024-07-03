package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
 public class PhoneDetails {
    public String id;
    public String name;
    @JsonProperty("data")
    public DataPhoneDetails dataPhoneDetails;
}