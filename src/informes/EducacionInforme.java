package informes;

import modelos.*;
import java.io.*;
import java.util.*;

import com.pdfjet.*;

public class EducacionInforme {

    public EducacionInforme(ArrayList<Educacion> educacions) throws Exception {

        FileOutputStream fos = new FileOutputStream("impresos/" + "_INFORMEACADEMICOACOES.pdf");

        PDF pdf = new PDF(fos);
        Page page = new Page(pdf, Letter.PORTRAIT);

        Font f1 = new Font(pdf, CoreFont.HELVETICA_BOLD);
        f1.setSize(7.0f);

        Font f2 = new Font(pdf, CoreFont.HELVETICA);
        f2.setSize(7.0f);


        Table table = new Table();
        List<List<Cell>> tableData = getData(
                educacions, f1, f2);
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
            ArrayList<Educacion> educacions,
            Font f1,
            Font f2) throws Exception {

        List<List<Cell>> tableData = new ArrayList<List<Cell>>();
        List<Cell> tableHeader = new ArrayList<Cell>();

        tableHeader.add(new Cell(f1, "ID"));
        tableHeader.add(new Cell(f1, "Nombre"));
        tableHeader.add(new Cell(f1, "Apellidos"));
        tableHeader.add(new Cell(f1, "Fecha de Nacimiento"));
        tableHeader.add(new Cell(f1, "Curso"));
        tableHeader.add(new Cell(f1, "Nota Media"));
        tableHeader.add(new Cell(f1, "Observaciones"));
        tableData.add(tableHeader);

        for (int i = 0; i < educacions.size(); i++) {
            List<Cell> tableRow = new ArrayList<Cell>();
            tableRow.add(new Cell(f2, Integer.toString(educacions.get(i).getId())));
            tableRow.add(new Cell(f2, educacions.get(i).getNombre()));
            tableRow.add(new Cell(f2, educacions.get(i).getApellidos()));
            tableRow.add(new Cell(f2, educacions.get(i).getFechaNacimiento()));
            tableRow.add(new Cell(f2, educacions.get(i).getCurso()));
            tableRow.add(new Cell(f2, educacions.get(i).getNotaMedia()));
            tableRow.add(new Cell(f2, educacions.get(i).getObservaciones()));

            tableData.add(tableRow);
        }


        return tableData;
    }

}
