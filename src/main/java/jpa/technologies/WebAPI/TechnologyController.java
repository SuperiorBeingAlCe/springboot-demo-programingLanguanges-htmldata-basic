package jpa.technologies.WebAPI;

import jpa.technologies.Business.Abstracts.TechnologyService;
import jpa.technologies.Business.Request.CreateTechnologyRequest;
import jpa.technologies.Business.Request.DeleteTechnologyRequest;
import jpa.technologies.Business.Request.UpdateTechnologyRequest;
import jpa.technologies.Business.Response.GetAllTechnologiesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/techonologies")
public class TechnologyController {
    private final TechnologyService technologyService;

    @Autowired
    public TechnologyController(TechnologyService technologyService){
        this.technologyService = technologyService;
    }

    @GetMapping("/getall")
    public List<GetAllTechnologiesResponse> getAllTechnologiesResponses(){
        return technologyService.getAll();
    }
    @PostMapping("/add")
    public void add(CreateTechnologyRequest createTechnologyRequest){
        technologyService.add(createTechnologyRequest);
    }
    @DeleteMapping("/delete")
    public void delete(DeleteTechnologyRequest deleteTechnologyRequest){
        technologyService.delete(deleteTechnologyRequest);
    }
    @PutMapping("/update")
    public void update(UpdateTechnologyRequest updateTechnologyRequest){
        technologyService.update(updateTechnologyRequest);
    }
}
