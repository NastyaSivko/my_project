package com.github.nastyasivko.project_final.dao.entity;

import com.github.nastyasivko.project_final.model.Answer;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import java.util.Objects;

@Data
@AllArgsConstructor
@Entity
@Table(name = "denied_order")
public class DeniedOrdersEntity extends Orders {

    @Enumerated(EnumType.STRING)
    private Answer answer;

    public DeniedOrdersEntity(Long id, Long userId, Answer answer) {
        super(id, userId);
        this.answer = answer;
    }

    public DeniedOrdersEntity() {
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeniedOrdersEntity)) return false;
        if (!super.equals(o)) return false;
        DeniedOrdersEntity that = (DeniedOrdersEntity) o;
        return getAnswer() == that.getAnswer();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getAnswer());
    }
}
