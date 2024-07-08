package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import ro.simavi.mf.avr.aes.model.Weather;

import java.util.ArrayList;

@Getter
@Setter

public class IDWeather {

    @JsonProperty("100683902")
    public ArrayList<Weather> weatherList;

}
