package utils;

import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;

import java.io.OutputStream;
import java.util.Map;

public class ReportGenerator {

    private Connection connect;

    public ReportGenerator (Connection connect){
        this.connect = connect;
    }

    public void Pdfgenerator(String jrxml, Map< String, Object> parameters, OutputStream out){

        try{
            JasperReport j = JasperCompileManager.compileReport(jrxml);

            JasperPrint p = JasperFillManager.fillReport(j, parameters, this.connect);

            JRExporter exporter = new JRPdfExporter();

            exporter.setParameter(JRExporterParameter.JASPER_PRINT, p);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);

            exporter.exportReport();
        } catch (Exception e){
            throw new RuntimeException("Error", e);
        }
    }
}
