package ru.inbox.savinov_vu.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import ru.inbox.savinov_vu.model.goods.ProductOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 */
public class ItextPdfView extends AbstractITextPdfView {
    static final int FONT_SIZE_SMALL = 16;
    static final int FONT_SIZE_BIG = 32;
    static final int OFFSET = 40;


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductOrder order = (ProductOrder) model.get("order");

        String FONT_LOCATION = "/Fonts/TIMCYR_TTF/TIMCYR.TTF";
        // String FONT_LOCATION = "dsfsdf/Fonts/TIMCYR_TTF/TIMCYR.TTF";


   /*     String FONT_LOCATION_BOLD = "/Fonts/TIMCYR_TTF/TIMCYRB.TTF";
        String FONT_LOCATION_ITALICS= "/Fonts/TIMCYR_TTF/TIMCYRI.TTF";
        String FONT_LOCATION_BOLD_ITALICS= "/Fonts/TIMCYR_TTF/TIMCYRBI.TTF";*/

        BaseFont timesNewRoman =
                BaseFont.createFont(
                        FONT_LOCATION,
                        BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        @SuppressWarnings("unchecked")
        //List<Course> courses = (List<Course>) model.get("courses");

       /* PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{10, 60, 30});

        table.addCell("ID");
        table.addCell("Name");
        table.addCell("Date");*/

    /*    for (Course course : courses){
            table.addCell(String.valueOf(course.getId()));
            table.addCell(course.getName());
            table.addCell(DATE_FORMAT.format(course.getDate()));
        }
*/
       // Font font1 = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0));
                Font fontBig = new Font(timesNewRoman, FONT_SIZE_BIG);
        Font fontSmall = new Font(timesNewRoman, 14);
        Font font12 = new Font(timesNewRoman, 12);
        int sizeSpacingAfter = 8;
        Font font1 = new Font(timesNewRoman,
                FONT_SIZE_BIG, Font.BOLD);
        Font font2 = new Font(timesNewRoman,
                FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);
/*order.getOrder_id()+*/


/*        document.add(table);*/

        Paragraph title = new Paragraph("order", font1);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        BarcodeEAN barcodeEAN = new BarcodeEAN();
        barcodeEAN.setCodeType(BarcodeEAN.EAN13);

        //build code for barcode- start
         String barcode ="0000000000000";
        int lengthId = String.valueOf(order.getOrder_id()).length();
        barcode = barcode.substring(0,barcode.length()-lengthId) + order.getOrder_id();
      //  build code for barcode - end
        PdfContentByte pdfContentByte = writer.getDirectContent();
        barcodeEAN.setCode(String.valueOf(barcode));
        Image codeEANImage = barcodeEAN.createImageWithBarcode(pdfContentByte, null, null);
        codeEANImage.scalePercent(100);
        codeEANImage.setAlignment(Element.ALIGN_RIGHT);
        document.add(codeEANImage);

        // параграф с текстом
        Paragraph purpose = new Paragraph("Дата оформления: " + order.getStartDate(), fontSmall);
        purpose.setSpacingAfter(sizeSpacingAfter);
        document.add(purpose);

        Paragraph customerNamePr = new Paragraph("Заказчик: " + order.getCustomerName(), fontSmall);
        customerNamePr.setSpacingAfter(sizeSpacingAfter);
        document.add(customerNamePr);

        Paragraph customerPhonePr = new Paragraph("Телефон заказчика: " + order.getCustomerPhone(), fontSmall);
        customerPhonePr.setSpacingAfter(sizeSpacingAfter);
        document.add(customerPhonePr);

        order.getProducts().forEach(product -> {
            Paragraph productList = new Paragraph(String.valueOf(product), font12);
            productList.setSpacingAfter(sizeSpacingAfter);
            try {
                document.add(productList);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });







    }



}
