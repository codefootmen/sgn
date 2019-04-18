package reports;


import com.mysql.jdbc.Connection;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.xml.JRExpressionFactory;
import utils.ReportGenerator;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Test02")
public class Test02 extends HttpServlet {

    public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {

        ServletContext context = request.getServletContext();
        String jrxml = context.getRealPath("/reports/Test02.jrxml");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("institute", request.getParameter("institute_id"));

        Connection connect = ConnectionFactory().getConnection();

        ReportGenerator generator = new ReportGenerator(connect);

        generator.Pdfgenerator(jrxml, parameters, response.getOutputStream());

        connect.close();
    }
}
