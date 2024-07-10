package com.sb.curdwithjpa.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class EmailRequest {

    @JsonProperty("updateEmailAddress")
    private String EmailAddress;
}
