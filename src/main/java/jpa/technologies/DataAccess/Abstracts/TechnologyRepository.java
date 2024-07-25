package jpa.technologies.DataAccess.Abstracts;

import jpa.technologies.Entities.Conceretes.ProgrammingLanguage;
import jpa.technologies.Entities.Conceretes.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyRepository extends JpaRepository<Technology, Integer> {
}
