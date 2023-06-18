package com.example.phase4.dao.WorkOrderDao;

import com.example.phase4.FilesUtils.ManagingFiles;
import com.example.phase4.Model.Customer;
import com.example.phase4.Model.Technician;
import com.example.phase4.Model.WorkOrder;

import java.util.ArrayList;

public class WorkOrderDaoList implements WorkOrderDAO {
    private ManagingFiles managingFiles;
    private int nextID;
    private ArrayList<WorkOrder>lista;

    public WorkOrderDaoList(){
        this.managingFiles = new ManagingFiles("workOrder.bin");
        lista = this.managingFiles.retrieve();
        if (lista.size() == 0){
            nextID = lista.size();
        } else{
            nextID = 0;
        }
    }
    //Create
    @Override
    public WorkOrder create(WorkOrder workOrder) {
        workOrder.setId(nextID);
        nextID++;
        lista.add(workOrder);
        save(lista);
        return workOrder;
    }
    //read
    @Override
    public WorkOrder findById(int id) {
        for (WorkOrder workOrder: lista) {
            if(workOrder.getId() == id){
                return workOrder;
            }
        }
        return null;
    }

    @Override
    public WorkOrder findByCustomer(Customer customer) {
        for (WorkOrder workOrder: lista) {
            if (workOrder.getCustomer() == customer.getId()){
                return workOrder;
            }

        }return null;
    }

    @Override
    public WorkOrder findByTechnician(Technician technician) {
        for (WorkOrder workOrder: lista) {
            if (workOrder.getTechnician() == technician.getId()){
                return workOrder;
            }
        }return null;
    }
    public ArrayList<WorkOrder> findMany(){
        ArrayList<WorkOrder> listWorkOrder = new ArrayList<WorkOrder>();
        for (Object o : lista) {
            listWorkOrder.add((WorkOrder) o);
        }
        return listWorkOrder;
    }

    //Update
    public void update(WorkOrder workOrder){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == workOrder.getId()) {
                lista.set(i, workOrder);
                return;
            }
        }
        managingFiles.save(lista);
    }
    //Delete
    public void deleteMany(){
        lista = new ArrayList<WorkOrder>();
        this.nextID =  0;
        save(lista);

    }
    public void deleteById(int id){
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                break;
            }
        }
        changeId(lista);
        save(lista);
    }

    public WorkOrder getNewAvailableOrder(){
        for (WorkOrder i: lista) {
            if (i.getStatus() == "Aberta") {
                return i;
            }
        }
        return null;

    }
    private void changeId(ArrayList<WorkOrder> lista){
        for (int i = 0; i < lista.size();i++){
            lista.get(i).setId(i);
        }
    }

    public void save(ArrayList<WorkOrder> workOrders){
        managingFiles.save(workOrders);
    }

}
