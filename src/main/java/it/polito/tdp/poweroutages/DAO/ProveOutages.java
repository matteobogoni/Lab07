package it.polito.tdp.poweroutages.DAO;


import java.time.LocalDateTime;


public class ProveOutages {
	int id;
	int personeCoinvolte;
	LocalDateTime inizio;
	LocalDateTime fine;
	
	public ProveOutages(int id, int personeCoinvolte, LocalDateTime inizio, LocalDateTime fine) {
		super();
		this.id = id;
		this.personeCoinvolte = personeCoinvolte;
		this.inizio = inizio;
		this.fine = fine;
	}
	
	public int getId() {
		return id;
	}

	public int getPersoneCoinvolte() {
		return personeCoinvolte;
	}

	public LocalDateTime getInizio() {
		return inizio;
	}

	public LocalDateTime getFine() {
		return fine;
	}

	public Integer durataEvento (LocalDateTime inizio, LocalDateTime fine) {
		Integer ore = this.fine.getHour() - this.inizio.getHour() ;
		return ore;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProveOutages other = (ProveOutages) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
