import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet("/Time") // localhost:8080/Time
public class TimeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String location = req.getParameter("location"); // .../Time?location=*Mainland/City* (e.g. Europe/Warsaw, America/New_York)
        ZoneId zoneId = ZoneId.of(location);
        String[] city = location.split("/");
        LocalDateTime now = LocalDateTime.now(zoneId);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        resp.getWriter().println("Time in " + city[1] + ": " + now.format(dtf));
    }
}

