package com.github.nastyasivko.project_final.dao.entity;

import com.github.nastyasivko.project_final.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "approved_order")
public class ApprovedOrdersEntity extends Orders {

    @Enumerated(EnumType.STRING)
    private Answer answer;

    private Integer numberRoom;

    @ManyToOne
    @JoinColumn(name = "cost_room")
    private CostRoomsEntity costRoomsEntity;

    public ApprovedOrdersEntity(Long id, Long userId, Answer answer, Integer numberRoom, CostRoomsEntity costRoomsEntity) {
        super(id, userId);
        this.answer = answer;
        this.numberRoom = numberRoom;
        this.costRoomsEntity = costRoomsEntity;
    }

    public ApprovedOrdersEntity() {
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    @Override
    public String toString() {
        return "ApprovedOrdersEntity{" +
                "answer=" + answer +
                ", numberRoom=" + numberRoom +
                ", costRoomsEntity=" + costRoomsEntity +
                '}';
    }

    public CostRoomsEntity getCostRoomsEntity() {
        return costRoomsEntity;
    }

    public void setCostRoomsEntity(CostRoomsEntity costRoomsEntity) {
        this.costRoomsEntity = costRoomsEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApprovedOrdersEntity)) return false;
        if (!super.equals(o)) return false;
        ApprovedOrdersEntity that = (ApprovedOrdersEntity) o;
        return getAnswer() == that.getAnswer() &&
                Objects.equals(getNumberRoom(), that.getNumberRoom()) &&
                Objects.equals(getCostRoomsEntity(), that.getCostRoomsEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAnswer(), getNumberRoom(), getCostRoomsEntity());
    }
}
