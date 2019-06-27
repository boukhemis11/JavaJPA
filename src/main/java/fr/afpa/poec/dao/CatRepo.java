package fr.afpa.poec.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.poec.entity.Category;

public interface CatRepo extends CrudRepository<Category, Long> {

}
