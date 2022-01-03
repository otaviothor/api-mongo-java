package com.otavio.restapimongodb;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

import lombok.Data;

@Data
public class Student {
  private String firstName;
  private String lastName;
  private String email;
  private Gender gender;
  private Address address;
  private List<String> favouriteSubjects;
  private BigDecimal totalSpentInBooks;
  private ZonedDateTime created;
}
