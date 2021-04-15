package com.marisa.sportsAPI.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.marisa.sportsAPI.models.Sport;
import com.marisa.sportsAPI.models.Team;
import com.marisa.sportsAPI.repositories.SportRepository;
import com.marisa.sportsAPI.repositories.TeamRepository;

@Service
public class SportsAPIService {

	private SportRepository sportRepo;
	private TeamRepository teamRepo;
	
	public SportsAPIService(SportRepository sportRepo, TeamRepository teamRepo) {
		this.sportRepo = sportRepo;
		this.teamRepo = teamRepo;
	}
	
	public Sport create(Sport toCreate) {
		return sportRepo.save(toCreate);
	}
	
	public Team create(Team toCreate) {
		return teamRepo.save(toCreate);
	}
	
	public List<Team> getAllTeams() {
		return (List<Team>) teamRepo.findAll();
	}
	
	public List<Sport> getAllSports() {
		return (List<Sport>) sportRepo.findAll();
	}
	
}
