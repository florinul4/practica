package ro.simavi.mf.avr.aes.jsf.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.simavi.mf.avr.aes.model.MovieDetails;
import ro.simavi.mf.avr.aes.model.MovieList;
import ro.simavi.mf.avr.aes.service.RetrieveMovieDetailsService;

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
public class RetrieveMovieDetailsBean implements Serializable {
    private final RetrieveMovieDetailsService retrieveMovieDetailsService;
    private MovieList movielist;
    private MovieDetails[] moviedatalist;

    /**
     * Metoda aceasta se ocupa initializarea formei
     */
    @PostConstruct
    public void init() {
        try {

            movielist = retrieveMovieDetailsService.getDataSetForCurrentDay();
            moviedatalist=movielist.results;

        } catch (IOException | JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
