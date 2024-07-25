package jpa.technologies.DataAccess.Abstracts;

import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LanguageRepository extends JpaRepository<ProgrammingLanguage, Integer> {
}
