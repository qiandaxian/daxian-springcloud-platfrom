package com.courier.service.core;

import com.courier.db.config.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;


/**
 * MybatisService<br>
 * <blockquote> 
 * 该类中已经实例化了<br>
 * 基于实体的Mapper即 Mapper<T>,<b>所以在Service的具体实例化中不需要重复定义相同实体的Mapper</b> </blockquote>
 * 
 * @author ql
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public abstract class MybatisService<T> implements Service<T> {

    @Autowired
    protected Mapper<T> mapper;

    private Class<T> modelClass;    // 当前泛型真实类型的Class

	public MybatisService() {
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
        modelClass = (Class<T>) pt.getActualTypeArguments()[0];
    }

	/**
	 * 【单表】根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 */
	@Override
	public List<T> select(T record) {
		return mapper.select(record);
	}

	/**
	 * 【单表】根据实体类不为null的字段查询总数,条件全部使用=号and条件
	 */
	@Override
	public int selectCount(T record) {
		return mapper.selectCount(record);
	}

	/**
	 * 【单表】根据主键进行查询,必须保证结果唯一 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
	 */
	@Override
	public T selectByPrimaryKey(Object key) {
		return mapper.selectByPrimaryKey(key);
	}
	
	/**
	 * 根据实体中的属性进行查询，只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * 只能有一个返回值，有多个结果是抛出异常，查询条件使用等号
	 * @param record
	 * @return
	 */
	public T selectOne(T record) {
		return mapper.selectOne(record);
	}
	
	/**
	 * 通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws TooManyResultsException
	 */
	@Override
	public T selectOneBy(String fieldName, Object value) throws TooManyResultsException {
        try {
            T model = modelClass.newInstance();
            Field field = modelClass.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(model, value);
            return mapper.selectOne(model);
        } catch (ReflectiveOperationException e) {
            throw new ServiceException(e.getMessage(), e);
        }
	}

	/**
	 * 【单表】插入一条数据 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
	 * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
	 * <br>保存一个实体，null的属性也会保存，不会使用数据库默认值</br>
	 */
	@Override
	public int insert(T record) {
		return mapper.insert(record);
	}

	/**
	 * 【单表】插入一条数据,只插入不为null的字段,不会影响有默认值的字段
	 * 支持Oracle序列,UUID,类似Mysql的INDENTITY自动增长(自动回写)
	 * 优先使用传入的参数值,参数值空时,才会使用序列、UUID,自动增长
	 */
	@Override
	public int insertSelective(T record) {
		return mapper.insertSelective(record);
	}
	
	/**
	 * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等，另外该接口限制实体包含`id`属性并且必须为自增列
	 */
	@Override
	public int insertList(List<T> models) {
    	return mapper.insertList(models);
    }

	/**
	 * 【单表】根据实体类不为null的字段进行查询,条件全部使用=号and条件
	 */
	@Override
	public int delete(T key) {
		return mapper.delete(key);
	}

	/**
	 * 【单表】通过主键进行删除,这里最多只会删除一条数据 单个字段做主键时,可以直接写主键的值 联合主键时,key可以是实体类,也可以是Map
	 */
	@Override
	public int deleteByPrimaryKey(Object key) {
		return mapper.deleteByPrimaryKey(key);
	}

	/**
	 * 根据主键字符串进行删除，类中只有存在一个带有@Id注解的字段
	 */
	@Override
	public void deleteByIds(String ids) {
        mapper.deleteByIds(ids);
    }
	
	/**
	 * 【单表】【根据主键更新实体全部字段，null值会被更新】根据主键进行更新,这里最多只会更新一条数据 参数为实体类
	 */
	@Override
	public int updateByPrimaryKey(T record) {
		return mapper.updateByPrimaryKey(record);
	}

	/**
	 * 【单表】【根据主键更新属性不为null的值】根据主键进行更新 只会更新不是null的数据
	 */
	@Override
	public int updateByPrimaryKeySelective(T record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 【单表】单表分页
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            条数
	 * @param record
	 *            条件实体(可以是Map)
	 * @return
	 */
	@Override
	public PageInfo<T> selectPage(int pageNum, int pageSize, T record) {
		PageHelper.startPage(pageNum, pageSize);
		return new PageInfo<T>(mapper.select(record));
	}

	@Override
	public PageInfo<T> selectPage(int pageNum, int pageSize, String orderBy, T record) {
//		PageHelper.startPage(pageNum, pageSize);
		PageHelper.startPage(pageNum, pageSize, orderBy);
		return new PageInfo<T>(mapper.select(record));
	}

}