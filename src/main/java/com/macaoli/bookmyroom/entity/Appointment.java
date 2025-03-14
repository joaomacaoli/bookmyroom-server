package com.macaoli.bookmyroom.entity;

import java.util.UUID;
import java.time.LocalDate;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.macaoli.bookmyroom.enums.AppointmentShift;
import com.macaoli.bookmyroom.enums.AppointmentTimeSlot;

@Entity
@Table(name = "tb_appointments")
public class Appointment {

  @Id
  @Column(name = "appointment_id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID appointmentId;

  @ManyToOne
  @JoinColumn(name = "room_id", nullable = false)
  @JsonIgnoreProperties("appointments")
  private Room room;

  @Column(name = "date", nullable = false)
  private LocalDate date;

  @Enumerated(EnumType.STRING)
  @Column(name = "shift", nullable = false)
  private AppointmentShift shift;

  @Enumerated(EnumType.STRING)
  @Column(name = "time_slot", nullable = false)
  private AppointmentTimeSlot timeSlot;

  @Column(name = "description")
  private String description;

  public Appointment() {}

  public Appointment(UUID appointmentId, Room room, LocalDate date, AppointmentShift shift, AppointmentTimeSlot timeSlot, String description) {
    this.appointmentId = appointmentId;
    this.room = room;
    this.date = date;
    this.shift = shift;
    this.timeSlot = timeSlot;
    this.description = description;
  }

  public UUID getAppointmentId() {
    return appointmentId;
  }

  public void setAppointmentId(UUID appointmentId) {
    this.appointmentId = appointmentId;
  }

  public Room getRoom() {
    return room;
  }

  public void setRoom(Room room) {
    this.room = room;
  }

  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public AppointmentShift getShift() {
    return shift;
  }

  public void setShift(AppointmentShift shift) {
    this.shift = shift;
  }

  public AppointmentTimeSlot getTimeSlot() {
    return timeSlot;
  }

  public void setTimeSlot(AppointmentTimeSlot timeSlot) {
    this.timeSlot = timeSlot;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
