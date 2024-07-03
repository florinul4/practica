package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataPhoneDetails {
        @JsonProperty("Color")
        public String color;
        @JsonProperty("capacity")
        public String capacity;
        @JsonProperty("capacity GB")
        public int capacityGB;
        @JsonProperty("price")
        public double price;
        @JsonProperty("generation")
        public String generation;
        @JsonProperty("year")
        public int year;
        @JsonProperty("CPU model")
        public String cPUmodel;
        @JsonProperty("Hard disk size")
        public String hardDiskSize;
        @JsonProperty("Strap Colour")
        public String strapColour;
        @JsonProperty("Case Size")
        public String caseSize;
        @JsonProperty("color")
        public String colorX2;
        @JsonProperty("Description")
        public String description;
        @JsonProperty("Capacity")
        public String capacityX2;
        @JsonProperty("Screen size")
        public double screensize;
        @JsonProperty("Generation")
        public String generationX2;
        @JsonProperty("Price")
        public String priceX2;

}
