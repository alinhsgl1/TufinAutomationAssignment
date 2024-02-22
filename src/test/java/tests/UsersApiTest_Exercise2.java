package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import static io.restassured.RestAssured.given;

public class UsersApiTest_Exercise2 {
    @Test
    public void listExistingUsers() throws IOException {

        // Create a URL object for the API endpoint
        URL url = new URL("https://reqres.in/api/users");

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Get the response code from the server
        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        // Read the response from the server
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Print the response body
        System.out.println("Response Body: " + response.toString());
    }

    @Test
    public void testTobiasFunkeInUsersList() {
        // Set the base URI for the API
        RestAssured.baseURI = "https://reqres.in/api";

        // Initialize a flag to indicate if Tobias Funke is found
        boolean tobiasFound = false;

        // Start with the first page
        int page = 1;

        // Iterate over each page in the users list
        while (true) {
            // Get the response for the current page
            Response response = given()
                    .queryParam("page", page)
                    .when()
                    .get("/users");

            // Check if the response is successful
            if (response.getStatusCode() != 200) {
                System.out.println("Failed to retrieve users list.");
                break;
            }

            // Get the list of user names on the current page
            List<String> userNames = response.jsonPath().getList("data.first_name");
            List<String> userLastNames = response.jsonPath().getList("data.last_name");
            System.out.println(userNames + "" + userLastNames);

            // Check if Tobias Funke is in the list of user names
            if (userNames.contains("Tobias")) {
                tobiasFound = true;
                break; // Tobias Funke found, exit the loop
            }

            // Check if there are more pages to fetch
            int totalPages = response.jsonPath().getInt("total_pages");
            if (page >= totalPages) {
                break; // No more pages to fetch, exit the loop
            }

            // Move to the next page
            page++;
        }

        // Print the result based on whether Tobias Funke was found
        if (tobiasFound) {
            System.out.println("Tobias Funke found in the list of users.");
        } else {
            System.out.println("Tobias Funke not found in the list of users.");
        }

    }
}