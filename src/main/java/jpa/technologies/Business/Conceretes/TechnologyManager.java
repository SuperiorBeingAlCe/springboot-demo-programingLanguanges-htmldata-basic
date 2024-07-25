package jpa.technologies.Business.Conceretes;

import jpa.technologies.Business.Abstracts.TechnologyService;
import jpa.technologies.Business.Request.CreateTechnologyRequest;
import jpa.technologies.Business.Request.DeleteTechnologyRequest;
import jpa.technologies.Business.Request.UpdateTechnologyRequest;
import jpa.technologies.Business.Response.GetAllTechnologiesResponse;
import jpa.technologies.DataAccess.Abstracts.LanguageRepository;
import jpa.technologies.DataAccess.Abstracts.TechnologyRepository;
import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;
import jpa.technologies.Entities.Conceretes.Technology;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    TechnologyRepository technologyRepository;
    LanguageRepository languageRepository;

    public TechnologyManager(TechnologyRepository technologyRepository, LanguageRepository languageRepository){
        this.technologyRepository=technologyRepository;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        List<GetAllTechnologiesResponse> responses = new ArrayList<>();
        for (Technology technology : technologies){
            GetAllTechnologiesResponse getAllTechnologiesResponse = new GetAllTechnologiesResponse();
            getAllTechnologiesResponse.setName(technology.getName());
            getAllTechnologiesResponse.setId(technology.getId());
            getAllTechnologiesResponse.setLanguageId(technology.getProgrammingLanguage().getId());
            responses.add(getAllTechnologiesResponse);
        }
        return responses;
    }

    @Override
    public void add(CreateTechnologyRequest createTechnologyRequest) {
        ProgrammingLanguage language = languageRepository.findById(createTechnologyRequest.getLanguageId()).orElseThrow();
        Technology technology = new Technology();
        technology.setName(createTechnologyRequest.getName());
        technology.setProgrammingLanguage(language);
        technologyRepository.save(technology);
    }

    @Override
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest) {
            for (Technology t : technologyRepository.findAll()){
                if (t.getId() == deleteTechnologyRequest.getId()){
                    try {
                        technologyRepository.delete(t);
                    }catch (Exception e){
                        System.out.println("qq"+"delete: "+e.toString() );
                    }

                }
            }
    }

    @Override
    public void update(UpdateTechnologyRequest updateTechnologyRequest) {
        Technology technology = new Technology();
        technology.setId(updateTechnologyRequest.getRequest_id());
        technology.setName(updateTechnologyRequest.getName());
        technology.setProgrammingLanguage(languageRepository.findById(updateTechnologyRequest.getLanguage_id()).orElse(null));
        technologyRepository.save(technology);
    }
}
