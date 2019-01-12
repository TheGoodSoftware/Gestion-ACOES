package modelos;

import java.util.ArrayList;

public class GestionEconomica {
	private int id;
	private double balanceTotal;
	private ArrayList<Economia> economia;
	private final static double LEMPIRAS_A_EUROS = 0.036;
	
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
	
	public static double getBalanceTotal(Economia[] economias) {
		double balanceTotal = 0.0;
		
		for(int i = 0; i < economias.length; i++)
		{
			double valor = (economias[i].getMoneda().equalsIgnoreCase("LEMPIRAS")) 
					? Double.parseDouble(economias[i].getCantidad()) * LEMPIRAS_A_EUROS : Double.parseDouble(economias[i].getCantidad());
			
			if(economias[i].getTipo().equalsIgnoreCase("GASTO"))
				balanceTotal -= valor;
			else
				balanceTotal += valor;
		}
		
		return balanceTotal;
	}
	
	public Object[][] toObjectArray() {
		Object[][] valores = new Object[this.getEconomias().size()][7];
		for(int i = 0; i < this.getEconomias().size(); i++) {
			Object[] values = new Object[7];
			values[0] = this.getEconomias().get(i).getId();
			values[1] = this.getEconomias().get(i).getCantidad();
			values[2] = this.getEconomias().get(i).getMoneda();
			values[3] = this.getEconomias().get(i).getTipo();
			values[4] = this.getEconomias().get(i).getDescripcion();
			values[5] = this.getEconomias().get(i).getBeneficiarioProcedencia();
			values[6] = this.getEconomias().get(i).getFecha();
			valores[i] = values;
		}
		return valores;
	}
	
	public static Object[][] EconomiaArraytoObjectArray(Economia[] economia) {
		Object[][] valores = new Object[economia.length][7];
		for(int i = 0; i < economia.length; i++) {
			Object[] values = new Object[7];
			values[0] = economia[i].getId();
			values[1] = economia[i].getCantidad();
			values[2] = economia[i].getMoneda();
			values[3] = economia[i].getTipo();
			values[4] = economia[i].getDescripcion();
			values[5] = economia[i].getBeneficiarioProcedencia();
			values[6] = economia[i].getFecha();
			valores[i] = values;
		}
		return valores;
	}
	
	public String[] getAllFechas() {
		ArrayList<String> fechas = new ArrayList<>();
		fechas.add("-");
		
		for(int i = 0; i < economia.size(); i++)
		{
			String[] dateValues = economia.get(i).getFecha().split("/");
			String fechaTemp = dateValues[1] + "/" + dateValues[2];
			if(!fechas.contains(fechaTemp))
				fechas.add(fechaTemp);
		}
		
		return fechas.toArray(new String[fechas.size()]);
	}
}
