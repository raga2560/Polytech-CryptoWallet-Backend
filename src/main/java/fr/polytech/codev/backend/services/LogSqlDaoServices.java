package fr.polytech.codev.backend.services;

import fr.polytech.codev.backend.entities.Log;

public class LogSqlDaoServices extends AbstractSqlDaoServices<Log> {

    @Override
    public Class<Log> getEntityClass() {
        return Log.class;
    }
}