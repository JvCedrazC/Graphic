package com.example.phase4.dao.ServicesDao;

import com.example.phase4.FilesUtils.ManagingFiles;
import com.example.phase4.Model.Services;

import java.util.ArrayList;

public class ServicesDaoList  {
   private ManagingFiles managingFiles;
   ServicesDaoList(){
       this.managingFiles = new ManagingFiles("services.bin");
   }

   public void create(ArrayList<Services> services){
       managingFiles.save(services);

   }
   public ArrayList<Services> retrieve(){
       return managingFiles.retrieve();
   }

}
