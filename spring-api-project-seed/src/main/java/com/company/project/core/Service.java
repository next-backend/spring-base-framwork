package com.company.project.core;

import org.apache.ibatis.exceptions.TooManyResultsException;
import tk.mybatis.mapper.entity.Condition;

import java.util.List;

/**
 * Service 层 基础接口，其他Service 接口 请继承该接口
 */
public interface Service<T> {
    void save(T model);//持久化

    void save(List<T> models);//批量持久化

    int deleteById(Long id);//通过主鍵刪除

    int delete(T t);

    void deleteByIds(String ids);//批量刪除 eg：ids -> “1,2,3,4”

    void update(T model);//更新

    int updateByPrimaryKeySelective(T t);//更新

    T findById(Long id);//通过ID查找

    T findBy(String fieldName, Object value) throws TooManyResultsException; //通过Model中某个成员变量名称（非数据表中column的名称）查找,value需符合unique约束

    List<T> findByIds(String ids);//通过多个ID查找//eg：ids -> “1,2,3,4”

    List<T> findByCondition(Condition condition);//根据条件查找

    List<T> findAll();//获取所有

    default int deleteWithVersion(Long id) {
        int result = this.deleteById(id);
        if (result == 0) {
            throw new RuntimeException("删除失败!");
        }
        return result;
    }

    default int deleteWithVersion(T t) {
        int result = this.delete(t);
        if (result == 0) {
            throw new RuntimeException("删除失败!");
        }
        return result;
    }

    default int updateByPrimaryKeyWithVersion(T t) {
        int result = this.updateByPrimaryKeySelective(t);
        if (result == 0) {
            throw new RuntimeException("更新失败!");
        }
        return result;
    }
}
