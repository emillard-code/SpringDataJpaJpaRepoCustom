package com.project.repository;

import com.project.model.Coder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CoderRepository extends JpaRepository<Coder, Integer> {

    // Spring Data JPA is able to automatically add functionality to certain methods.
    // If you use findBy<FieldName> method format, it will return all entries with matching data.
    List<Coder> findByProgLanguage(String progLanguage);

    // Spring Data JPA also has filtering functionality to an extent.
    List<Coder> findByIdGreaterThan(int id);

    // Spring Data JPA also allows custom methods with functionality written in JPQL.
    @Query("from Coder where progLanguage=?1 order by name")
    List<Coder> findByProgLanguageSorted(String language);

}