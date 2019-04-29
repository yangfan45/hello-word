package com.example.dao.base;

import java.util.List;

/**
 * @author yangfan
 * @date 2018/9/10
 * @describe
 **/
public interface BaseMapper<Entity, Id> {

    /**
     * @date 2018/9/10
     * @describe 有选择性的新增对象
     **/
    int insert(Entity entity);

    /**
     * @date 2018/9/10
     * @describe 标记删除(逻辑删除)
     **/
    int markAsDeleted(Id id);

    /**
     * @date 2018/9/10
     * @describe 有选择性的更新对象
     **/
    int updateById(Entity entity);

    /**
     * @date 2018/9/10
     * @describe 根据ID获取对象
     **/
    Entity findById(Id id);

    /**
     * @date 2018/9/10
     * @describe 获取所有对象
     **/
    List<Entity> findAll();
}
