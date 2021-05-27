package com.opendoors.landmanagement.utils;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.util.*;

import org.xhtmlrenderer.pdf.ITextRenderer;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class PDFTemplateUtil {
    private static final String IMAGE_PATH = "file://"+PathUtil.getCurrentPath()+"/templates/images/bg.png";

    public static ByteArrayOutputStream createPDF(Map<String,Object> data, String templateFileName) throws Exception {
        // Create a FreeMarker instance, responsible for managing the Configuration instance of the FreeMarker template
        Configuration cfg = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
        // Specify the location of the FreeMarker template file 
        cfg.setClassForTemplateLoading(PDFTemplateUtil.class,"/templates");
        ITextRenderer renderer = new ITextRenderer();
        OutputStream out = new ByteArrayOutputStream();
        try {
            // Set the encoding format of the template
            cfg.setEncoding(Locale.getDefault(), "UTF-8");
            // Get the template file 
            Template template = cfg.getTemplate(templateFileName, "UTF-8");
            StringWriter writer = new StringWriter();
            
            // Output data to html
            template.process(data, writer);
            writer.flush();

            String html = writer.toString();
            // Pass the html code into the renderer
            renderer.setDocumentFromString(html);

            //Solve the relative path of the image problem ## must set the image path after setting the document, otherwise it does not work
            renderer.getSharedContext().setBaseURL(IMAGE_PATH);

            
            renderer.layout();
            
            renderer.createPDF(out, false);
            renderer.finishPDF();
            out.flush();
            return (ByteArrayOutputStream) out;
        } finally {
        	if(out != null){
        		 out.close();
        	}
        }
    }
    
}
