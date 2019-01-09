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
	
	public int getID() {
		return this.id;
	}
	
	public Object[][] toObjectArray() {
		Object[][] valores = new Object[this.getEconomias().size()][7];
		for(int i = 0; i < this.getEconomias().size(); i++) {
			Object[] values = new Object[6];
			values[0] = this.getEconomias().get(i).getId();
			values[1] = this.getEconomias().get(i).getCantidad();
			values[2] = this.getEconomias().get(i).getMoneda();
			values[3] = this.getEconomias().get(i).getTipo();
			values[4] = this.getEconomias().get(i).getDescripcion();
			values[5] = this.getEconomias().get(i).getUsuario().getNombreCompleto();
			valores[i] = values;
		}
		return valores;
	}
	
	public static Object[][] EconomiaArraytoObjectArray(Economia[] economia) {
		Object[][] valores = new Object[economia.length][6];
		for(int i = 0; i < economia.length; i++) {
			Object[] values = new Object[6];
			values[0] = economia[i].getId();
			values[1] = economia[i].getCantidad();
			values[2] = economia[i].getMoneda();
			values[3] = economia[i].getTipo();
			values[4] = economia[i].getDescripcion();
			values[5] = economia[i].getUsuario().getNombreCompleto();
			valores[i] = values;
		}
		return valores;
	}
}
