package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

public class ImageList {
    //@JsonProperty ("poster")
   // public String poster_url;
    @JsonProperty ("still")
    public StillList still;
   // @JsonProperty ("status")
   // public String status;
}
