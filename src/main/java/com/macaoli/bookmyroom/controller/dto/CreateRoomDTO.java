package com.macaoli.bookmyroom.controller.dto;

import com.macaoli.bookmyroom.enums.RoomStatus;

public record CreateRoomDTO(
    String description,
    String floor,
    int capacity,
    RoomStatus status
) {}
