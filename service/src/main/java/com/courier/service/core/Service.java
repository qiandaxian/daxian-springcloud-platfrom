package com.courier.service.core;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 * @author qiandaxian
 *
 * @param <T>
 */
public interface Service<T> {

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     *
     * @param record
     * @return
     */
    public List<T> select(T record);

    /**
     * 根据实体类不为null的字段查询总数,条件全部使用=号and条件
     *
     * @param record
     * @return
     */
    public int selectCount(T record);

    /**
     * 根据主键进行查询,必须保证结果唯一 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
     *
     * @param key
     * @return
     */
    public T selectByPrimaryKey(Object key);

    /**
     * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
     *
     * @param fieldName
     * @param value
     * @return
     * @throws TooManyResultsException
     */
    public T selectOneBy(String fieldName, Object value) throws TooManyResultsException;

    /**
     * 【单表】单表分页
     * 【单表】单表分页
     *
     * @param pageNum  页码
     * @param pageSize 条数
     * @param record   条件实体(可以是Map)
     * @return
     */
    public PageInfo<T> selectPage(int pageNum, int pageSize, T record);

    /**
     * 【单表】单表分页
     *
     * @param pageNum  页码
     * @param pageSize 条数
     * @param orderBy
     * @param record   条件实体(可以是Map)
     * @return
     */
    public PageInfo<T> selectPage(int pageNum, int pageSize, String orderBy, T record);

    /**
     * 插入一条数据 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
     * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
     *
     * @param record
     * @return
     */
    public int insert(T record);

    /**
     * 插入一条数据,只插入不为null的字段,不会影响有默认值的字段
     * 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
     * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
     *
     * @param record
     * @return
     */
    public int insertSelective(T record);

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
     *
     * @param models
     * @return
     */
    public int insertList(List<T> models);

    /**
     * 根据实体类不为null的字段进行查询,条件全部使用=号and条件
     *
     * @param key
     * @return
     */
    public int delete(T key);

    /**
     * 通过主键进行删除,这里最多只会删除一条数据 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
     *
     * @param key
     * @return
     */
    public int deleteByPrimaryKey(Object key);

    /**
     * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
     */
    public void deleteByIds(String ids);

    /**
     * 根据主键进行更新,这里最多只会更新一条数据 参数为实体类
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKey(T record);

    /**
     * 根据主键进行更新 只会更新不是null的数据
     *
     * @param record
     * @return
     */
    public int updateByPrimaryKeySelective(T record);

}
