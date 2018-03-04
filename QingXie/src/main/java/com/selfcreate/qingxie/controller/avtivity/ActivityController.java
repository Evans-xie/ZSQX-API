package com.selfcreate.qingxie.controller.avtivity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.selfcreate.qingxie.bean.Msg;
import com.selfcreate.qingxie.bean.activity.Activity;
import com.selfcreate.qingxie.service.activity.ActivityService;

@RequestMapping("/activity/")
@Controller
public class ActivityController {

	@Autowired
	private ActivityService activityService;
	
	/**
	 * ��ȡ���л��Ϣ
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "getAllActivities",method = RequestMethod.GET)
	public Msg getAllActivities(){
		List<Activity> activities = activityService.getAll();
		return Msg.success().add("activities", activities);
	}
	
	/**
	 * �����
	 * @param activity
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "releaseActivity",method = RequestMethod.PUT)
	public Msg releaseActivity(@RequestBody Activity activity){
		if(activity != null){
			activityService.releaseActivity(activity);
			return Msg.success().add("activities", activity);
		}else{			
			return Msg.error("���Ϣ����Ϊ��");
		}
	}
	
}