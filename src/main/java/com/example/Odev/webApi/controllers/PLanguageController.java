package com.example.Odev.webApi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Odev.business.abstracts.PLanguageService;
import com.example.Odev.entities.concretes.PLanguage;

@RestController
@RequestMapping("api/languages")
public class PLanguageController {

	private PLanguageService languageService;

	
	
	@Autowired
	public PLanguageController(PLanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/getall")
	public List<PLanguage> getAll(){
		return languageService.getAll();
	}
	@PostMapping("/add")
	public void add(@RequestBody PLanguage language) {
		languageService.addLanguange(language);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestParam String id) {
		languageService.deleteLanguange(id);
	}

	@PutMapping("/update")
	public void update(@RequestBody PLanguage language) {
		languageService.updateLanguange(language);
	}

	@GetMapping("/get")
	public PLanguage get(@RequestParam String id) {
		return languageService.getLanguageById(id);
	}
}
