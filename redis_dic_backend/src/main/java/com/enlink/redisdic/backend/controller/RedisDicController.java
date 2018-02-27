package com.enlink.redisdic.backend.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.baomidou.mybatisplus.plugins.Page;
import com.enlink.redisdic.backend.model.ResultMessage;
import com.enlink.redisdic.backend.service.RedisDicService;
import com.enlink.redisdic.dao.entity.ThinkRedisDic;

@Controller
public class RedisDicController {

	private static final Logger logger = LoggerFactory.getLogger(RedisDicController.class);

	@Autowired
	RedisDicService redisDicService;

	// @RequestMapping("dic/index")
	// public String index(){
	// return "/index";
	// }

	@GetMapping("dic/deletebyid")
	public @ResponseBody ResultMessage delete(@RequestParam int id) {
		redisDicService.deleteRedisDicById(id);
		return successResponse(null);
	}

	@PostMapping("dic/insert")
	public @ResponseBody ResultMessage insert1(@RequestBody ThinkRedisDic thinkRedisDic) {
		thinkRedisDic.setUpdateTime(new Date());
		redisDicService.insert(thinkRedisDic);
		return successResponse(null);
	}

	@GetMapping("dic/selectbykey")
	public ResultMessage selectByKey(String key) {
		Page<ThinkRedisDic> page = redisDicService.selectByKey(key);
		return successResponse(page);
	}

	@GetMapping("dic/selectbytype")
	public ResultMessage selectByType(String type) {
		Page<ThinkRedisDic> page = redisDicService.selectByType(type);
		return successResponse(page);
	}

	@GetMapping("dic/pagelist")
	public @ResponseBody ResultMessage pageList(String databaseName, String projectName, String redisKey,
			String redisValue, String used, Integer lifeCycle, Integer page, Integer limit) {
		Page<ThinkRedisDic> resultPage = redisDicService.pageList(databaseName, projectName, redisKey, redisValue, used,
				lifeCycle, page, limit);
		return successResponse(resultPage);
	}

    @GetMapping("dic/databaselist")
    public @ResponseBody ResultMessage databaseList() {
        List<ThinkRedisDic> list = redisDicService.databaseList();
        Set<String> set = list.stream().map(rd->{return rd.getDatabaseName();}).collect(Collectors.toSet());
        return successResponse(set);
    }

    @GetMapping("dic/projectlist")
    public @ResponseBody ResultMessage projectList() {
        List<ThinkRedisDic> list = redisDicService.projectList();
        Set<String> set = list.stream().map(rd->{return rd.getProjectName();}).collect(Collectors.toSet());
        return successResponse(set);
    }

	private ResultMessage successResponse(Object obj) {
		return resp(0, "OK", obj);
	}

	private ResultMessage failResponse(Object obj) {
		return resp(-1, "FAIL", obj);
	}

	private ResultMessage resp(int code, String msg, Object obj) {
		return new ResultMessage(code, msg, obj);
	}
}
