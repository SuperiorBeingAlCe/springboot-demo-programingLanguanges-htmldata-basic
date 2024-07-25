package jpa.technologies.Business.Response;

import jpa.technologies.Entities.Conceretes.Technology;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LanguageResponse {
    private String name;
    private List<TechnologiesResponse> technologies;
}
