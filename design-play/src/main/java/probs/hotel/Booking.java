package probs.hotel;

import java.util.Date;
import java.util.Deque;
import java.util.List;
import java.util.Map;

public class Booking {

    HotelBooking book(HotelBooking book){


        return null;
    }


}



class City {

}

class Hotel {
    Map<RoomCategory, RoomAvail> roomAvailMap;
    List<Facilities> facilities;

    City city;



}


class RoomAvail {
    RoomCategory roomCategory;
    Map<Integer, Room> roomMap;
    Deque<Integer> availaRooms;
}

class RoomCategory {
    int capacity;
    int rate;


    boolean checkAvail(){
        return false;
    }

}

class Room {

    int roomNo;
    RoomCategory roomCategory;


}


abstract class Facilities {
    abstract int getCharge();
    abstract boolean isComplimentry();

}

class Wifi extends Facilities {
    @Override
    int getCharge() {
        return 0;
    }

    @Override
    boolean isComplimentry() {
        return false;
    }
}

class HotelBooking {
    List<RoomBooking> roomBookings;

    List<Facilities> facilities;







}

class RoomBooking {
    Date checkIn;
    Date checkOut;

    Room room;

}