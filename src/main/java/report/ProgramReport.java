package report;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import model.Program;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Date;

public class ProgramReport {
    public static void main(String[] args) throws JRException, ClassNotFoundException {

        FastReportBuilder drb = new FastReportBuilder();
        DynamicReport dr = drb
                .addColumn("Name", "name", String.class.getName(), 30)
                .addColumn("Academic Level", "academicLevel", Integer.class.getName(), 30)
                .setTitle("Program")
                .setSubtitle("This report was generated at " + new Date())
                .setPrintBackgroundOnOddRows(true)
                .setUseFullPageWidth(true)
                .build();

        JRDataSource ds = new JRBeanCollectionDataSource(Program.findAll());
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
        JasperViewer.viewReport(jp);    //finally display the report report
    }
}
