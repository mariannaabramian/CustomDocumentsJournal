package ru.levelup.db;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.levelup.model.*;
import ru.levelup.tests.TestConfiguration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfiguration.class)
public class DocumentsDAOTest {
    //private EntityManagerFactory factory;
    //private EntityManager manager;


    @Autowired
    @Qualifier("defaultManager")
    private EntityManager manager;

    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private DocumentsDAO documentsDAO;

    /*@Before
    public void connect() {
        factory = Persistence.createEntityManagerFactory("TestPersistenceUnit");
        manager = factory.createEntityManager();
        documentsDAO = new DocumentsDAO(manager);
        usersDAO = new UsersDAO(manager);
    }

    @After
    public void close() {
        if (manager != null) {
            manager.close();
        }
        if (factory != null) {
            factory.close();
        }
    }*/


    @Test
    public void createImporter() {
        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт1", "1234567890", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");

    }

    @Test
    public void findImporter() {
        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт2", "1230000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");

        Importer foundimporter = new Importer();
        foundimporter = documentsDAO.findImporterByName(importer.getImporterName());

    }

   @Test
    public void createNumberOfImporters() {
        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт1", "1234567890", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        importer = documentsDAO.createImporter("ООО РосИмпорт2", "2345678901", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        importer = documentsDAO.createImporter("ООО РосИмпорт3", "3456789012", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
    }

    @Test
    public void createDuplicateImporter() {
        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт1", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
        importer = documentsDAO.createImporter("ООО РосИмпорт1", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");
    }



    @Test
    public void createDocument(){
        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт1", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");

        Document document = new Document();
        document = documentsDAO.createDocument(importer, DocType.APPLICATION, "Заявленипе на приобретение акцизных марок",
                "109200/20190405/345");

    }

    @Test
    public void findDocumentByNumber(){
        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт1", "1234000000", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");

        Document document = new Document();
        document = documentsDAO.createDocument(importer, DocType.APPLICATION, "Заявленипе на приобретение акцизных марок",
                "109200/20190405/345");

        Document foundDocument = new Document();
        foundDocument = documentsDAO.findDocumentByNumber(document.getImporterDocumentNumber());
    }

    @Test
    public void setNewDocumentStatus() {
        Group group = new Group();
        group = usersDAO.createGroup("Инспектор");

        User inspector = new User();
        inspector = usersDAO.createUser("ID_134_Ivanov_I_I","123", new Color(1, 2, 3), group);

        Importer importer = new Importer();
        importer = documentsDAO.createImporter("ООО РосИмпорт108", "1234000800", "Россия",
                "Санкт-Петербург", "1-ая Советскяа улица д. 5", "Иванов Иван Иванович",
                "Петрова Ларисса Ивановна");

        Document document = new Document();
        document = documentsDAO.createDocument(importer, DocType.APPLICATION, "Заявленипе на приобретение акцизных марок",
                "109200/20190405/345");

        Journal journal = new Journal();
        journal = documentsDAO.setNewDocumentStatus(document, inspector); // новый документ

        journal = documentsDAO.setValidatedDocumentStatus(document.getImporterDocumentNumber(), inspector); // успешно проверен
    }


}
