package jpa.technologies.Business.Request;

import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateTechnologyRequest {
    private String name;
    private int languageId;
}
