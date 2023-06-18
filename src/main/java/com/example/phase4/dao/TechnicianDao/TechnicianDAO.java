package com.example.phase4.dao.TechnicianDao;

import com.example.phase4.Model.Technician;
import com.example.phase4.dao.CRUD;

public interface TechnicianDAO extends CRUD<Technician> {
    public Technician create(Technician technician);
    public Technician findByName(String name);
}
