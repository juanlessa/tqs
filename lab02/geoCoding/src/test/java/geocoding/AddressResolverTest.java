package geocoding;

import org.apache.http.client.utils.URIBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Formatter;
import java.util.Locale;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AddressResolverTest {

    @Mock
    TqsHttpClient tqsHttpClient;

    @InjectMocks
    AddressResolver addressResolver;

    @Test
    void whenGoodAlboiGps_returnAddress() throws ParseException, IOException, URISyntaxException {

        // todo
        when(tqsHttpClient.get(location(40, -8))).thenReturn("{\n" + "    \"results\": [\n" + "        {\n"
                + "            \"providedLocation\": {\n" + "                \"latLng\": {\n"
                + "                    \"lat\": 10,\n" + "                    \"lng\": 10\n" + "                }\n"
                + "            },\n" + "            \"locations\": [\n" + "                {\n"
                + "                    \"street\": \"Parque Estacionamento da Reitoria - Univerisdade de Aveiro\",\n"
                + "                    \"adminArea5\": \"Glória e Vera Cruz\",\n"
                + "                    \"adminArea3\": \"Centro\",\n"
                + "                    \"postalCode\": \"3810-193\",\n" + "                }\n" + "            ]\n"
                + "        }\n" + "    ]\n" + "}");

        // test
        Address addressReturned = addressResolver.findAddressForLocation(40, -8);

        Address addressExpected = new Address(null, "Parque Estacionamento da Reitoria - Univerisdade de Aveiro",
                "Glória e Vera Cruz", "Centro", "3810-193");

        // return
        assertEquals(addressReturned, addressExpected);

    }

    @Test
    public void whenBadCoordidates_throwBadArrayindex() throws IOException, URISyntaxException, ParseException {

        // todo
    }

    private static String location(double lat, double lnt) throws URISyntaxException {
        URIBuilder uriBuilder = new URIBuilder(
                "http://open.mapquestapi.com/geocoding/v1/reverse?key=uXSAVwYWbf9tJmsjEGHKKAo0gOjZfBLQ");
        uriBuilder.addParameter("location", (new Formatter()).format(Locale.US, "%.6f,%.6f", lat, lnt).toString());
        uriBuilder.addParameter("includeRoadMetadata", "true");
        return uriBuilder.build().toString();
    }
}