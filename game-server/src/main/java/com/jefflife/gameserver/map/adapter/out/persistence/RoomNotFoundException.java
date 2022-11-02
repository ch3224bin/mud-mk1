package com.jefflife.gameserver.map.adapter.out.persistence;

public class RoomNotFoundException extends RuntimeException {
  public RoomNotFoundException(long id) {
    super(String.format("Room ID %d is not found", id));
  }
}
