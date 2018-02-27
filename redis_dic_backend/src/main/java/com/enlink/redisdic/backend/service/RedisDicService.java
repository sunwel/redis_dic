package com.enlink.redisdic.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.enlink.redisdic.dao.entity.ThinkRedisDic;
import com.enlink.redisdic.dao.service.IThinkRedisDicService;

import java.util.List;
import java.util.Map;

@Service
public class RedisDicService {

	@Autowired
	private IThinkRedisDicService redisDicService;

	/**
	 * 添加
	 * @param thinkRedisDic
	 * @return
	 */
	public boolean insert(ThinkRedisDic thinkRedisDic) {
		return redisDicService.insertOrUpdateAllColumn(thinkRedisDic);
	}

	/**
	 * 删除通过id
	 * @param id
	 */
	public void deleteRedisDicById(int id) {
		redisDicService.deleteById(id);
	}

	/**
	 * 根据key值查找信息
	 * @param key
	 * @return
	 */
	public Page<ThinkRedisDic> selectByKey(String key) {
		Wrapper<ThinkRedisDic> wrapper = new EntityWrapper<>();
		wrapper.eq(ThinkRedisDic.REDIS_KEY, key);
		wrapper.orderBy(ThinkRedisDic.UPDATE_TIME, false);
		return redisDicService.selectPage(new Page<ThinkRedisDic>(), wrapper);
	}

	/**
	 * 根据type类型查找信息
	 * @param type
	 * @return
	 */
	public Page<ThinkRedisDic> selectByType(String type) {
		Wrapper<ThinkRedisDic> wrapper = new EntityWrapper<>();
		wrapper.eq(ThinkRedisDic.REDIS_TYPE, type);
		wrapper.orderBy(ThinkRedisDic.UPDATE_TIME, false);
		return redisDicService.selectPage(new Page<ThinkRedisDic>(), wrapper);
	}

	/**
	 * 分页查询
	 * @return
	 * @param databaseName
	 * @param projectName
	 * @param redisKey
	 * @param redisValue
	 * @param used
	 * @param lifeCycle
	 * @param current
	 * @param limit
	 */
	public Page<ThinkRedisDic> pageList(String databaseName, String projectName, String redisKey, String redisValue,
			String used, Integer lifeCycle, Integer current, Integer limit) {
		Wrapper<ThinkRedisDic> wrapper = new EntityWrapper<>();
		wrapper.eq(StringUtils.isNotEmpty(databaseName), ThinkRedisDic.DATABASE_NAME, databaseName);
		wrapper.eq(StringUtils.isNotEmpty(projectName), ThinkRedisDic.PROJECT_NAME, projectName);
		wrapper.eq(StringUtils.isNotEmpty(redisKey), ThinkRedisDic.REDIS_KEY, redisKey);
		wrapper.eq(StringUtils.isNotEmpty(redisValue) && !"All".equals(redisValue), ThinkRedisDic.REDIS_TYPE,
				redisValue);
		wrapper.eq(StringUtils.isNotEmpty(used), ThinkRedisDic.USED, used);
		wrapper.eq(lifeCycle != null, ThinkRedisDic.LIFE_CYCLE, lifeCycle);
		wrapper.orderBy(ThinkRedisDic.DATABASE_NAME);
		wrapper.orderBy(ThinkRedisDic.REDIS_KEY);
		wrapper.orderBy(ThinkRedisDic.REDIS_TYPE);
		Page<ThinkRedisDic> page = new Page<>();
		if (current != null && current > 0) {
			page.setCurrent(current);
		}
		if (limit != null && limit > 0) {
			page.setSize(limit);
		}
		return redisDicService.selectPage(page, wrapper);
	}

    /**
     * 获取database下拉数据
     * @return
     */
    public List<ThinkRedisDic> databaseList() {
        Wrapper<ThinkRedisDic> wrapper = new EntityWrapper<>();
        wrapper.setSqlSelect(ThinkRedisDic.DATABASE_NAME);
        wrapper.orderBy(ThinkRedisDic.DATABASE_NAME);
        return redisDicService.selectList(wrapper);
    }

    /**
     * 获取project下拉框数据
     * @return
     */
    public List<ThinkRedisDic> projectList() {
        Wrapper<ThinkRedisDic> wrapper = new EntityWrapper<>();
        wrapper.setSqlSelect(ThinkRedisDic.PROJECT_NAME);
        wrapper.orderBy(ThinkRedisDic.PROJECT_NAME);
        return redisDicService.selectList(wrapper);
    }

}
