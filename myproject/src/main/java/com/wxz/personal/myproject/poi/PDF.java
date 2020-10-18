package com.wxz.personal.myproject.poi;



import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.sun.prism.paint.Color;

import java.io.FileOutputStream;
import java.io.IOException;

public class PDF {

    //图片资源地址
    private String a = "https://p0.ssl.qhimgs1.com/sdr/400__/t0136a2e166995f393e.jpg";
    private String b = "https://img.gzhuibei.com/d/file/2020/07/24/b6c4ac6b58124d7ac70344ea4992ab5d.jpg";

    private String[] urls=new String[]{"https://p0.ssl.qhimgs1.com/sdr/400__/t0136a2e166995f393e.jpg",
    "https://img.gzhuibei.com/d/file/2020/07/24/b6c4ac6b58124d7ac70344ea4992ab5d.jpg"};

    private BaseFont bfChinese;

    public void write2pdf(){
        try {
            bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font FontChinese = new Font(bfChinese, 12, Font.NORMAL);
            Rectangle rectPageSize = new Rectangle(PageSize.A4);
            //下面代码设置页面横置
            //rectPageSize = rectPageSize.rotate();

            // 第一步，创建document对象
            //创建document对象并指定边距
            Document doc = new Document(rectPageSize,50,50,50,50);
            Document document = new Document();

            // 第二步,将Document实例和文件输出流用PdfWriter类绑定在一起
            //从而完成向Document写，即写入PDF文档
            PdfWriter.getInstance(document,new FileOutputStream("E:\\HelloWorld.pdf"));
            //第3步,打开文档
            document.open();
            //向文档添加文字. 文档由段组成
            document.add(new Paragraph("Hello World"));

            Paragraph par = new Paragraph("世界你好",FontChinese);
            document.add(par);

            //添加图片
            for(String url:urls){
                Image image = Image.getInstance(url);
                //图片宽度
                float w = image.getWidth();
                //图片高度
                float h = image.getHeight();
                System.out.println("----"+w+",,"+h);
                image.setAlignment(Element.ALIGN_CENTER);
                image.scaleAbsolute(100, 100);//重新设置宽高
                document.add(image);
            }

            //创建表格
            PdfPTable table = new PdfPTable(3);
            for(int i=0;i<13;i++)
            {
                if (i == 0)
                {
                    PdfPCell cell = new PdfPCell();
                    //合并单元格
                    cell.setColspan(3);
                    cell.setBackgroundColor(BaseColor.BLUE);
                    cell.addElement(new Paragraph("表格头" , FontChinese));
                    table.addCell(cell);
                }
                else
                {
                    /**
                     * 最后一行创建的单元格必须达到设置的列数，否则最后一行不显示(这是个问题)
                     * */
                    PdfPCell cell = new PdfPCell();
                    cell.addElement(new Paragraph("表格内容"+i , FontChinese));
                    table.addCell(cell);
                }
            }
            document.add(table);

            //关闭document
            document.close();
        }  catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

}
