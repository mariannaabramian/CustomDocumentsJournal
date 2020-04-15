package ru.levelup.model;

public enum DocStatus {
    NEW, // новый документ
    VALIDATED, // проверен (верный формат, корректные данные)
    VALIDATION_ERROR, // ошибка проверки документа
    REGISTERED, // зарегистрирован
    REGISTRATION_REJECTED, // отказано в регистраци
    UNDER_CONSIDARATION,
    PROCESSED // документ обработан
}
