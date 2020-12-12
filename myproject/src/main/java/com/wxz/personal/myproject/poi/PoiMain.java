package com.wxz.personal.myproject.poi;

import com.alibaba.fastjson.JSONObject;

public class PoiMain {

    public static void main(String[] args) throws Exception {
        Docx docx = new Docx();
        docx.write2docx();
        //docx.read2docx();

        PDF pdf = new PDF();
        pdf.write2pdf();
    }
}
