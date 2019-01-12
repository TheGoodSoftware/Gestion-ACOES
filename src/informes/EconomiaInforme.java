package informes;

import modelos.*;
import java.io.*;
import java.util.*;

import com.pdfjet.*;

public class EconomiaInforme {

    public EconomiaInforme(ArrayList<Economia> economias, String fecha) throws Exception {

        FileOutputStream fos = new FileOutputStream("impresos/" + fecha.replace("/", "-") + "_INFORMEACOES.pdf");

        PDF pdf = new PDF(fos);
        Page page = new Page(pdf, Letter.PORTRAIT);

        Font f1 = new Font(pdf, CoreFont.HELVETICA_BOLD);
        f1.setSize(7.0f);

        Font f2 = new Font(pdf, CoreFont.HELVETICA);
        f2.setSize(7.0f);
        
        Font f3 = new Font(pdf, CoreFont.HELVETICA_BOLD_OBLIQUE);
        f3.setSize(7.0f);
        
        Table table = new Table();
        List<List<Cell>> tableData = getData(
        		economias, f1, f2, f3);
        table.setData(tableData, Table.DATA_HAS_1_HEADER_ROWS);
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
    		ArrayList<Economia> economias,
            Font f1,
            Font f2, Font f3) throws Exception {

        List<List<Cell>> tableData = new ArrayList<List<Cell>>();
        List<Cell> tableHeader = new ArrayList<Cell>();
        
        tableHeader.add(new Cell(f1, "Id"));
        tableHeader.add(new Cell(f1, "Cantidad"));
        tableHeader.add(new Cell(f1, "Moneda"));
        tableHeader.add(new Cell(f1, "Tipo"));
        tableHeader.add(new Cell(f1, "Concepto"));
        tableHeader.add(new Cell(f1, "Procedencia/Beneficiario"));
        tableHeader.add(new Cell(f1, "Fecha"));
        tableData.add(tableHeader);
        
        for (int i = 0; i < economias.size(); i++) {
    		List<Cell> tableRow = new ArrayList<Cell>();
            tableRow.add(new Cell(f2, Integer.toString(economias.get(i).getId())));
            tableRow.add(new Cell(f2, economias.get(i).getCantidad()));
            tableRow.add(new Cell(f2, economias.get(i).getMoneda()));
            tableRow.add(new Cell(f2, economias.get(i).getTipo()));
            tableRow.add(new Cell(f2, economias.get(i).getDescripcion()));
            tableRow.add(new Cell(f2, economias.get(i).getBeneficiarioProcedencia()));
            tableRow.add(new Cell(f2, economias.get(i).getFecha()));
            
            tableData.add(tableRow);
        }
        
        List<Cell> balanceTotal = new ArrayList<Cell>();
        balanceTotal.add(new Cell(f3, "Balance Total"));
        balanceTotal.add(new Cell(f3, Double.toString(GestionEconomica.getBalanceTotal(economias.toArray(new Economia[economias.size()])))));
        
        tableData.add(balanceTotal);
        
        appendMissingCells(tableData, f2);
        
        return tableData;
    }
    

    private void appendMissingCells(List<List<Cell>> tableData, Font f2) {
        List<Cell> firstRow = tableData.get(0);
        int numOfColumns = firstRow.size();
        for (int i = 0; i < tableData.size(); i++) {
            List<Cell> dataRow = tableData.get(i);
            int dataRowColumns = dataRow.size();
            if (dataRowColumns < numOfColumns) {
                for (int j = 0; j < (numOfColumns - dataRowColumns); j++) {
                    dataRow.add(new Cell(f2));
                }
                dataRow.get(dataRowColumns - 1).setColSpan((numOfColumns - dataRowColumns) + 1);
            }
        }
    }
} 