package com.homework.homeword01.dao.impl;

import com.homework.homeword01.dao.SClassDao;
import com.homework.homeword01.pojo.SClass;
import com.homework.homeword01.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class SClassDaoImpl implements SClassDao {
    @Override
    public List<SClass> findAll() {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from t_class";
        List<SClass> classList = null;
        try {
            classList = qr.query(sql, new BeanListHandler<>(SClass.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classList;
    }

    @Override
    public SClass findById(int id) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from t_class where id=?";
        SClass sClass = null;
        try {
            sClass = qr.query(sql, new BeanHandler<>(SClass.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sClass;
    }

    @Override
    public SClass findByName(String name) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from t_class where name = ?";
        SClass sClass = null;
        try {
            sClass = qr.query(sql, new BeanHandler<>(SClass.class), name);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sClass;
    }

    @Override
    public SClass findByGrade(String grade) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from t_class where grade = ?";
        SClass sClass = null;
        try {
            sClass = qr.query(sql, new BeanHandler<>(SClass.class), grade);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sClass;
    }

    @Override
    public SClass findByTeacher(String teacher) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "select * from t_class where teacher = ?";
        SClass sClass = null;
        try {
            sClass = qr.query(sql, new BeanHandler<>(SClass.class), teacher);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return sClass;
    }

    @Override
    public int add(SClass sClass) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "insert into t_class values(null,?,?,?,?,?)";
        int update = 0;
        try {
            update = qr.update(sql, sClass.getName(), sClass.getGrade(), sClass.getTeacher(), sClass.getSlogan(), sClass.getNum());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }

    @Override
    public int delete(int id) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "delete from t_class where id=?";
        int update = 0;
        try {
            update = qr.update(sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }

    @Override
    public int update(SClass sClass) {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());
        String sql = "update t_class set name=?,grade=?,teacher=?,slogan=?,num=? where id=?";
        int update = 0;
        try {
            update = qr.update(sql, sClass.getName(), sClass.getGrade(), sClass.getTeacher(), sClass.getSlogan(), sClass.getNum(), sClass.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return update;
    }
}
