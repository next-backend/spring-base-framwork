package com.company.project.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "success_killed")
public class SuccessKilled {
    /**
     * 秒杀商品id
     */
    @Id
    @Column(name = "seckill_id")
    private Long seckillId;

    /**
     * 用户手机号
     */
    @Id
    @Column(name = "user_phone")
    private Long userPhone;

    /**
     * 状态标示:-1:无效 0:成功 1:已付款 2:已发货
     */
    private Byte state;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取秒杀商品id
     *
     * @return seckill_id - 秒杀商品id
     */
    public Long getSeckillId() {
        return seckillId;
    }

    /**
     * 设置秒杀商品id
     *
     * @param seckillId 秒杀商品id
     */
    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    /**
     * 获取用户手机号
     *
     * @return user_phone - 用户手机号
     */
    public Long getUserPhone() {
        return userPhone;
    }

    /**
     * 设置用户手机号
     *
     * @param userPhone 用户手机号
     */
    public void setUserPhone(Long userPhone) {
        this.userPhone = userPhone;
    }

    /**
     * 获取状态标示:-1:无效 0:成功 1:已付款 2:已发货
     *
     * @return state - 状态标示:-1:无效 0:成功 1:已付款 2:已发货
     */
    public Byte getState() {
        return state;
    }

    /**
     * 设置状态标示:-1:无效 0:成功 1:已付款 2:已发货
     *
     * @param state 状态标示:-1:无效 0:成功 1:已付款 2:已发货
     */
    public void setState(Byte state) {
        this.state = state;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}