package jpa.technologies.Business.Abstracts;

import jpa.technologies.Business.Request.CreateLanguageRequest;
import jpa.technologies.Business.Request.DeleteLanguageRequest;
import jpa.technologies.Business.Request.GetLanguageById;
import jpa.technologies.Business.Request.UpdateLanguageRequest;
import jpa.technologies.Business.Response.GetAllLanguagesResponse;
import jpa.technologies.Business.Response.GetTechnologiesByLanguageResponse;
import jpa.technologies.Business.Response.LanguageResponse;
import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAllLanguages();
    void add(CreateLanguageRequest createLanguageRequest);
    void update(UpdateLanguageRequest updateLanguageRequest);
    void remove(DeleteLanguageRequest deleteLanguageRequest);
    LanguageResponse getLanguageById(GetLanguageById getLanguageById);
}
