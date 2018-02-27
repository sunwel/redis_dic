package com.enlink.redisdic.dao.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author idea
 * @since 2017-01-01
 */
@TableName("think_redis_dic")
public class ThinkRedisDic extends Model<ThinkRedisDic> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
    /**
     * redis库名
     */
	@TableField("database_name")
	private String databaseName;
    /**
     * 项目名称
     */
	@TableField("project_name")
	private String projectName;
    /**
     * 键值
     */
	@TableField("redis_key")
	private String redisKey;
    /**
     * 键值类型
     */
	@TableField("redis_type")
	private String redisType;
    /**
     * 用处
     */
	private String used;
    /**
     * 生命周期
     */
	@TableField("life_cycle")
	private Integer lifeCycle;
	@TableField("update_time")
	private Date updateTime;


	public Integer getId() {
		return id;
	}

	public ThinkRedisDic setId(Integer id) {
		this.id = id;
		return this;
	}

	public String getDatabaseName() {
		return databaseName;
	}

	public ThinkRedisDic setDatabaseName(String databaseName) {
		this.databaseName = databaseName;
		return this;
	}

	public String getProjectName() {
		return projectName;
	}

	public ThinkRedisDic setProjectName(String projectName) {
		this.projectName = projectName;
		return this;
	}

	public String getRedisKey() {
		return redisKey;
	}

	public ThinkRedisDic setRedisKey(String redisKey) {
		this.redisKey = redisKey;
		return this;
	}

	public String getRedisType() {
		return redisType;
	}

	public ThinkRedisDic setRedisType(String redisType) {
		this.redisType = redisType;
		return this;
	}

	public String getUsed() {
		return used;
	}

	public ThinkRedisDic setUsed(String used) {
		this.used = used;
		return this;
	}

	public Integer getLifeCycle() {
		return lifeCycle;
	}

	public ThinkRedisDic setLifeCycle(Integer lifeCycle) {
		this.lifeCycle = lifeCycle;
		return this;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public ThinkRedisDic setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
		return this;
	}

	public static final String ID = "id";

	public static final String DATABASE_NAME = "database_name";

	public static final String PROJECT_NAME = "project_name";

	public static final String REDIS_KEY = "redis_key";

	public static final String REDIS_TYPE = "redis_type";

	public static final String USED = "used";

	public static final String LIFE_CYCLE = "life_cycle";

	public static final String UPDATE_TIME = "update_time";

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "ThinkRedisDic{" +
			"id=" + id +
			", databaseName=" + databaseName +
			", projectName=" + projectName +
			", redisKey=" + redisKey +
			", redisType=" + redisType +
			", used=" + used +
			", lifeCycle=" + lifeCycle +
			", updateTime=" + updateTime +
			"}";
	}
}
