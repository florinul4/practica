package ro.simavi.mf.avr.aes.jsf.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.simavi.mf.avr.aes.model.IDWeather;
import ro.simavi.mf.avr.aes.model.Weather;
import ro.simavi.mf.avr.aes.service.RetrieveWeatherService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@ViewScoped
@Component
@Getter
@Setter
@Slf4j

public class RetrieveWeatherBean {

    private final RetrieveWeatherService retrieveWeatherService;
    private IDWeather dataList;
    private List<Weather> weatherDataList;

    @PostConstruct

    public void init() {
        try {
            dataList = retrieveWeatherService.getDataSetForCurrentDay();
            weatherDataList = dataList.getWeatherList();
        } catch (IOException | JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
