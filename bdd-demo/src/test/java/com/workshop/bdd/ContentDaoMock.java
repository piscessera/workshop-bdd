package com.workshop.bdd;

import java.util.ArrayList;
import java.util.List;

public class ContentDaoMock extends ContentDao {
    private List<ContentModel> list;

    private void initial() {
        if (list == null) {
            list = new ArrayList<>();
        }
    }

    public ContentModel add(ContentModel data) {
        initial();
        list.add(data);
        return data;
    }

    public List<ContentModel> getAll() {
        initial();
        connectDb();
        return list;
    }
}
