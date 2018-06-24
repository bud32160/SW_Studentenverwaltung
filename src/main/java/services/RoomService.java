package services;

import entities.Exam;
import entities.Room;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@RequestScoped
public class RoomService {
    
    @PersistenceContext(unitName="StudentenverwaltungPU")
    private EntityManager em;
    
    public List<Room> getAllRooms(){
        TypedQuery<Room> query = em.createNamedQuery("Room.getAllRooms", Room.class);
        
        try{
            return query.getResultList(); 
        } 
        catch(Exception ex){
           return null;
        }
    }
    
    @Transactional
    public Room createRoom(Room room){
        Room r = room;
        
        em.persist(r);
        em.flush();
            
        return room;
    }
    
    @Transactional
    public boolean deleteRoom(Room room){
        Room r = em.find(Room.class, room.getId());
        
        em.remove(r);
        em.flush();
        
        return true;
    }
}
