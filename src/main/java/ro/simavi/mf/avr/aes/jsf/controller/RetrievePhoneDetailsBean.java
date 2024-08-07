package ro.simavi.mf.avr.aes.jsf.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.simavi.mf.avr.aes.model.PhoneDetails;
import ro.simavi.mf.avr.aes.service.RetrievePhoneDetailsService;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@RequiredArgsConstructor
@ViewScoped
@Component
@Getter
@Setter
@Slf4j
public class RetrievePhoneDetailsBean implements Serializable {

    private final RetrievePhoneDetailsService retrievePhoneDetailsService;
    private PhoneDetails[] dataList;

    /**
     * Metoda aceasta se ocupa initializarea formei
     */
    @PostConstruct
    public void init() {
        try {
            dataList = retrievePhoneDetailsService.getDataSetForCurrentDay();

        } catch (IOException | JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
