package com.example.Odev.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Odev.dataAccess.abstracts.PLanguangeRepository;
import com.example.Odev.entities.concretes.PLanguage;

@Repository
public class InMemoryPLanguageRepository implements PLanguangeRepository{

	List<PLanguage> languages= new ArrayList<PLanguage>();
	
	public InMemoryPLanguageRepository() {
		
		languages.add(new PLanguage(1, "C#"));
		languages.add(new PLanguage(2, "Java"));
		languages.add(new PLanguage(3, "Phyton"));
		languages.add(new PLanguage(4, "C++"));
	}
	
	
	@Override
	public void addLanguange(PLanguage language) {
		
		languages.add(language);
	}

	@Override
	public void deleteLanguange(String language) {
		languages.remove(language);
		
	}

	@Override
	public void updateLanguange(PLanguage language) {
		
		int id = Integer.parseInt(language.getName());
		
		languages.set(id - 1, language);
	}

	@Override
	public List<PLanguage> getAll() {
		return languages;
	}


	@Override
	public PLanguage getLanguageById(String id) {
		int currentId = Integer.parseInt(id);
		return languages.get(currentId - 1);
	
	}

}
