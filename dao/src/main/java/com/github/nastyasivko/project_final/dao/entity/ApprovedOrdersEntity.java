package com.github.nastyasivko.project_final.dao.entity;

import com.github.nastyasivko.project_final.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "approved_orders")
public class ApprovedOrdersEntity extends Orders {

    @Enumerated(EnumType.STRING)
    private Answer answer;

    private Integer numberRoom;
    private Integer cost;

    public ApprovedOrdersEntity(Long id, Long idUserLogin, Answer answer, Integer numberRoom, Integer cost) {
       super(id, idUserLogin);
       this.answer = answer;
       this.numberRoom = numberRoom;
       this.cost = cost;
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

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "ApprovedOrders{" +
                "answer='" + answer + '\'' +
                ", numberRoom=" + numberRoom +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApprovedOrdersEntity)) return false;
        if (!super.equals(o)) return false;
        ApprovedOrdersEntity that = (ApprovedOrdersEntity) o;
        return answer.equals(that.answer) &&
                numberRoom.equals(that.numberRoom) &&
                cost.equals(that.cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), answer, numberRoom, cost);
    }
}
