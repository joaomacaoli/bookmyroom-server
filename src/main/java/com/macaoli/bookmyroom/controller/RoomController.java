package com.macaoli.bookmyroom.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.macaoli.bookmyroom.controller.dto.CreateRoomDTO;
import com.macaoli.bookmyroom.entity.Room;
import com.macaoli.bookmyroom.service.RoomService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("v1/rooms")
public class RoomController {
  private RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @PostMapping
  public ResponseEntity<Room> createRoom(@RequestBody CreateRoomDTO createRoomDTO) {
    var roomId = roomService.createRoom(createRoomDTO);

    return ResponseEntity.created(
      URI.create("/v1/rooms" + roomId.toString())
    ).build();
  }

  @GetMapping
  public ResponseEntity<List<Room>> listRooms() {
    var rooms = roomService.listRooms();

    return ResponseEntity.ok(rooms);
  }


}
