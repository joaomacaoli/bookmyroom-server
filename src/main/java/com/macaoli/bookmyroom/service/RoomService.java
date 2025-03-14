package com.macaoli.bookmyroom.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.macaoli.bookmyroom.controller.dto.CreateRoomDTO;
import com.macaoli.bookmyroom.entity.Room;
import com.macaoli.bookmyroom.repository.RoomRepository;

@Service
public class RoomService {
  private RoomRepository roomRepository;

  public RoomService(
    RoomRepository roomRepository
  ) {
    this.roomRepository = roomRepository;
  }

  public UUID createRoom(CreateRoomDTO createRoomDTO) {
    var entity = new Room(
      null,
      createRoomDTO.description(),
      createRoomDTO.floor(),
      createRoomDTO.capacity(),
      createRoomDTO.status(),
      null
      );

      var roomSaved = roomRepository.save(entity);

      return roomSaved.getRoomId();
  }

  public List<Room> listRooms() {
    return roomRepository.findAll();
  }
}
