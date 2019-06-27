package fr.afpa.poec.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.poec.entity.Image;

public interface ImageRepo extends CrudRepository<Image, Long> {

}
