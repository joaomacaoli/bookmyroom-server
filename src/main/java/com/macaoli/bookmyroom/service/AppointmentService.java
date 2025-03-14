package com.macaoli.bookmyroom.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.macaoli.bookmyroom.controller.dto.CreateAppointmentDTO;
import com.macaoli.bookmyroom.controller.dto.UpdateAppointmentDTO;
import com.macaoli.bookmyroom.entity.Appointment;
import com.macaoli.bookmyroom.entity.Room;
import com.macaoli.bookmyroom.repository.AppointmentRepository;
import com.macaoli.bookmyroom.repository.RoomRepository;

@Service
public class AppointmentService {
  private AppointmentRepository appointmentRepository;
  private RoomRepository roomRepository;

  public AppointmentService(
    AppointmentRepository appointmentRepository,
    RoomRepository roomRepository
  ) {
    this.appointmentRepository = appointmentRepository;
    this.roomRepository = roomRepository;
  }

  public UUID createAppointment(
    String roomId,
    CreateAppointmentDTO createAppointmentDTO
  ) {
    Room room = roomRepository.findById(UUID.fromString(roomId))
      .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    var entity = new Appointment(
      null,
      room,
      createAppointmentDTO.date(),
      createAppointmentDTO.shift(),
      createAppointmentDTO.time(),
      createAppointmentDTO.description()
    );

      var appointmentSaved = appointmentRepository.save(entity);

      return appointmentSaved.getAppointmentId();
  }

  public List<Appointment> listAppointments() {
    return appointmentRepository.findAll();
  }

  public Optional<Appointment> getAppointmentById(String appointmentId) {
    return appointmentRepository.findById(UUID.fromString(appointmentId));
  }

  public void updateAppointmentById(
    String appointmentId,
    UpdateAppointmentDTO updateAppointmentDTO
  ){
    var id = UUID.fromString(appointmentId);

    var appointmentEntity = appointmentRepository.findById(id);

    if (appointmentEntity.isPresent()){
      var appointment = appointmentEntity.get();

      if (updateAppointmentDTO.date() != null)
        appointment.setDate(updateAppointmentDTO.date());

      if (updateAppointmentDTO.shift() != null)
      appointment.setShift(updateAppointmentDTO.shift());

      if (updateAppointmentDTO.time() != null)
      appointment.setTimeSlot(updateAppointmentDTO.time());

      if (updateAppointmentDTO.description() != null)
      appointment.setDescription(updateAppointmentDTO.description());

      appointmentRepository.save(appointment);
    }
  }

  public void deleteAppointmentById(String appointmentId) {
    var id = UUID.fromString(appointmentId);

    var appointmentExists = appointmentRepository.existsById(id);

    if (appointmentExists) appointmentRepository.deleteById(id);
  }
}
