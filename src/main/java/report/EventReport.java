package report;

import ar.com.fdvs.dj.core.DynamicJasperHelper;
import ar.com.fdvs.dj.core.layout.ClassicLayoutManager;
import ar.com.fdvs.dj.domain.DynamicReport;
import ar.com.fdvs.dj.domain.builders.FastReportBuilder;
import model.Event;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Date;

public class EventReport {
    public static void main(String[] args) throws JRException, ClassNotFoundException {

        FastReportBuilder drb = new FastReportBuilder();
        DynamicReport dr = drb
                .addColumn("Name", "name", String.class.getName(), 30)
                .addColumn("Date", "date", String.class.getName(), 30)
                .setTitle("Event")
                .setSubtitle("This report was generated at " + new Date())
                .setPrintBackgroundOnOddRows(true)
                .setUseFullPageWidth(true)
                .build();

        JRDataSource ds = new JRBeanCollectionDataSource(Event.findAll());
        JasperPrint jp = DynamicJasperHelper.generateJasperPrint(dr, new ClassicLayoutManager(), ds);
        JasperViewer.viewReport(jp);    //finally display the report report
    }
}
