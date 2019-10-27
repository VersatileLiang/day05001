package com.ssm.serviceImpl;

import com.ssm.dao.NewActivityDao;
import com.ssm.dao.UserDao;
import com.ssm.entity.NewActivity;
import com.ssm.entity.User;
import com.ssm.service.NewActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("NewActivityService")
public class NewActivityServiceImpl implements NewActivityService {

    @Autowired
    private NewActivityDao dao;

    @Override
    public List<NewActivity> getAllNewActivityList() {
        List<NewActivity> list = dao.getAllNewActivityList();
        return list;
    }

    @Override
    public void insertNewActivity(NewActivity newActivity) {
        dao.insertNewActivity(newActivity);
    }

    @Override
    public List<NewActivity> getNewActivity(String id) {
        List<NewActivity> list = dao.getNewActivity(id);
        return list;
    }

    @Override
    public void deleteNewActivity(String id) {
        dao.deleteNewActivity(id);
    }

    @Override
    public void modifyNewActivity(NewActivity newActivity, String newsId) {
        dao.modifyNewActivity(newActivity,newsId);
    }

}
