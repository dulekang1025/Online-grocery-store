package com.pika.Onlinegrocerystore.Services.ServiceImpl;

import com.pika.Onlinegrocerystore.Services.ManagerService;
import com.pika.Onlinegrocerystore.dao.IManagerDao;
import com.pika.Onlinegrocerystore.domain.Manager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@NoArgsConstructor
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private IManagerDao managerDao;

//    @Autowired
//    public ManagerServiceImpl(IManagerDao managerDao){
//        this.managerDao=managerDao;
//    }


    @Override
    public Manager findById(Long id) {
        Manager manager=managerDao.findManagerById(id);
        return manager;
    }

    @Override
    public List<Manager> findAll() {
        List<Manager> result=managerDao.findAll();
        return result;
    }

    @Override
    public void update(Manager manager) {
        managerDao.updateManager(manager);
    }

    @Override
    public void create(Manager manager) {
        managerDao.saveManager(manager);
    }

    @Override
    public void deleteById(Long id) {
        managerDao.deleteManagerById(id);
    }

    @Override
    public List<Manager> findByName(String name) {
        List<Manager> result=managerDao.findManagerByName(name);
        return result;
    }

    @Override
    public Manager checkLogin(String name, String password) { //todo: waitfor controller
        return null;
    }
}
