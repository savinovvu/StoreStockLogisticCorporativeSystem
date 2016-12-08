package ru.inbox.savinov_vu.util.pdf;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import ru.inbox.savinov_vu.model.goods.Product;
import ru.inbox.savinov_vu.model.goods.ProductOrder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;


/**
 * This view class generates a PDF document 'on the fly' based on the data
 * contained in the model.
 */
public class ItextPdfView extends AbstractITextPdfView {
    static final int FONT_SIZE_SMALL = 16;
    static final int FONT_SIZE_BIG = 32;
    static final int OFFSET = 40;
    static final String FONT_LOCATION = "/Fonts/TIMCYR_TTF/TIMCYR.TTF";

    final BaseFont timesNewRoman =
            BaseFont.createFont(
                    FONT_LOCATION,
                    BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

    final Font fontBig = new Font(timesNewRoman, FONT_SIZE_BIG);
    final Font fontSmall = new Font(timesNewRoman, 14);
    final Font font12 = new Font(timesNewRoman, 12);
    final Font font8 = new Font(timesNewRoman, 8);

    final int sizeSpacingAfter = 8;
    final Font font1 = new Font(timesNewRoman,
            FONT_SIZE_BIG, Font.BOLD);
    final Font font2 = new Font(timesNewRoman,
            FONT_SIZE_SMALL, Font.ITALIC | Font.UNDERLINE);

    public ItextPdfView() throws IOException, DocumentException {
    }


    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer, HttpServletRequest request, HttpServletResponse response) throws Exception {
        ProductOrder order = (ProductOrder) model.get("order");

        // Font font1 = FontFactory.getFont(FontFactory.COURIER, 14, Font.BOLD,	new CMYKColor(0, 255, 0, 0));


        Paragraph title = new Paragraph("Заказ №"+ order.getOrder_id(), font1);
        title.setAlignment(Element.ALIGN_CENTER);
        document.add(title);


        BarcodeEAN barcodeEAN = new BarcodeEAN();
        barcodeEAN.setCodeType(BarcodeEAN.EAN13);

        //build code for barcode- start
        String barcode = "0000000000000";
        int lengthId = String.valueOf(order.getOrder_id()).length();
        barcode = barcode.substring(0, barcode.length() - lengthId) + order.getOrder_id();
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


        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{30, 60, 30, 30});


        table.addCell(getNormalCell("Артикул",10));
        table.addCell(getNormalCell("Наименование",60));
        table.addCell(getNormalCell("Кол-во",30));
        table.addCell(getNormalCell("Предоплата",30));

        List<Product> products = order.getProducts();

        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());
        System.out.println(products.size());


        for (Product product : products) {
            table.addCell(getNormalCell(String.valueOf(product.getVendorCode()),10));
            table.addCell(getNormalCell(product.getProduct_name(),60));
            table.addCell(getNormalCell(String.valueOf(product.getCountProducts()),30));
            table.addCell(getNormalCell(String.valueOf(product.getPrepayment()), 30));
        }

    

        document.add(table);


        Paragraph comment = new Paragraph("Примечание: " + order.getOrderComment(), fontSmall);
        customerPhonePr.setSpacingAfter(sizeSpacingAfter);
        document.add(comment);


    }

    private PdfPCell getNormalCell(String string,  float size)
            throws DocumentException, IOException {
        if (string != null && "".equals(string)) {
            return new PdfPCell();
        }
        Font f = font12;
        if (size < 0) {
            f.setColor(BaseColor.RED);
            size = -size;
        }
       /* f.setSize(size);*/
        PdfPCell cell = new PdfPCell(new Phrase(string, f));
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell.setVerticalAlignment(Element.ALIGN_CENTER);
        return cell;
    }


}
