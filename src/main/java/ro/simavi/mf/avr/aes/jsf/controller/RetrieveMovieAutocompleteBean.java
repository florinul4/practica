package ro.simavi.mf.avr.aes.jsf.controller;
import org.springframework.stereotype.Component;
import ro.simavi.mf.avr.aes.model.MovieDetails;
import ro.simavi.mf.avr.aes.model.MovieList;
import ro.simavi.mf.avr.aes.service.RetrieveMovieDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;


import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import javax.faces.view.ViewScoped;
import org.springframework.context.annotation.Lazy;

@ViewScoped
@Setter
@Getter
@Slf4j
//@ManagedBean(name="country")
@Component
public class RetrieveMovieAutocompleteBean  {
    @Autowired
    private ApplicationContext applicationContext;
    private final RetrieveMovieAutocompleteBean retrieveMovieAutocompleteBean;
    private String countryName;
    @Setter
    @Getter
    private String selectedItem;
    @Getter
    private String outputText = "";

    public RetrieveMovieAutocompleteBean(@Lazy RetrieveMovieAutocompleteBean retrieveMovieAutocompleteBean) {
        this.retrieveMovieAutocompleteBean = retrieveMovieAutocompleteBean;
    }

    @PostConstruct
    public void init() {
    }

    public List<String> getCountryList(String query) {
        System.out.println("check");
        String queryLowerCase = query.toLowerCase();
        RetrieveMovieDetailsBean retrieveMovieDetailsBean = applicationContext.getBean(RetrieveMovieDetailsBean.class);
        ArrayList<String> stCountry = retrieveMovieDetailsBean.getMovie_titles();
        return stCountry.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());

    }

    public void processSelection() {
        System.out.println(selectedItem);
        RetrieveMovieDetailsBean retrieveMovieDetailsBean = applicationContext.getBean(RetrieveMovieDetailsBean.class);
        if (Objects.equals(selectedItem, retrieveMovieDetailsBean.getCorrectMovieTitle())) {
            outputText = "Good job, you guessed right!!";
            System.out.println("merge");
        } else outputText = "Good job, you guessed wrong!!";
    }

}

