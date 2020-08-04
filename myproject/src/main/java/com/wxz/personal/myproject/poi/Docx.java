package com.wxz.personal.myproject.poi;

import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.*;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.*;

import java.io.*;
import java.math.BigInteger;
import java.util.List;

public class Docx {

    public void write2docx() throws Exception {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream fos = new FileOutputStream(new File("E:\\write-test.docx"));
        /**
         * createParagraph：创建XWPFParagraph对象，在word文档里创建一个段落。
         * */
        XWPFParagraph titleParagraph = document.createParagraph();

        /**
         * setAlignment:设置对齐方式
         * */
        //设置段落居中
        titleParagraph.setAlignment(ParagraphAlignment.CENTER);

        /**
         * XWPFRun：表示具有相同属性的一段文本，一个段落可以由多个XWPFRun组成
         * */
        XWPFRun titleParagraphRun = titleParagraph.createRun();
        //设置内容，默认字体大小是五号
        titleParagraphRun.setText("Java PoI2");
        //设置字体颜色。16进制方式,如：#000000，但需要把#去掉
        titleParagraphRun.setColor("000000");
        //设置字体大小
        titleParagraphRun.setFontSize(20);

        XWPFRun titleParagraphRun2 = titleParagraph.createRun();
        //设置内容，默认字体大小是五号
        titleParagraphRun2.setText("蓝色20号字体加粗斜体");
        //设置字体颜色。16进制方式,如：#000000，但需要把#去掉
        titleParagraphRun2.setColor("0000ff");
        //设置字体大小
        titleParagraphRun2.setFontSize(20);
        //加粗
        titleParagraphRun2.setBold(true);
        //斜体
        titleParagraphRun2.setItalic(true);


        //段落
        XWPFParagraph firstParagraph = document.createParagraph();
        XWPFRun run = firstParagraph.createRun();
        run.setText("Java POI 生成word文件。");
        run.setColor("696969");
        run.setFontSize(16);

        //设置段落背景颜色
        CTShd cTShd = run.getCTR().addNewRPr().addNewShd();
        cTShd.setVal(STShd.CLEAR);
        cTShd.setFill("97FFFF");


        //换行
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun paragraphRun1 = paragraph1.createRun();
        paragraphRun1.setText("\r");

        //基本信息表格
        /**
         * 创建一个空表格，会默认有一行，行的宽度是0
         * */
        XWPFTable infoTable = document.createTable();
        //去表格边框
        //infoTable.getCTTbl().getTblPr().unsetTblBorders();

        //列宽自动分割
        /**
         * addNewTblPr：创建表格属性对象
         * addNewTblW：创建表格宽度对象
         * */
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        //设置表格宽度样式
        infoTableWidth.setType(STTblWidth.DXA);
        //设置表格宽度
        infoTableWidth.setW(BigInteger.valueOf(9072));

        //表格第一行
        /**
         * getRow()：通过下标获取表格中的行
         * XWPFTableRow.getCell()：通过下标获取行中的单元格
         * XWPFTableRow.addNewTableCell()：在行中创建新的单元格
         * */
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("职位");
        infoTableRowOne.addNewTableCell().setText(": Java 开发工程师");

        //表格第二行
        /**
         * createRow():创建新的行
         * */
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        infoTableRowTwo.getCell(0).setText("姓名");
        infoTableRowTwo.getCell(1).setText(": seawater");

        //表格第三行
        XWPFTableRow infoTableRowThree = infoTable.createRow();
        infoTableRowThree.getCell(0).setText("生日");
        infoTableRowThree.getCell(1).setText(": xxx-xx-xx");

        //表格第四行
        XWPFTableRow infoTableRowFour = infoTable.createRow();
        infoTableRowFour.getCell(0).setText("性别");
        infoTableRowFour.getCell(1).setText(": 男");

        //表格第五行
        XWPFTableRow infoTableRowFive = infoTable.createRow();
        infoTableRowFive.getCell(0).setText("现居地");
        infoTableRowFive.getCell(1).setText(": xx");


        CTSectPr sectPr = document.getDocument().getBody().addNewSectPr();
        XWPFHeaderFooterPolicy policy = new XWPFHeaderFooterPolicy(document, sectPr);

        //添加页眉
        CTP ctpHeader = CTP.Factory.newInstance();
        CTR ctrHeader = ctpHeader.addNewR();
        CTText ctHeader = ctrHeader.addNewT();
        String headerText = "ctpHeader";
        ctHeader.setStringValue(headerText);
        XWPFParagraph headerParagraph = new XWPFParagraph(ctpHeader, document);
        //设置为右对齐
        headerParagraph.setAlignment(ParagraphAlignment.RIGHT);
        XWPFParagraph[] parsHeader = new XWPFParagraph[1];
        parsHeader[0] = headerParagraph;
        policy.createHeader(XWPFHeaderFooterPolicy.DEFAULT, parsHeader);


        //添加页脚
        CTP ctpFooter = CTP.Factory.newInstance();
        CTR ctrFooter = ctpFooter.addNewR();
        CTText ctFooter = ctrFooter.addNewT();
        String footerText = "ctpFooter";
        ctFooter.setStringValue(footerText);
        XWPFParagraph footerParagraph = new XWPFParagraph(ctpFooter, document);
        headerParagraph.setAlignment(ParagraphAlignment.CENTER);
        XWPFParagraph[] parsFooter = new XWPFParagraph[1];
        parsFooter[0] = footerParagraph;
        policy.createFooter(XWPFHeaderFooterPolicy.DEFAULT, parsFooter);

        document.write(fos);
        fos.close();
    }

