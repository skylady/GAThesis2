package ga.thesis.textwriter;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.FontSelector;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import ga.thesis.utils.Utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TableExample {

    public static File fontFile = new File("./src/main/resources/arialuni.ttf");

//    public static HashMap<Integer, ArrayList<Integer>> representPeriods() {
//        HashMap<Integer, ArrayList<Integer>> map;
//        map = new HashMap<Integer, ArrayList<Integer>>();
//        int i = 10;
//        for (int j = 1; j < 6; j++) {
//            for (int k = 0; k < 6; k++) {
//                ArrayList<Integer> columnRow = new ArrayList<Integer>();
//
//                columnRow.add(j);
//                columnRow.add(k);
//                map.put(i, columnRow);
//                i++;
//
//            }
//        }
//        return map;
//    }

    public static void main(String[] args) {
//        Document document = new Document();
//
//        try {
//            BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), "cp1251", BaseFont.EMBEDDED);
//
//            FontSelector fs = new FontSelector();
//            fs.addFont(new Font(unicode));
//
//            PdfWriter.getInstance(document,
//                    new FileOutputStream("Timetable.pdf"));
//
//            document.open();
//            Font f = new Font(unicode, 9);
//
//            Paragraph course = new Paragraph("ІУСТ-2", f);
//            course.setAlignment(Element.ALIGN_CENTER);
//            document.add(course);
//            Paragraph space = new Paragraph("  ", f);
//            document.add(space);
//
//            PdfPTable table = new PdfPTable(6); // 3 column
//
//            PdfPCell cell0 = new PdfPCell(new Paragraph("", f));
//            PdfPCell cell1 = new PdfPCell(new Paragraph("Понеділок", f));
//            PdfPCell cell2 = new PdfPCell(new Paragraph("Вівторок", f));
//            PdfPCell cell3 = new PdfPCell(new Paragraph("Середа", f));
//            PdfPCell cell4 = new PdfPCell(new Paragraph("Четвер", f));
//            PdfPCell cell5 = new PdfPCell(new Paragraph("П'ятниця", f));
//
//            table.addCell(cell0);
//            table.addCell(cell1);
//            table.addCell(cell2);
//            table.addCell(cell3);
//            table.addCell(cell4);
//            table.addCell(cell5);
//            document.add(table);
//
//            document.close();
//            System.out.println("OK");
//        } catch (Exception e) {
//            e.printStackTrace();
//            // System.out.println("NOK");
//        }
        ArrayList<String> m = new ArrayList<String>();
        m.add("AAA");
        m.add("MMM");
        m.add("jcjjd");
        initPdf(m);
    }

    // public static void initPdf(HashMap<String, HashMap<Integer, ArrayList<String>>> map) {

    public static void initPdf(ArrayList<String> map) {
        Document document = new Document();

        try {
            BaseFont unicode = BaseFont.createFont(fontFile.getAbsolutePath(), "cp1251", BaseFont.EMBEDDED);

            FontSelector fs = new FontSelector();
            fs.addFont(new Font(unicode));
            PdfWriter.getInstance(document,
                    new FileOutputStream("Timetable.pdf"));

            document.open();
            Font f = new Font(unicode, 9);

            //list or not list size?
            for (int m = 0; m < map.size(); m++) {
                Paragraph course = new Paragraph(map.get(m), f);
                course.setAlignment(Element.ALIGN_CENTER);
                Paragraph space = new Paragraph("  ", f);
                if (m == 0) {
                    document.add(course);
                    document.add(space);
                } else if (m > 0) {
                    document.newPage();
                    document.add(course);
                    document.add(space);
                }

                PdfPTable table = new PdfPTable(6);

                PdfPCell cell0 = new PdfPCell(new Paragraph("", f));
                PdfPCell cell1 = new PdfPCell(new Paragraph("Понеділок", f));
                PdfPCell cell2 = new PdfPCell(new Paragraph("Вівторок", f));
                PdfPCell cell3 = new PdfPCell(new Paragraph("Середа", f));
                PdfPCell cell4 = new PdfPCell(new Paragraph("Четвер", f));
                PdfPCell cell5 = new PdfPCell(new Paragraph("П'ятниця", f));

                table.addCell(cell0);
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                document.add(table);
            }

            document.close();

        } catch (Exception e)

        {
            e.printStackTrace();
        }

    }

    public static String concatString(ArrayList<String> list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i)).append(" ");
        }
        return builder.toString();
    }
}
