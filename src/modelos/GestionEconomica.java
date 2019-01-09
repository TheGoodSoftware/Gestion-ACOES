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
}
