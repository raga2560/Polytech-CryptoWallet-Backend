package fr.polytech.codev.backend.services;

import fr.polytech.codev.backend.entities.Favorite;

public class FavoriteSqlDaoServices extends AbstractSqlDaoServices<Favorite> {

    @Override
    public Class<Favorite> getEntityClass() {
        return Favorite.class;
    }
}