package com.workshop.bdd;

import java.util.ArrayList;
import java.util.List;

public class ContentDao {
    private DbConnector dbConnector;

    public DbConnector getDbConnector() {
        return dbConnector;
    }

    public void setDbConnector(DbConnector dbConnector) {
        this.dbConnector = dbConnector;
    }

    public ContentModel add(ContentModel data) {
        // insert data
        return null;
    }

    public List<ContentModel> getAll() {
        // query all data
        return null;
    }

    public boolean connectDb() {
        // connect db
        dbConnector.connectDb();
        return true;
    }
}
