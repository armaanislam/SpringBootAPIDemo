package com.springdemo.springbootapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity // Now it can interact with the database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id // To define departmentId as primary key
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please Add Department Name") // Making departmentName required
    private String departmentName;

    private String departmentAddress;
    private String departmentCode;

}
