package com.iteyes10.taskProject.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class list_data {
    int id;
    String title;
    String name;
    LocalDate time;
}
