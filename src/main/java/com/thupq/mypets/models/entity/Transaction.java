package com.thupq.mypets.models.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "transaction")
public class Transaction {
    @Column(name = "action", length = 1000)
    private String action;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "status", length = 10)
    private String status;

    @Column(name = "create_date", nullable = false)
    private Date createDate;

    @Column(name = "create_by", nullable = false)
    private String createBy;
}
