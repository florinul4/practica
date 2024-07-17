package ro.simavi.mf.avr.aes.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ro.simavi.mf.avr.aes.model.MovieDetails;
import ro.simavi.mf.avr.aes.model.MovieList;


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
import java.util.Collections;
import java.util.List;
@Service
@JsonIgnoreProperties(ignoreUnknown = true)
public class RetrieveMovieDetailsService {


    public MovieList getDataSetForCurrentDay() throws IOException, InterruptedException, JAXBException {
        //URL obj = new URL("https://www.omdbapi.com/?apikey=e7ebad09&i=tt0050083");
        URL obj = new URL("https://api.themoviedb.org/3/search/movie?query=planet+of+the+apes&api_key=aaac32a07c6685c8e64c8917140bab94");
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
            //allows for the usage of the api without implementing all offered characteristics
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            //objectMapper.configure(DeserializationFeature.USE_JAVA_ARRAY_FOR_JSON_ARRAY, true);
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!"+response);
            MovieList rootData =objectMapper.readValue(response.toString(), MovieList.class);
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
