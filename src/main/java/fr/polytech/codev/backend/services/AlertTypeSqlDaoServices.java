package fr.polytech.codev.backend.services;

import fr.polytech.codev.backend.entities.AlertType;

public class AlertTypeSqlDaoServices extends AbstractSqlDaoServices<AlertType> {

    @Override
    public Class<AlertType> getEntityClass() {
        return AlertType.class;
    }
}