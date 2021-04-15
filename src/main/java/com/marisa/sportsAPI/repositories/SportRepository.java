package com.marisa.sportsAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marisa.sportsAPI.models.Sport;

@Repository
public interface SportRepository extends CrudRepository<Sport, Long>  {

}
