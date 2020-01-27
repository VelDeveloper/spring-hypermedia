package com.hypermedia.demo.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

import javax.validation.constraints.NotNull;
import java.util.List;


@Builder
@Data
@RequiredArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = AccessLevel.PRIVATE)
@Document
@TypeAlias("capability-model")
public class Capability extends ResourceSupport {
    @Id
    private String capabilityId;

    @NotBlank(message = "Technology Stack cannot be blank")
    @NotNull(message = "Technology Stack cannot be null")
    private String techStack;
    private Integer numOfDevelopers = 0;
    private Integer numOfAvailableDevelopers = 0;

    @Override
    @JsonProperty("_links")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public List<Link> getLinks() {
        return super.getLinks();
    }


}
