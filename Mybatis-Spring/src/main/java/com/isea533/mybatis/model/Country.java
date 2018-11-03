package com.isea533.mybatis.model;


import tk.mybatis.mapper.annotation.Version;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "country")
public class Country {
    /**
     * 主键
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    /**
     * 名称
     */
    private String countryname;

    /**
     * 代码
     */
    private String countrycode;

    /**
     * 乐观锁操作
     */
    @Version
    private Integer version;

    /**
     * 获取主键
     *
     * @return Id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取名称
     *
     * @return countryname - 名称
     */
    public String getCountryname() {
        return countryname;
    }

    /**
     * 设置名称
     *
     * @param countryname 名称
     */
    public void setCountryname(String countryname) {
        this.countryname = countryname;
    }

    /**
     * 获取代码
     *
     * @return countrycode - 代码
     */
    public String getCountrycode() {
        return countrycode;
    }

    /**
     * 设置代码
     *
     * @param countrycode 代码
     */
    public void setCountrycode(String countrycode) {
        this.countrycode = countrycode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}