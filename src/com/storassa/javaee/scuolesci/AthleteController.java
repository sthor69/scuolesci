package com.storassa.javaee.scuolesci;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class AthleteController {
	
	@EJB
	AthleteEJB athleteEjb;
	
	private Athlete athlete = new Athlete();
	private List<Athlete> athleteList = new ArrayList<Athlete>();
	
	public String doCreateAthlete() {
		athlete = athleteEjb.createAthlete(athlete);
		athleteList = athleteEjb.findAthlete();
		return "listAthlete.xhtml";
	}
	
	public String doNew() {
		return "newAthlete.xhtml";
	}

	public AthleteEJB getAthleteEjb() {
		return athleteEjb;
	}

	public void setAthleteEjb(AthleteEJB athleteEjb) {
		this.athleteEjb = athleteEjb;
	}

	public Athlete getAthlete() {
		return athlete;
	}

	public void setAthlete(Athlete athlete) {
		this.athlete = athlete;
	}

	public List<Athlete> getAthleteList() {
		return athleteList;
	}

	public void setAthleteList(List<Athlete> athleteList) {
		this.athleteList = athleteList;
	}
}
