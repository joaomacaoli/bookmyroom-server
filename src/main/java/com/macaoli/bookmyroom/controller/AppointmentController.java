package com.macaoli.bookmyroom.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macaoli.bookmyroom.controller.dto.CreateAppointmentDTO;
import com.macaoli.bookmyroom.controller.dto.UpdateAppointmentDTO;
import com.macaoli.bookmyroom.entity.Appointment;
import com.macaoli.bookmyroom.service.AppointmentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("v1/appointments")
public class AppointmentController {
  private AppointmentService appointmentService;

  public AppointmentController(AppointmentService appointmentService) {
    this.appointmentService = appointmentService;
  }

  @PostMapping("/{roomId}")
  public ResponseEntity<Appointment> createAppointment(
    @PathVariable("roomId") String roomId,
    @RequestBody CreateAppointmentDTO createAppointmentDTO) {
    var room = appointmentService.createAppointment(
      roomId,
      createAppointmentDTO
    );

    return ResponseEntity.created(
      URI.create("/v1/appointments" + room.toString())
    ).build();
  }

  @GetMapping
  public ResponseEntity<List<Appointment>> listAppointments() {
    var appointments = appointmentService.listAppointments();

    return ResponseEntity.ok(appointments);
  }

  @GetMapping("/{appointmentId}")
  public ResponseEntity<Appointment> listAppointmentById(
    @PathVariable("appointmentId") String appointmentId
  ) {
    var appointment = appointmentService.getAppointmentById(appointmentId);

    if (appointment.isEmpty()) return ResponseEntity.notFound().build();

      return ResponseEntity.ok(appointment.get());
  }

  @PutMapping("/{appointmentId}")
  public ResponseEntity<Void> updateAppointmentById(
    @PathVariable("appointmentId") String appointmentId,
    @RequestBody UpdateAppointmentDTO updateAppointmentDTO
    ) {
    appointmentService.updateAppointmentById(appointmentId, updateAppointmentDTO);

    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{appointmentId}")
  public ResponseEntity<Void> removeAppointmentById(
    @PathVariable("appointmentId") String appointmentId
  ){
    appointmentService.deleteAppointmentById(appointmentId);

    return ResponseEntity.noContent().build();
  }
}
