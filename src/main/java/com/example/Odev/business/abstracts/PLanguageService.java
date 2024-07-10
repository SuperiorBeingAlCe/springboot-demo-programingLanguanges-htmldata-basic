package com.example.Odev.business.abstracts;

import java.util.List;

import com.example.Odev.entities.concretes.PLanguage;

public interface PLanguageService {
	public void addLanguange(PLanguage language);
	public PLanguage getLanguageById(String id);
	public void deleteLanguange(String id);
	public void updateLanguange(PLanguage language);
	List<PLanguage> getAll();
}
