package ru.inbox.savinov_vu.service.goods.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import ru.inbox.savinov_vu.model.goods.ProductOrder;

import java.io.FileOutputStream;

public class PdfGeneration {
    static int FONT_SIZE_SMALL = 16;
    static int FONT_SIZE_BIG = 32;
    static int OFFSET = 40;



    public  void createPDF(ProductOrder order) throws Exception {
        Document document = new Document();

        String FONT_LOCATION = "/Fonts/TIMCYR_TTF/TIMCYR.TTF";
        String FONT_LOCATION_BOLD = "/Fonts/TIMCYR_TTF/TIMCYRB.TTF";
        String FONT_LOCATION_ITALICS= "/Fonts/TIMCYR_TTF/TIMCYRI.TTF";
        String FONT_LOCATION_BOLD_ITALICS= "/Fonts/TIMCYR_TTF/TIMCYRBI.TTF";


        BaseFont timesNewRoman =
                BaseFont.createFont(
                        FONT_LOCATION,
                        BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        Font fontBig = new Font(timesNewRoman, FONT_SIZE_BIG);
        Font fontSmall = new Font(timesNewRoman, 14);
        Font font12 = new Font(timesNewRoman, 12);
          int sizeSpacingAfter = 8;
        Font font1 = new Font(timesNewRoman,
                FONT_SIZE_BIG, Font.BOLD);
        Font font2 = new Font(timesNewRoman,
                FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);

        PdfWriter pdfWriter = PdfWriter.getInstance(document,
                new FileOutputStream(order.getOrder_id()+".pdf"));


        document.open();
        PdfContentByte pdfContentByte = pdfWriter.getDirectContent();



        BarcodeEAN barcodeEAN = new BarcodeEAN();
        barcodeEAN.setCodeType(BarcodeEAN.EAN13);

        /*функция составления кода начало*/
         String barcode ="0000000000000";
        int lengthId = String.valueOf(order.getOrder_id()).length();
        barcode = barcode.substring(0,barcode.length()-lengthId) + order.getOrder_id();
        /*функция составления кода - кончало*/

        barcodeEAN.setCode(String.valueOf(barcode));
        Image codeEANImage = barcodeEAN.createImageWithBarcode(pdfContentByte, null, null);
        codeEANImage.scalePercent(100);
        codeEANImage.setAlignment(Element.ALIGN_RIGHT);
        document.add(codeEANImage);





        // отцентрированный параграф
        Paragraph title = new Paragraph("Заказ №" + order.getOrder_id(), font1);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingAfter(FONT_SIZE_BIG);
        document.add(title);

 /*       // параграф с текстом
        Paragraph purpose = new Paragraph("Дата оформления: " + order.getStartDate(), fontSmall);
        purpose.setSpacingAfter(sizeSpacingAfter);
        document.add(purpose);

        Paragraph customerNamePr = new Paragraph("Заказчик: " + order.getCustomerName(), fontSmall);
        customerNamePr.setSpacingAfter(sizeSpacingAfter);
        document.add(customerNamePr);

        Paragraph customerPhonePr = new Paragraph("Телефон заказчика: " + order.getCustomerPhone(), fontSmall);
        customerPhonePr.setSpacingAfter(sizeSpacingAfter);
        document.add(customerPhonePr);
*/
        order.getProducts().forEach(product -> {
            Paragraph productList = new Paragraph(String.valueOf(product), font12);
            productList.setSpacingAfter(sizeSpacingAfter);
            try {
                document.add(productList);
            } catch (DocumentException e) {
                e.printStackTrace();
            }
        });



        document.close();
    }


}





