package com.marisa.sportsAPI.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marisa.sportsAPI.models.Team;

@Repository
public interface TeamRepository extends CrudRepository<Team, Long>  {

}