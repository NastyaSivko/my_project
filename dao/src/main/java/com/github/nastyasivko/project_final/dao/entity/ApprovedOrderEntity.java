package com.github.nastyasivko.project_final.dao.entity;

import com.github.nastyasivko.project_final.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "approved_order")
public class ApprovedOrderEntity extends Order {

    private Answer answer;

    private Integer numberRoom;

    private CostRoomEntity costRoomEntity;

    public ApprovedOrderEntity(Long id, Long userId, Date dateStart, Date dateEnd, Answer answer, Integer numberRoom, CostRoomEntity costRoomEntity) {
        super(id, userId, dateStart, dateEnd);
        this.answer = answer;
        this.numberRoom = numberRoom;
        this.costRoomEntity = costRoomEntity;
    }

    public ApprovedOrderEntity() {
    }

    @Enumerated(EnumType.STRING)
    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Column(name = "number_room")
    public Integer getNumberRoom() {
        return numberRoom;
    }

    public void setNumberRoom(Integer numberRoom) {
        this.numberRoom = numberRoom;
    }

    @ManyToOne
    @JoinColumn(name = "cost_room")
    public CostRoomEntity getCostRoomEntity() {
        return costRoomEntity;
    }

    public void setCostRoomEntity(CostRoomEntity costRoomEntity) {
        this.costRoomEntity = costRoomEntity;
    }

    @Override
    public String toString() {
        return "ApprovedOrdersEntity{" +
                "answer=" + answer +
                ", numberRoom=" + numberRoom +
                ", costRoomsEntity=" + costRoomEntity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApprovedOrderEntity)) return false;
        if (!super.equals(o)) return false;
        ApprovedOrderEntity that = (ApprovedOrderEntity) o;
        return getAnswer() == that.getAnswer() &&
                Objects.equals(getNumberRoom(), that.getNumberRoom()) &&
                Objects.equals(getCostRoomEntity(), that.getCostRoomEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAnswer(), getNumberRoom(), getCostRoomEntity());
    }
}
