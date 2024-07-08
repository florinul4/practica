package ro.simavi.mf.avr.aes.model;

/*import com.fasterxml.jackson.annotation.JsonProperty;*/
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter

    public class Weather{

        public String date;

        public String symb;

        public int tmin;
        public int tmax;

        public int rain;
        public int rainp;

        public int snowp;
        public int snowff;

        public int rhum;

        public int windd;
        public int winds;

        public String sunrise;
        public String sunset;

        public String daylen;

        public int uvi;

        public Date updated;

    }

