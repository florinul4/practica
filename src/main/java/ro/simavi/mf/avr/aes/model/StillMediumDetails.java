package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

public class StillMediumDetails {
    @JsonProperty ("film_image")
    public String film_image;
    @JsonProperty ("width")
    public int width;
    @JsonProperty ("height")
    public int height;

}