    public void read2docx() throws Exception {
        String file = "E:\\write-test.docx";
        FileInputStream fis = new FileInputStream(new File(file));
        XWPFDocument document = new XWPFDocument(fis);
        /**
         * 获取段落数，通过\r\n方式的换行不计算在之内。
         * */
        List<XWPFParagraph> paragraphList = document.getParagraphs();
        System.out.println("段落数：" + paragraphList.size());
        //读取段落
        for (XWPFParagraph paragraph : paragraphList) {
            String text = paragraph.getText();
            System.out.println("段落内容:" + text);
            List<XWPFRun> runList = paragraph.getRuns();
            System.out.println("runListSize:" + runList.size());
            for (XWPFRun run : runList) {
                System.out.println("run内容:" + run.text());
            }

        }
        //读取表格
        List<XWPFTable> tableList = document.getTables();
        System.out.println("表格数:" + tableList.size());
        for (XWPFTable table : tableList) {
            int rows = table.getNumberOfRows();
            System.out.println("表格行数:" + rows);
            for (int i = 0; i < rows; i++) {
                XWPFTableRow tableRow = table.getRow(i);
                List<XWPFTableCell> tableCellList = tableRow.getTableCells();
                System.out.println("第" + i + "行的列数:" + tableCellList.size());
                for (XWPFTableCell tableCell : tableCellList) {
                    String text = tableCell.getText();
                    System.out.println("列内容:" + text);
                }
            }
        }
    }

    public void mergeCellTest() throws Exception {
        XWPFDocument document = new XWPFDocument();
        FileOutputStream fos = new FileOutputStream(new File("E:\\abc.docx"));

        //基本信息表格
        /**
         * 创建一个空表格，会默认有一行，行的宽度是0
         * */
        XWPFTable infoTable = document.createTable();

        //列宽自动分割
        /**
         * addNewTblPr：创建表格属性对象
         * addNewTblW：创建表格宽度对象
         * */
        CTTblWidth infoTableWidth = infoTable.getCTTbl().addNewTblPr().addNewTblW();
        //设置表格宽度样式
        infoTableWidth.setType(STTblWidth.PCT);
        //设置表格宽度
        infoTableWidth.setW(BigInteger.valueOf(9000));
        //定义五列
        XWPFTableRow infoTableRowOne = infoTable.getRow(0);
        infoTableRowOne.getCell(0).setText("第一列");
        infoTableRowOne.addNewTableCell().setText("第二列hhh");
        infoTableRowOne.addNewTableCell().setText("第三列efefeeee");
        infoTableRowOne.addNewTableCell().setText("四");
        infoTableRowOne.addNewTableCell().setText("");

        //表格第二行
        XWPFTableRow infoTableRowTwo = infoTable.createRow();
        //表格第三行
        XWPFTableRow infoTableRowThree = infoTable.createRow();
        //表格第si行
        XWPFTableRow infoTableRowFour = infoTable.createRow();
        //跨行合并
        //mergeCellsVertically(infoTable,0,2,0);
        //跨列合并
        //mergeCellsHorizontal(infoTable,1,1,4);
        document.write(fos);
        fos.close();
    }

    /**
     * 跨行合并
     * fromRow：从哪一行开始
     * toRow:到哪一行结束
     * col:指定列
     */
    public void mergeCellsVertically(XWPFTable table, int fromRow, int toRow, int col) throws Exception {
        for (int rowIndex = fromRow; rowIndex <= toRow; rowIndex++) {
            XWPFTableCell cell = table.getRow(rowIndex).getCell(col);
            if (rowIndex == fromRow) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewVMerge().setVal(STMerge.CONTINUE);
            }
        }
    }

    /**
     * 跨列合并
     * row：指定行
     * fromCell:从哪一列开始
     * toCell;到那一列结束
     */
    public void mergeCellsHorizontal(XWPFTable table, int row, int fromCell, int toCell) {
        for (int cellIndex = fromCell; cellIndex <= toCell; cellIndex++) {
            XWPFTableCell cell = table.getRow(row).getCell(cellIndex);
            if (cellIndex == fromCell) {
                // The first merged cell is set with RESTART merge value
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.RESTART);
            } else {
                // Cells which join (merge) the first one, are set with CONTINUE
                cell.getCTTc().addNewTcPr().addNewHMerge().setVal(STMerge.CONTINUE);
            }
        }
    }
}
