package generator.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 碳排放看板表
 *
 * @TableName board_carbon_emission
 */
@TableName(value = "board_carbon_emission")
@Data
public class BoardCarbonEmission implements Serializable {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     *
     */
    private Integer modelId;

    /**
     *
     */
    private Integer trackId;

    /**
     *
     */
    private Integer emissionSourceId;

    /**
     *
     */
    private String deviceId;

    /**
     * 增量值
     */
    private Double computeValue;

    /**
     * 累计值
     */
    private Double cumulativeValue;

    /**
     *
     */
    private Date updateTime;

    /**
     *
     */
    private Date createTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

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
        BoardCarbonEmission other = (BoardCarbonEmission) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
                && (this.getModelId() == null ? other.getModelId() == null : this.getModelId().equals(other.getModelId()))
                && (this.getTrackId() == null ? other.getTrackId() == null : this.getTrackId().equals(other.getTrackId()))
                && (this.getEmissionSourceId() == null ? other.getEmissionSourceId() == null : this.getEmissionSourceId().equals(other.getEmissionSourceId()))
                && (this.getDeviceId() == null ? other.getDeviceId() == null : this.getDeviceId().equals(other.getDeviceId()))
                && (this.getComputeValue() == null ? other.getComputeValue() == null : this.getComputeValue().equals(other.getComputeValue()))
                && (this.getCumulativeValue() == null ? other.getCumulativeValue() == null : this.getCumulativeValue().equals(other.getCumulativeValue()))
                && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
                && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getModelId() == null) ? 0 : getModelId().hashCode());
        result = prime * result + ((getTrackId() == null) ? 0 : getTrackId().hashCode());
        result = prime * result + ((getEmissionSourceId() == null) ? 0 : getEmissionSourceId().hashCode());
        result = prime * result + ((getDeviceId() == null) ? 0 : getDeviceId().hashCode());
        result = prime * result + ((getComputeValue() == null) ? 0 : getComputeValue().hashCode());
        result = prime * result + ((getCumulativeValue() == null) ? 0 : getCumulativeValue().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", modelId=").append(modelId);
        sb.append(", trackId=").append(trackId);
        sb.append(", emissionSourceId=").append(emissionSourceId);
        sb.append(", deviceId=").append(deviceId);
        sb.append(", computeValue=").append(computeValue);
        sb.append(", cumulativeValue=").append(cumulativeValue);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}