package mx.com.gm.capadatos.domain;

import java.util.List;
import mx.com.gm.capadatos.domain.Persona;
public interface PersonDao { 
	void insertPersona(Persona persona); 
	void updatePersona(Persona persona); 
	void deletePersona(Persona persona); 
	Persona findPersonaById(long idPersona);
	List<Persona> findAllPersonas(); 
	long contadorPersonas(); 
	Persona getPersonaByEmail(Persona persona);
}
