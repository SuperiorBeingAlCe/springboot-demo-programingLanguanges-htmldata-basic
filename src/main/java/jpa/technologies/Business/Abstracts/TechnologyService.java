package jpa.technologies.Business.Abstracts;


import jpa.technologies.Business.Request.CreateTechnologyRequest;
import jpa.technologies.Business.Request.DeleteTechnologyRequest;
import jpa.technologies.Business.Request.UpdateTechnologyRequest;
import jpa.technologies.Business.Response.GetAllTechnologiesResponse;


import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologiesResponse> getAll();
    void add(CreateTechnologyRequest createTechnologyRequest);
    void update(UpdateTechnologyRequest updateTechnologyRequest);
    void delete(DeleteTechnologyRequest deleteTechnologyRequest);
}
