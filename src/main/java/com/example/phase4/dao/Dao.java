package com.example.phase4.dao;

import com.example.phase4.dao.CustomerDao.CustomerDAO;
import com.example.phase4.dao.CustomerDao.CustomerDaoList;
import com.example.phase4.dao.TechnicianDao.TechnicianDAO;
import com.example.phase4.dao.TechnicianDao.TechnicianDaoList;
import com.example.phase4.dao.WorkOrderDao.WorkOrderDAO;
import com.example.phase4.dao.WorkOrderDao.WorkOrderDaoList;


public class Dao{
    public static CustomerDAO customerDao;
    public static TechnicianDAO technicianDao;
    public static WorkOrderDAO workOrderDAO;
    public static CustomerDAO componentDAO;

    public static CustomerDAO getCustomer(){
        if (customerDao == null){
            customerDao = new CustomerDaoList();
        }
        return customerDao;
    }
    public static TechnicianDAO getTechnicianDao(){
        if (technicianDao == null){
            technicianDao = new TechnicianDaoList();
        }
        return technicianDao;
    }
    public static WorkOrderDAO getworkOrderDao(){
        if (workOrderDAO == null){
            workOrderDAO = new WorkOrderDaoList();
        }
        return workOrderDAO;
    }
    public static CustomerDAO getComponentDao(){
        if (componentDAO == null){
            componentDAO = new CustomerDaoList();
        }
        return componentDAO;
    }

}
