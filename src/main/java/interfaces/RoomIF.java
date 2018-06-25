package interfaces;

import entities.Room;
import java.util.List;


public interface RoomIF {
    
     public List<Room> getAllRooms();
     
     public Room createRoom(Room room);
     
     public boolean deleteRoom(Room room);
     
     public Room findRoomById(Long id);
    
}
