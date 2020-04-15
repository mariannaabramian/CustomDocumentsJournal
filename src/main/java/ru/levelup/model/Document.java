package ru.levelup.model;

import javax.persistence.*;

// Документ. Содержит инфу по  документу
// и ссылку на внутренние данные каждого типа документа
@Entity
public class Document {
    @Id
    @GeneratedValue
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private DocType docType; // тип документа: Заявление, Отчет

    @Column(nullable = false, length = 300)
    private String title; // название документа

    @Column(nullable = true, length = 50)
    private String importerDocumentNumber; // внутренний номер документа в системе Импортера

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Importer importer; // импортер

    //@OneToOne
    //private PaymentApplication paymentApplication ; // Заявление об оплате ..., если другой тип документа то NULL

    //@OneToOne
    //private QauntityReport quantityReport; // Отчет об объемах ..., если другой тип документа то NULL

    @Column(nullable = true)
    private String registrationNumber;

    @Column(nullable = true)
    private boolean processedFlag; // флаг того что правильный  зарегистрированный документ обработан, т.е.
                                   // выполнены необходимые действия
                                   // например, отправлено уведомление импортеру об обработке Заявления
                                   // или посчитан коэффициент по Отчету

    //@Column(nullable = false)
    //private String CurrentDocStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DocType getDocType() {
        return docType;
    }

    public void setDocType(DocType docType) {
        this.docType = docType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImporterDocumentNumber() {
        return importerDocumentNumber;
    }

    public void setImporterDocumentNumber(String importerDocumentNumber) {
        this.importerDocumentNumber = importerDocumentNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public boolean isProcessedFlag() {
        return processedFlag;
    }

    public void setProcessedFlag(boolean processedFlag) {
        this.processedFlag = processedFlag;
    }

    public Importer getImporter() {
        return importer;
    }

    public void setImporter(Importer importer) {
        this.importer = importer;
    }
}
