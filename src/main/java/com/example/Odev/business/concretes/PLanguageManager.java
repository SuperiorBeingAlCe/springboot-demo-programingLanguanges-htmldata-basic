package com.example.Odev.business.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Odev.business.abstracts.PLanguageService;
import com.example.Odev.dataAccess.abstracts.PLanguangeRepository;
import com.example.Odev.entities.concretes.PLanguage;


@Service
public class PLanguageManager implements PLanguageService{

	@Autowired
	private PLanguangeRepository languageRepository;
	
	List<PLanguage> languages= new ArrayList<PLanguage>();
	
	
	public PLanguageManager(PLanguangeRepository languageRepository) {
		
		this.languageRepository = languageRepository;
	}

	@Override
	public void addLanguange(PLanguage language) {
		if (language.getName().isEmpty()) {
			throw new IllegalArgumentException("Programming Language cannot be empty");
		} else {
			List<PLanguage> existingLanguages = languageRepository.getAll();
			for (PLanguage existingLanguage : existingLanguages) {
				if (existingLanguage.getName().equalsIgnoreCase(language.getName())) {
					throw new IllegalArgumentException("Name cannot be repeated");
	}
			}}
		languageRepository.addLanguange(language);
		}
	@Override
	public PLanguage getLanguageById(String id) {
		return languageRepository.getLanguageById(id);
	}

	@Override
	public void deleteLanguange(String language) {
		languageRepository.deleteLanguange(language);
	}

	@Override
	public void updateLanguange(PLanguage language) {
		languageRepository.updateLanguange(language);
	}

	@Override
	public List<PLanguage> getAll() {
		return languageRepository.getAll();
	}

}
