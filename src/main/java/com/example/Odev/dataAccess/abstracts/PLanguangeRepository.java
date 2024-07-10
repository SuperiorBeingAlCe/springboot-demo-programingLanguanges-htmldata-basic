package com.example.Odev.dataAccess.abstracts;

import java.util.List;

import com.example.Odev.entities.concretes.PLanguage;

public interface PLanguangeRepository {

	public void addLanguange(PLanguage language);
	public PLanguage getLanguageById(String id);
	public void deleteLanguange(String language);
	public void updateLanguange(PLanguage language);
	List<PLanguage> getAll();
	
}
