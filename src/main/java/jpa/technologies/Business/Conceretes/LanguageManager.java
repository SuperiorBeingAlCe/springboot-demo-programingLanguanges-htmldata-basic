package jpa.technologies.Business.Conceretes;

import jpa.technologies.Business.Abstracts.LanguageService;
import jpa.technologies.Business.Request.CreateLanguageRequest;
import jpa.technologies.Business.Request.DeleteLanguageRequest;
import jpa.technologies.Business.Request.GetLanguageById;
import jpa.technologies.Business.Request.UpdateLanguageRequest;
import jpa.technologies.Business.Response.*;
import jpa.technologies.DataAccess.Abstracts.LanguageRepository;
import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;
import jpa.technologies.Entities.Conceretes.Technology;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LanguageManager implements LanguageService {
    private LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllLanguagesResponse> getAllLanguages() {
        return LanguageMapper(languageRepository.findAll());
    }



    @Override
    public void add(CreateLanguageRequest createLanguageRequest) {
        ProgrammingLanguage language = new ProgrammingLanguage();
        language.setName(createLanguageRequest.getName());
        this.languageRepository.save(language);
    }
    @Override
    public void update(UpdateLanguageRequest updateLanguageRequest) {
        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage();
        programmingLanguage.setName(updateLanguageRequest.getName());
        programmingLanguage.setId(updateLanguageRequest.getId());
        languageRepository.save(programmingLanguage);
   }

    @Override
    public void remove(DeleteLanguageRequest deleteLanguageRequest) {
        List<ProgrammingLanguage> languages = languageRepository.findAll();
        for (ProgrammingLanguage l : languages){
            if(deleteLanguageRequest.getId() == l.getId()){
                languageRepository.delete(l);
            }
        }
    }

    @Override
    public LanguageResponse getLanguageById(GetLanguageById getLanguageById) {
        ProgrammingLanguage programmingLanguage = languageRepository.findById(getLanguageById.getId()).orElseThrow();
        List<TechnologiesResponse> technologiesResponses = new ArrayList<>();
        for(Technology technology : programmingLanguage.getTechnologies()){
            TechnologiesResponse response = new TechnologiesResponse();
            response.setName(technology.getName());
            response.setId(technology.getId());
            technologiesResponses.add(response);
        }
        LanguageResponse languageResponse = new LanguageResponse();
        languageResponse.setName(programmingLanguage.getName());
        languageResponse.setTechnologies(technologiesResponses);
        return languageResponse;
    }

    private List<GetAllLanguagesResponse> LanguageMapper(List<ProgrammingLanguage> languages){
        List<GetAllLanguagesResponse> response = new ArrayList<GetAllLanguagesResponse>();
        for (ProgrammingLanguage request : languages) {
            GetAllLanguagesResponse getAllLanguagesResponse = new GetAllLanguagesResponse();
            getAllLanguagesResponse.setId(request.getId());
            getAllLanguagesResponse.setName(request.getName());

            response.add(getAllLanguagesResponse);
        }
        return response;
    }
}
