package probs.rider;

import java.util.Date;
import java.util.List;

public class RiderApp {

    List<Cab> getNearestCabs(User user){
        return null;
    }

}




abstract class Person {

}

class User extends Person{

    Location location;


}


class Vehicle {


}


class Cab  {
    Driver driver;
    Vehicle vehicle;
    Location curLocation;
    Ride ride;

    void accept(Ride ride){

    }




}

class Driver extends  Person{

}



class Location {

}

class Ride {
    Location from;
    Location to;
    Date bookingTime;

    Cab cab;

    PaymentMode mode;

    void start(){

    }

    void end() {

    }



}

class PushNotificationHandle {

}
class PaymentMode {

}