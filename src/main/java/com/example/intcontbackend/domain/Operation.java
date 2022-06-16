package com.example.intcontbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "operation")
@Accessors(chain = true)
public class Operation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @ManyToOne()
    @JoinColumn(name = "property_id", nullable = false, updatable = false)
    Property property;

    @ManyToOne()
    @JoinColumn(name = "operation_type_id", nullable = false, updatable = false)
    OperationType operationType;

    @Column(name = "date")
    Date date;
}
