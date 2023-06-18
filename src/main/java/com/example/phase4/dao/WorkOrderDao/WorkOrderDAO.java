package com.example.phase4.dao.WorkOrderDao;

import com.example.phase4.Model.Customer;
import com.example.phase4.Model.Technician;
import com.example.phase4.Model.WorkOrder;
import com.example.phase4.dao.CRUD;

public interface WorkOrderDAO extends CRUD<WorkOrder>{
    public WorkOrder create(WorkOrder workOrder);
    public WorkOrder findByCustomer(Customer customer);
    public WorkOrder findByTechnician(Technician technician);
    public void deleteById(int id);
}
