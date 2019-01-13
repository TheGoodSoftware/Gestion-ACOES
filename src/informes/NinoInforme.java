
package informes;

import modelos.*;
import java.io.*;
import java.util.*;

import com.pdfjet.*;

public class  NinoInforme  {

    public NinoInforme(Nino n, String proy) throws Exception {

        FileOutputStream fos = new FileOutputStream("impresos/" + n.getID() + "_"+n.getNombre().toUpperCase()+"_"+n.getApellidos().toUpperCase()+ "_FICHA.pdf");
        System.out.println("Nuevo informe generado en la ruta -> impresos/" + n.getID() + "_"+n.getNombre().toUpperCase()+"_"+n.getApellidos().toUpperCase()+ "_FICHA.pdf");

        PDF pdf = new PDF(fos);
        Page page = new Page(pdf, Letter.PORTRAIT);

        Font c1 = new Font(pdf, CoreFont.HELVETICA_BOLD);
        c1.setSize(7.0f);

        Font c2 = new Font(pdf, CoreFont.HELVETICA);
        c2.setSize(7.0f);
        
        
        Table table = new Table();
        List<List<Cell>> tableData = getData(
        		n,proy, c1, c2);
        table.setData(tableData, Table.DATA_HAS_0_HEADER_ROWS);
        table.setPosition(70.0f, 50.0f);  
        table.autoAdjustColumnWidths();
        table.setColumnWidth(0, 120.0f);
        int numOfPages = table.getNumberOfPages(page);
        while (true) {
            Point point = table.drawOn(page);
            if (!table.hasMoreData()) {
                table.resetRenderedPagesCount();
                break;
            }
            page = new Page(pdf, Letter.PORTRAIT);
        }
        
        pdf.flush();
        fos.close();
    }
    
    
    public List<List<Cell>> getData(
    		Nino n,
            String proy, Font c1,
            Font c2) throws Exception {
    	
    	/* ADDING TITLES */
        List<List<Cell>> tableData = new ArrayList<List<Cell>>();
        //List<Cell> tableHeader = new ArrayList<Cell>();
        String[] titles = {"ID","Nombre", "Apellidos", "NIF", "Dirección", "Población", "Sexo", "Proyecto", "Fecha alta", "Fecha alta ACOES", "Fecha salida ACOES", "Fecha alta proyecto", "Fecha salida proyecto", "Observaciones"};
       
       
        
        /* ADDING DATA */
        List<Cell> tableRow= new ArrayList<Cell>();
        tableRow.add(new Cell(c1, titles[0]));
        tableRow.add(new Cell(c2, Integer.toString(n.getID())));
        tableData.add(tableRow);
        
        List<Cell> tableRow1= new ArrayList<Cell>();
        tableRow1.add(new Cell(c1, titles[1]));
        tableRow1.add(new Cell(c2, n.getNombre()));
        tableData.add(tableRow1);
        
        List<Cell> tableRow2= new ArrayList<Cell>();
        tableRow2.add(new Cell(c1, titles[2]));
        tableRow2.add(new Cell(c2, n.getApellidos()));
        tableData.add(tableRow2);
        
        List<Cell> tableRow3= new ArrayList<Cell>();
        tableRow3.add(new Cell(c1, titles[3]));
        tableRow3.add(new Cell(c2, n.getNIF()));
        tableData.add(tableRow3);
        
        List<Cell> tableRow4= new ArrayList<Cell>();
        tableRow4.add(new Cell(c1, titles[4]));
        tableRow4.add(new Cell(c2, n.getDireccion()));
        tableData.add(tableRow4);
        
        List<Cell> tableRow5= new ArrayList<Cell>();
        tableRow5.add(new Cell(c1, titles[5]));
        tableRow5.add(new Cell(c2, n.getPueblo()));
        tableData.add(tableRow5);
        
        List<Cell> tableRow6= new ArrayList<Cell>();
        tableRow6.add(new Cell(c1, titles[6]));
        tableRow6.add(new Cell(c2, n.getSexo()));
        tableData.add(tableRow6);
        List<Cell> tableRow7= new ArrayList<Cell>();
        tableRow7.add(new Cell(c1, titles[7]));
        tableRow7.add(new Cell(c2, proy));
        tableData.add(tableRow7);
        
        List<Cell> tableRow8= new ArrayList<Cell>();
        tableRow8.add(new Cell(c1, titles[8]));
        tableRow8.add(new Cell(c2, n.getFechaAlta()));
        tableData.add(tableRow8);
        
        List<Cell> tableRow9= new ArrayList<Cell>();
        tableRow9.add(new Cell(c1, titles[9]));
        tableRow9.add(new Cell(c2, n.getFechaAltaACOES()));
        tableData.add(tableRow9);
        
        List<Cell> tableRow10= new ArrayList<Cell>();
        tableRow10.add(new Cell(c1, titles[10]));
        tableRow10.add(new Cell(c2, n.getFechaSalidaACOES()));
        tableData.add(tableRow10);
        List<Cell> tableRow11= new ArrayList<Cell>();
        tableRow11.add(new Cell(c1, titles[11]));
        tableRow11.add(new Cell(c2, n.getFechaAltaProyecto()));
        tableData.add(tableRow11);
        
        List<Cell> tableRow12= new ArrayList<Cell>();
        tableRow12.add(new Cell(c1, titles[12]));
        tableRow12.add(new Cell(c2, n.getFechaSalidaProyecto()));
        tableData.add(tableRow12);
        
        List<Cell> tableRow13= new ArrayList<Cell>();
        tableRow13.add(new Cell(c1, titles[13]));
        tableRow13.add(new Cell(c2, n.getObservaciones()));
        tableData.add(tableRow13);
        
  

        return tableData;
    }
    

} 