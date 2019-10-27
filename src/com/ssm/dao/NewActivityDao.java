package com.ssm.dao;

import com.ssm.entity.NewActivity;

import java.util.List;

public interface NewActivityDao {

    List<NewActivity> getAllNewActivityList();

    void insertNewActivity(NewActivity newActivity);

    List<NewActivity> getNewActivity(String id);

    void deleteNewActivity(String id);

    void modifyNewActivity(NewActivity newActivity, String newsId);

}
