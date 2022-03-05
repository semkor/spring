package com.lesson4.hw1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.lesson3.hw1");
            Controllers controller=context.getBean(Controllers.class);
            MyService myService=context.getBean(MyService.class);
            Utils utils=context.getBean(Utils.class);
            FileDAO fileDAO=context.getBean(FileDAO.class);
            StorageDAO storageDAO=context.getBean(StorageDAO.class);

//----------------------------------DAO ----------------------------------------------------------
//            Storage storage=new Storage();
//                storage.setFormatsSupported("doc,jpeg,xml");
//                storage.setStorageCountry("korea");
//                storage.setStorageMaxSize(2400);
//            storageDAO.save(storage);
//        storageDAO.update(new Storage(2,"word,xml","NewENGLAND",1850));
//        System.out.println(storageDAO.findById(5));
//            storageDAO.delete(4);

//FileDAO
//          File file=new File();
//            file.setName("Rom");
//            file.setFormat("xml");
//            file.setSize(125);
//        System.out.println(fileDAO.save(file));
//        System.out.println(fileDAO.update (new File(10,"NEW","xml",45,new Storage(2,"doc,jpeg,xml","newENGLAND",1850))));
//        System.out.println(fileDAO.findById(11));
//        fileDAO.delete(14);
//-------------------------------------------------delete---------------------------------------------------------------
//        controller.delete(storageDAO.findById(2),new File(10,"GOOMlUC","DOC",67, storageDAO.findById(2)));

//-------------------------------------------------add------------------------------------------------------------------

//        controller.put(storageDAO.findById(2),new File(12,"GOOMlUC","word",67, null));

//-------------------------------------------------transfer-------------------------------------------------------------
//        controller.transferFile(storageDAO.findById(1), storageDAO.findById(2),2);
//        controller.transferFile(new Storage(1,"txt,xml,word","Ukraine",1300),
//                new Storage(2,"word,xml","ENGLAND",1850),2);
    }
}
