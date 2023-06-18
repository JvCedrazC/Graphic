package com.example.phase4.dao.ServicesDao;

import com.example.phase4.Model.Services;
import com.example.phase4.dao.CRUD;

public interface ServicesDAO extends CRUD {
    void create(Services services);
    Services findById(int id);

}
