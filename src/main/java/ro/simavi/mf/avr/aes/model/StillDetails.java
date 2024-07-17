package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

public class StillDetails {
    @JsonProperty ("image_orientation")
    public String imageOrientation;
    @JsonProperty("medium")
    public StillMediumDetails medium;
}
