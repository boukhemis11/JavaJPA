package fr.afpa.poec.dao;

import org.springframework.data.repository.CrudRepository;

import fr.afpa.poec.entity.Item;

public interface ItemRepo extends CrudRepository<Item, Long> {

}
