package ro.simavi.mf.avr.aes.jsf.controller;

import ro.simavi.mf.avr.aes.model.MovieDetails;
import ro.simavi.mf.avr.aes.model.MovieList;
import ro.simavi.mf.avr.aes.service.RetrieveMovieDetailsService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
//@RequiredArgsConstructor
@ViewScoped
@Component
@Getter
@Setter
@Slf4j
public class RetrieveMovieDetailsBean implements Serializable {
    @Autowired
    private RetrieveMovieDetailsService retrieveMovieDetailsService;
    private MovieList movielist;
    private MovieDetails[] movie_datalist;
    private String movie_synopsis;
    @Getter
    private static String correct_movie_title;
    @Getter
    private  ArrayList<String> movie_titles = new ArrayList<>();
    private int difficulty;
    private String text;

    private String countryName;
    @Setter
    @Getter
    private String selectedItem;



    @Getter
    private String outputText = "";


    /**
     * Metoda aceasta se ocupa initializarea formei
     */
    @PostConstruct
    public void init() {
        log.info("init method called");
        try {
            movie_synopsis="poveste";
            System.out.println(movie_synopsis);

            movielist = retrieveMovieDetailsService.getDataSetForCurrentDay(1);
            movie_datalist = movielist.results;
            Random rand = new Random();
            int select_movie = rand.nextInt(movie_datalist.length);
            movie_synopsis = movie_datalist[select_movie].overview;
            correct_movie_title = movie_datalist[select_movie].title;
            movie_titles.clear();
            System.out.println(correct_movie_title);


            for (int i = 2; i <= 10; i++) {
                int size = movie_datalist.length;
                for (int j = 0; j < size; j++) {
                    movie_titles.add(movie_datalist[j].getTitle());

                }
                movielist = retrieveMovieDetailsService.getDataSetForCurrentDay(i);
                movie_datalist = movielist.results;
            }
            // System.out.println(movie_titles);
           /* ObjectMapper objectMapper = new ObjectMapper();
            String jsonArray = objectMapper.writeValueAsString(movie_titles);
            System.out.println(jsonArray);*/


        } catch (IOException | JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


    public String getCorrectMovieTitle() {
        return correct_movie_title;
    }

   /* public List<String> getCountryList(String query) {
        System.out.println("check");
        String queryLowerCase = query.toLowerCase();
        ArrayList<String> stCountry = RetrieveMovieDetailsBean.getMovie_titles();
        return stCountry.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());

    }
*/
   public List<String> getCountryList(String query) {
       System.out.println("check");
       String queryLowerCase = query.toLowerCase();
       return movie_titles.stream()
               .filter(t -> t.toLowerCase().startsWith(queryLowerCase))
               .collect(Collectors.toList());

   }

    public void processSelection() {
        System.out.println(selectedItem);
        if (Objects.equals(selectedItem, getCorrectMovieTitle())) {
            outputText = "Good job, you guessed right!!";
            System.out.println("merge");
        } else outputText = "Good job, you guessed wrong!!";
    }
}