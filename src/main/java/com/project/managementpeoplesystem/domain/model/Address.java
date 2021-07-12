package com.project.managementpeoplesystem.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String number;

    private String address;

    private String neighborhood;

    private String city;

    private String state;

    @Column(name = "postal_code")
    private String postalCode;

}
