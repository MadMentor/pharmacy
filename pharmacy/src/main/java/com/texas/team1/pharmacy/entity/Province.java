package com.texas.team1.pharmacy.entity;

import jakarta.persistence.*;
import lombok.*;

/**
 * @Author Province
 * java-suraj -- 2024-01-26
 */

@Getter
@Setter
@Entity
@Table(name = "province", uniqueConstraints =
@UniqueConstraint(name = "uk_province_name", columnNames = "name"))
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class  Province {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", length = 50)
    private String name;

    @Column(name = "nepali_name", length = 100)
    private String nepaliName;

    private Integer code;
}
