package jpa.technologies.WebAPI;

import jpa.technologies.Business.Abstracts.LanguageService;
import jpa.technologies.Business.Request.CreateLanguageRequest;
import jpa.technologies.Business.Request.DeleteLanguageRequest;
import jpa.technologies.Business.Request.GetLanguageById;
import jpa.technologies.Business.Request.UpdateLanguageRequest;
import jpa.technologies.Business.Response.GetAllLanguagesResponse;
import jpa.technologies.Business.Response.GetTechnologiesByLanguageResponse;
import jpa.technologies.Business.Response.LanguageResponse;
import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/languages")
public class LanguagesController {
    private final LanguageService languageService;

    @Autowired
    public LanguagesController(LanguageService languageService){this.languageService=languageService;}

    @GetMapping("/getall")
    public List<GetAllLanguagesResponse> getAll(){
        return languageService.getAllLanguages();
    }

    @GetMapping("/get-by-id")
    public LanguageResponse getLanguageById(GetLanguageById getLanguageById){
        return languageService.getLanguageById(getLanguageById);
    }

    @PostMapping("/add")
    public void add(CreateLanguageRequest createLanguageRequest){
        this.languageService.add(createLanguageRequest);
    }

    @DeleteMapping("/remove")
    public void remove(DeleteLanguageRequest deleteLanguageRequest){
        languageService.remove(deleteLanguageRequest);
    }

    @PutMapping("update")
    public void update(UpdateLanguageRequest updateLanguageRequest){
        languageService.update(updateLanguageRequest);
    }

}
