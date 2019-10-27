package com.ssm.dao;

import com.ssm.entity.Email;
import com.ssm.entity.User;

import java.util.List;
import java.util.Map;

public interface EmailDao {

    List<Email> getAllEmails();

    void deleteEmail(String emailid);
}
