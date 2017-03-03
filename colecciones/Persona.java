package colecciones;

import java.util.Comparator;

public class Persona implements Comparable<Persona> {
	
	protected String dni;
	protected String nom;
	protected String cognoms;
	protected int edat;
	protected String email;
	
	public Persona(String dni, String nom, String cognoms, int edat, String email) {
		super();
		this.dni = dni;
		this.nom = nom;
		this.cognoms = cognoms;
		this.edat = edat;
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getCognoms() {
		return cognoms;
	}
	public void setCognoms(String cognoms) {
		this.cognoms = cognoms;
	}
	public int getEdat() {
		return edat;
	}
	public void setEdat(int edat) {
		this.edat = edat;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	
	public String toString() {
		return "Soc " + nom + " " + cognoms + ", amb DNI=" + dni + "; tinc " + edat + " anys. Em podeu escriure a " + email;
	}

	@Override
	public int compareTo(Persona o) {
		return cognoms.compareTo(o.cognoms); 
	}
	
	// Classe interna per metode.
	public static Comparator<Persona> comparaPerEdat(){
		class CompararPerEdat implements Comparator<Persona> {
			public int compare(Persona o1, Persona o2) {
				int result = 0;
				if (o1.edat == o2.edat) {
					result = 0;
				} else if (o1.edat < o2.edat) {
					result = -1;
				} else {
					result = 1;
				}
				return result;
			}
		}
		return new CompararPerEdat();
	}
}
