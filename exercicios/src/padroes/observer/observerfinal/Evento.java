package padroes.observer.observerfinal;

import java.util.Date;

public class Evento {
	
	private Date data;

	public Evento(Date data) {
		this.data = data;
	}
	
	public Date getData() {
		return data;
	}
}
