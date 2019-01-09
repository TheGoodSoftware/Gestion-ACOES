package modelos;

import java.util.ArrayList;

public class GestionEconomica {
	private int id;
	private double balanceTotal;
	private ArrayList<Economia> economia;
	
	public GestionEconomica(int id) {
		this.id = id;
		economia = new ArrayList<Economia>();
	}
	
	public void setEconomia(ArrayList<Economia> economia) {
		this.economia = economia;
	}
	
	public ArrayList<Economia> getEconomias() {
		return this.economia;
	}
}
