package report;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import model.Period;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Date;

public class PeriodReport {
    public static void main(String[] args) throws JRException, ClassNotFoundException {

        FastReportBuilder drb = new FastReportBuilder();
        DynamicReport dr = drb
                .addColumn("Day of The Week", "dayOfTheWeek", String.class.getName(), 30)
                .addColumn("Start", "start", String.class.getName(), 30)
                .addColumn("End", "end", String.class.getName(), 30)
                .setTitle("Period")
                .setSubtitle("This report was generated at " + new Date())
                .setPrintBackgroundOnOddRows(true)
                .setUseFullPageWidth(true)
                .build();

        JRDataSource ds = new JRBeanCollectionDataSource(Period.findAll());
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
        JasperViewer.viewReport(jp);    //finally display the report report
    }
}
