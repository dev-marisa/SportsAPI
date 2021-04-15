package com.marisa.sportsAPI.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="sports")
public class Sport {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Sport name cannot be blank")
	private String name;
	
	@Min(value=1, message="Sport must have at least one player")
	private Integer requiredPlayers;
	
	@OneToMany(mappedBy="sport", fetch = FetchType.LAZY)
    private List<Team> teams;
	
	public Sport() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRequiredPlayers() {
		return requiredPlayers;
	}

	public void setRequiredPlayers(Integer requiredPlayers) {
		this.requiredPlayers = requiredPlayers;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}
	
	
	
}
