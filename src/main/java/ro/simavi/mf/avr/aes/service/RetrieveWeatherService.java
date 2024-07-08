package ro.simavi.mf.avr.aes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ro.simavi.mf.avr.aes.model.IDWeather;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service

public class RetrieveWeatherService {

    public IDWeather getDataSetForCurrentDay() throws IOException, InterruptedException, JAXBException {
        URL obj = new URL("https://api.foreca.net/data/favorites/100683902,100683902.json");
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0");
        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            ObjectMapper objectMapper = new ObjectMapper();
            System.out.println(response.toString());
            IDWeather rootData = objectMapper.readValue(response.toString(), IDWeather.class);
            return rootData;
        } else {
            System.out.println("GET request not worked");
        }

        for (int i = 1; i <= 8; i++) {
            System.out.println(httpURLConnection.getHeaderFieldKey(i) + " = " + httpURLConnection.getHeaderField(i));
        }
        return null;
    }

    public <T> T convertXmlToObject(Class<T> clazz, String xml) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        StreamSource source = new StreamSource( new StringReader(xml) );

        JAXBElement<T> jaxbElement = jaxbUnmarshaller
                .unmarshal(source, clazz);
        return jaxbElement.getValue();

    }

}