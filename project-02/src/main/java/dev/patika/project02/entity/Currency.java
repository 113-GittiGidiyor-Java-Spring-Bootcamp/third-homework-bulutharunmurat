package dev.patika.project02.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Currency extends CurrencyBaseRequest {
    //This class is used in case of currency object returned from controller
    @Id
    private int id;

    private float usd_TRY;

}
