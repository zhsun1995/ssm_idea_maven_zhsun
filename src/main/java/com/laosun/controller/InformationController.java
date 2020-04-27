package com.laosun.controller;

import com.alibaba.fastjson.JSONObject;
import com.laosun.pojo.Information;
import com.laosun.pojo.InformationExtend;
import com.laosun.service.InformationService;
import com.laosun.service.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author SUN
 * @version V1.0
 * @date 2020.04.24
 */
@Controller
@RequestMapping("")
public class InformationController {
    @Autowired
    InformationService informationService;
    @Autowired
    InformationExtend informationExtend;
    @Autowired
    PlaceService placeService;

    /**
     * 跳转到showInformation界面
     * @return
     */
    @RequestMapping("index")
    public ModelAndView toShowInformation(){
        ModelAndView mav = new ModelAndView("showInformation");
        return mav;
    }

    /**
     * 进入showInformation的响应
     * @return
     */
    @RequestMapping("showInformation")
    public ModelAndView showInformation(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("showInformation");
        return mav;
    }

    /**
     * 在showInformation界面显示所有信息
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/showAll", produces = "application/json; charset=utf-8")
    public String showAll(){
        List<InformationExtend> informationExtends = informationService.list();
        for(InformationExtend i : informationExtends){
            System.out.println(i);
        }
        return JSONObject.toJSON(informationExtends).toString();

    }

    /**
     * 响应更新跳转，接收需要更新的信息
     * @RequestBody需要再springMVC中进行配置才能使用
     * @param informationExtend
     */
    @ResponseBody
    @RequestMapping("/toUpdateInfo")
    public String toUpdateInfo(@RequestBody InformationExtend informationExtend){
        this.informationExtend = informationExtend;
        return "1";
    }

    /**
     * 进入updationInfomation界面，将需要接收到的修改的值传到前端
     * @return
     */
    @RequestMapping("updateInformation")
    public ModelAndView updateInformation(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("uid", informationExtend.getUid());
        mav.addObject("name", informationExtend.getName());
        mav.addObject("place", informationExtend.getPlace());
        mav.addObject("salary", informationExtend.getSalary());
        return mav;
    }

    /**
     * 更新数据
     * @param informationExtend
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public String update(@RequestBody InformationExtend informationExtend){
        int placeid = 0;
        try{
            placeid = placeService.getId(informationExtend.getPlace());
        } catch (Exception e){
            return "0";
        }
        informationExtend.setPlaceid(placeid);
        informationService.update(informationExtend);
        return "1";
    }

    /**
     * 删除数据
     * @param request
     * @return
     */
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(HttpServletRequest request){
        int uid = Integer.parseInt(request.getParameter("uid"));
        informationService.delete(uid);
        return "1";
    }

    /**
     * addInformation界面响应，并将系统默认生成的uid传入前端
     * @return
     */
    @RequestMapping("/addInformation")
    @ResponseBody
    public ModelAndView addInformation(){
        int maxUid = informationService.maxUid();
        ModelAndView mav = new ModelAndView();
        mav.addObject("uid", maxUid+1);
        return mav;
    }

    /**
     * 添加数据
     * @param informationExtend
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public String add(@RequestBody InformationExtend informationExtend){
        int placeid = 0;
        try{
            placeid = placeService.getId(informationExtend.getPlace());
        } catch (Exception e){
            return "0";
        }
        informationExtend.setPlaceid(placeid);
        informationService.add(informationExtend);
        return "1";
    }

}
