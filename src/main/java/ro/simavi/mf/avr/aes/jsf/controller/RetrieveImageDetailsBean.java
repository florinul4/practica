package ro.simavi.mf.avr.aes.jsf.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.simavi.mf.avr.aes.model.ImageList;
import ro.simavi.mf.avr.aes.service.RetrieveImageService;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@ViewScoped
@Component
@Getter
@Setter
@Slf4j
public class RetrieveImageDetailsBean implements Serializable {
    private final RetrieveImageService retrieveImageService;
    private ImageList imageList;
    String image_path;

    /**
     * Metoda aceasta se ocupa initializarea formei
     */
    @PostConstruct
    public void init() {System.out.println("MERGE");
        try {

            imageList=retrieveImageService.getImageUrl();
            image_path=imageList.still.third.medium.film_image;
            System.out.println(image_path);


        } catch (IOException | JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
