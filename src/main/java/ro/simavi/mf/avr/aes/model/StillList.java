package ro.simavi.mf.avr.aes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.extensions.component.slideout.SlideOut;

import javax.validation.constraints.Null;
import java.util.Random;
import java.util.Vector;

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
    public StillDetails fourth;
    @JsonProperty ("5")
    public StillDetails fifth;
    @JsonProperty ("6")
    public StillDetails sixth;
    @JsonProperty ("7")
    public StillDetails seventh;
    public  StillDetails eight;

    
    public String getStill() {
        StillDetails[] stillDetails ={first,second,third,fourth,fifth,sixth,seventh,eight};
        int k=0;
        StillDetails aux=stillDetails[k];
        Vector<StillDetails> random_still=new Vector<>();
        while(aux!=null)
        {
         random_still.addElement(aux);
         k++;
         aux=stillDetails[k];
        }
        Random rand=new Random();
        int index=rand.nextInt(random_still.size());
        StillDetails final_still=random_still.elementAt(index);
       return final_still.medium.film_image;
    }



}
