package com.example.intcontbackend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "property")
@Accessors(chain = true)
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column(name = "name")
    String name;

    @Column(name = "description")
    String description;

    @Column(name = "price")
    Double price;

    @ManyToOne()
    @JoinColumn(name = "user_id", nullable = false, updatable = false)
    User user;

    @ManyToOne()
    @JoinColumn(name = "category_id", nullable = false, updatable = false)
    Category category;

    @Column(name = "city")
    String city;

    @Column(name = "neighborhood")
    String neighborhood;

    @Column(name = "rooms")
    Long rooms;

    @Column(name = "bathrooms")
    Long bathrooms;

    @Column(name = "parking")
    Long parking;

    @Column(name = "stratum")
    Long stratum;

    @Column(name = "area")
    String area;

    @Column(name = "created_at")
    Date createdAt;

    @OneToMany(mappedBy = "property")
    List<Operation> operations;
}
