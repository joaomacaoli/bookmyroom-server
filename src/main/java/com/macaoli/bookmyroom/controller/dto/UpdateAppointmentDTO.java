package com.macaoli.bookmyroom.controller.dto;

import java.time.LocalDate;

import com.macaoli.bookmyroom.enums.AppointmentShift;
import com.macaoli.bookmyroom.enums.AppointmentTimeSlot;

public record UpdateAppointmentDTO (
  LocalDate date,
  AppointmentShift shift,
  AppointmentTimeSlot time,
  String description
) {}
