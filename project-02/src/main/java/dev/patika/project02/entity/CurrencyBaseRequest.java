package dev.patika.project02.entity;


import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Data
@MappedSuperclass
public class CurrencyBaseRequest {
    //This class is used in case of currency object returned from controller
    private LocalDateTime localDate;
}
