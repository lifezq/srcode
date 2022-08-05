package com.record.srcode.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

/**
 * @TableName product
 */
@TableName(value = "product")
public class Product implements Serializable {
    /**
     * 主键ID
     */
    @TableId
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 乐观锁版本号
     */
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 商品名称
     */
    public String getName() {
        return name;
    }

    /**
     * 商品名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 价格
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * 价格
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * 乐观锁版本号
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 乐观锁版本号
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
                && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
                && (this.getVersion() == null ? other.getVersion() == null : this.getVersion().equals(other.getVersion()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getVersion() == null) ? 0 : getVersion().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", price=").append(price);
        sb.append(", version=").append(version);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}