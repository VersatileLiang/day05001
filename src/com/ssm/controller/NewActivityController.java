package com.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.ssm.entity.NewActivity;
import com.ssm.entity.News;
import com.ssm.entity.NewsXi;
import com.ssm.service.NewActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class NewActivityController {
    @Autowired
    private NewActivityService newActivityService;
    @ResponseBody
    @RequestMapping("list.do")
    public String getAllNewActivityList(String id){
        String result;
        List<NewActivity> list;
        if (id==null||id.equals("")){
            list = newActivityService.getAllNewActivityList();
            List<News> newsList = new ArrayList<>();
            for (NewActivity newActivity : list){
                News news = new News();
                news.setId(newActivity.getId());
                news.setTitle(newActivity.getTitle());
                news.setSource(newActivity.getSource());
                news.setDate(newActivity.getDatetime());
                news.setFirstImage(newActivity.getThumbnail());
                newsList.add(news);
            }
            result = JSON.toJSON(newsList).toString();
            result = "{\"result\":" + result;
            result = result + ",\"message\":\"查询成功\",\"status\":\"0000\"}";
        }else {
            list = newActivityService.getNewActivity(id);
            NewActivity newActivity = list.get(0);
            NewsXi newsXi = new NewsXi();
            newsXi.setId(newActivity.getId());
            newsXi.setTitle(newActivity.getTitle());
            newsXi.setSource(newActivity.getSource());
            newsXi.setContent(newActivity.getSummary());
            newsXi.setFirstImage(newActivity.getThumbnail());
            result = JSON.toJSON(newsXi).toString();
            result = "{\"result\":" + result;
            result = result + ",\"message\":\"查询成功\",\"status\":\"0000\"}";
        }
        return result;
    }

    @RequestMapping("insert.do")
    public String insertNewActivity(HttpServletRequest request, HttpServletResponse response, NewActivity newActivity) throws UnsupportedEncodingException {

        System.out.println("tag2:"+newActivity.toString());
        newActivityService.insertNewActivity(newActivity);
        return "/index";
    }

    @RequestMapping("delete.do")
    public String deleteNewActivity(String id){
        newActivityService.deleteNewActivity(id);
        return "/index";
    }

    @RequestMapping("modify.do")
    public String modifyNewActivity(String id, NewActivity newActivity){
        String newsId = id;
        newActivityService.modifyNewActivity(newActivity,newsId);
        return "/index";
    }
}
