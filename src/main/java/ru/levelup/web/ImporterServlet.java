package ru.levelup.web;

import ru.levelup.db.DocumentsDAO;
import ru.levelup.db.UsersDAO;
import ru.levelup.model.User;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = { "/main/importer" })
public class ImporterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/importer.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("verifiedUserName") != null) {
            resp.sendRedirect(req.getContextPath());
            return;
        }

        String name = req.getParameter("importerName");
        String inn = req.getParameter("inn");
        String postalCode = req.getParameter("postalCode");
        String country = req.getParameter("v");
        String city = req.getParameter("city");
        String streetHouse = req.getParameter("streetHouse");
        String headFIO = req.getParameter("headFIO");
        String accountantFIO = req.getParameter("accountantFIO");

        EntityManager manager = PersistenceUtils.createManager(req.getServletContext());
        DocumentsDAO documentsDAO = new DocumentsDAO(manager);
        try {
            //documentsDAO.createImporter(name,inn,country, city, streetHouse, headFIO, "fsdfsdf");
            documentsDAO.createImporter("ООО РосИмпорт14", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        } finally {
            manager.close();
        }
    }

}


