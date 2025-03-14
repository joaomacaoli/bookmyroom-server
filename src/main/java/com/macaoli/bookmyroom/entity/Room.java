package com.macaoli.bookmyroom.entity;

import java.util.UUID;
import java.util.List;

import jakarta.persistence.*;
import com.macaoli.bookmyroom.enums.RoomStatus;

@Entity
@Table(name = "tb_rooms")
public class Room {

  @Id
  @Column(name = "room_id")
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID roomId;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "floor", nullable = false)
  private String floor;

  @Column(name = "capacity", nullable = false)
  private int capacity;

  @Enumerated(EnumType.STRING)
  @Column(name = "status", nullable = false)
  private RoomStatus status;

  @OneToMany(mappedBy = "room")
  private List<Appointment> appointments;

  public Room() {}

  public Room(UUID roomId, String description, String floor, int capacity,
    RoomStatus status, List<Appointment> appointments) {

    this.roomId = roomId;
    this.description = description;
    this.floor = floor;
    this.capacity = capacity;
    this.status = status;
    this.appointments = appointments;
  }

  public UUID getRoomId() {
    return roomId;
  }

  public void setRoomId(UUID roomId) {
    this.roomId = roomId;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getFloor() {
    return floor;
  }

  public void setFloor(String floor) {
    this.floor = floor;
  }

  public int getCapacity() {
    return capacity;
  }

  public void setCapacity(int capacity) {
    this.capacity = capacity;
  }

  public RoomStatus getStatus() {
    return status;
  }

  public void setStatus(RoomStatus status) {
    this.status = status;
  }

  public List<Appointment> getAppointments() {
    return appointments;
  }

  public void setAppointments(List<Appointment> appointments) {
    this.appointments = appointments;
  }
}
