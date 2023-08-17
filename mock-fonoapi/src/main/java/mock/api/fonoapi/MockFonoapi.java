package mock.api.fonoapi;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class MockFonoapi {

    public static void main(String[] args) throws Exception {
        WireMockServer wireMockServer = new WireMockServer(WireMockConfiguration.options().port(8080));
        wireMockServer.start();

        configureFor("localhost", 8080);
        

        // Load and parse the JSON mapping file
        JsonObject mappingJson = loadJsonMapping("mock_fonoapi_response.json");

        // Define mock responses based on device name
        mappingJson.keySet().forEach(deviceName -> {
            JsonObject response = mappingJson.getAsJsonObject(deviceName);
            stubFor(get(urlPathEqualTo("/v1/getdevice"))
                    .withQueryParam("device", equalTo(deviceName))
                    .willReturn(aResponse()
                            .withHeader("Content-Type", "application/json")
                            .withBody(response.toString())));
        });
        System.out.println("Mock Fonoapi is running on port 8080...");
    }
    
    private static JsonObject loadJsonMapping(String filePath) throws IOException {
        InputStream inputStream = MockFonoapi.class.getClassLoader().getResourceAsStream(filePath);
        InputStreamReader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        return JsonParser.parseReader(reader).getAsJsonObject();
    }
}

