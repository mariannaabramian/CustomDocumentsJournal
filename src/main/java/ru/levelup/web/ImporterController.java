package ru.levelup.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.levelup.db.DocumentsDAO;
import ru.levelup.db.UsersDAO;
import ru.levelup.model.Group;
import ru.levelup.model.User;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//@WebServlet(urlPatterns = { "/main/importer" })
@Controller
public class ImporterController {

    @Autowired
    private DocumentsDAO documentsDAO;

    @GetMapping(path = "/main/importer")
    public String importerPage(ModelMap model) {
        ImporterForm form = new ImporterForm();

        form.setImporterName("");
        form.setInn("");
        form.setPostalCode("");
        form.setCountry("");
        form.setCity("");
        form.setStreetHouse("");
        form.setHeadFIO("");
        form.setAccountantFIO("");

        model.addAttribute("form", form);

        return "importer";
    }

    @PostMapping(path = "/main/importer")
    public String doPost(HttpSession session,
                         @RequestParam("importerName") String importerName,
                         @RequestParam("inn") String inn,
                         @RequestParam("postalCode") String postalCode,
                         @RequestParam("country") String country,
                         @RequestParam("city") String city,
                         @RequestParam("streetHouse") String streetHouse,
                         @RequestParam("headFIO") String headFIO,
                         @RequestParam("accountantFIO") String accountantFIO
                         ) {
        //documentsDAO.createImporter(name,inn,country, city, streetHouse, headFIO, "fsdfsdf");
        documentsDAO.createImporter("ООО РосИмпорт14", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");

        return "redirect:/";
    }

}


