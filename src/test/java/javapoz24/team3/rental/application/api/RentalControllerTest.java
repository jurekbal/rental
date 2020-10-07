package javapoz24.team3.rental.application.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.StandardCharsets;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class RentalControllerTest {

    public static final MediaType APPLICATION_JSON_UTF8 =
            new MediaType(
                    MediaType.APPLICATION_JSON.getType(),
                    MediaType.APPLICATION_JSON.getSubtype(),
                    StandardCharsets.UTF_8
                    );

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getRentalInfoData() throws Exception {
        this.mockMvc.perform(get("/home"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void getAllBranches() throws Exception {
        this.mockMvc.perform(get("/branches"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void get_Existing_BranchById() throws Exception {
        this.mockMvc.perform(get("/branches/1"))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void get_NOT_ExistingBranchById() throws Exception {
        // Zawraca puste body z kodem 200
        this.mockMvc.perform(get("/branches/44"))
                .andDo(print())
                .andExpect(content().string(""))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    void update_correct_RentalInfoData() throws Exception {
        //given
        // TODO przerobić na konwersję z obiektu
        String requestBody = "{\n" +
                "    \"id\": 1,\n" +
                "    \"name\": \"New Name\",\n" +
                "    \"webDomain\": \"new web domain URL\",\n" +
                "    \"address\": {\n" +
                "        \"streetWithNumber\": \"Ruda 78\",\n" +
                "        \"city\": \"Kraśnik\",\n" +
                "        \"postalCode\": \"55-555\"\n" +
                "    },\n" +
                "    \"owner\": \"Nowy Owner\",\n" +
                "    \"logoURL\": \"new image URL\",\n" +
                "    \"companyBranches\": []\n" +
                "}";

        // when/then

            this.mockMvc.perform(put("/home")
                    .contentType(APPLICATION_JSON_UTF8)
                    .content(requestBody))
                        .andDo(print())
                        .andExpect(status().is2xxSuccessful());
    }

    @Test
    void update_incorrect_RentalInfoData() throws Exception {
        //given
        // TODO ewentualnie sprawdzić inne validacje
        String faultyRequestBody = "{\n" +
                "    \"x_name\": \"New Name\",\n" +
                "    \"webDomain\": \"http://newdata.pl\",\n" +
                "    \"owner\": \"nowe Imie i nazwisko\",\n" +
                "    \"logoURL\": \"http://newlogourl.pl\"\n" +
                "}";

        // when/then

        // Code 400 wil be probably changed to 422 -> add check for 422
        this.mockMvc.perform(put("/home")
                .contentType(APPLICATION_JSON_UTF8)
                .content(faultyRequestBody))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    void addBranchOffice() throws Exception {
        //given
        String requestBody = "{\n" +
                "    \"id\": null,\n" +
                "    \"address\": {\n" +
                "        \"streetWithNumber\": \"Mickiewicza 10\",\n" +
                "        \"city\": \"Gdynia\",\n" +
                "        \"postalCode\": \"81-210\"\n" +
                "    }\n" +
                "}";

        // when / then
        this.mockMvc.perform(put("/branches")
                .contentType(APPLICATION_JSON_UTF8)
                .content(requestBody))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());
    }
}
