package ro.simavi.mf.avr.aes.jsf.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ro.simavi.mf.avr.aes.model.PhoneDetails;
import ro.simavi.mf.avr.aes.service.RetrivePhoneDetailsService;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.Serializable;

@RequiredArgsConstructor
@ViewScoped
@Component
@Getter
@Setter
@Slf4j
public class RetrivePhoneDetailsBean implements Serializable {

    private final RetrivePhoneDetailsService retrivePhoneDetailsService;
    private PhoneDetails[] dataList;

    /**
     * Metoda aceasta se ocupa initializarea formei
     */
    @PostConstruct
    public void init() {
        try {
            dataList = retrivePhoneDetailsService.getDataSetForCurrentDay();
        } catch (IOException | JAXBException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
