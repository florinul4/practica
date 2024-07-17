package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter

public class StillList {
    @JsonProperty ("1")
    public StillDetails first;
    @JsonProperty ("2")
    public StillDetails second;
    @JsonProperty ("3")
    public StillDetails third;
    @JsonProperty ("4")
    public StillDetails forth;
    @JsonProperty ("5")
    public StillDetails fifth;
    @JsonProperty ("6")
    public StillDetails sixth;
    @JsonProperty ("7")
    public StillDetails seventh;
    @JsonProperty ("8")
    public StillDetails eight;


}
