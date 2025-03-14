package com.macaoli.bookmyroom.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.macaoli.bookmyroom.entity.Appointment;

@Repository
public interface AppointmentRepository
  extends JpaRepository<Appointment, UUID>{}
