package br.com.letscode.moviesbattle.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ImbResponse {

    @JsonProperty("Title")
    private String title;

    private String imdbRating;

    private String imdbVotes;

}
