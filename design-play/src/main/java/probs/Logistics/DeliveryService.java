package probs.Logistics;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class DeliveryService {

    List<Location> checkETA(External from, External to) {
        return null;
    }
}


class User {


}



class Package {
    User user;
    External from;
    External to;
    Location curr;
    Item item;


    PackageTracker packageTracker;


}

class PackageTracker {

    TrackerNode start;
    TrackerNode cur;
    Status status;

    public TrackerNode moveStatus(Status status){
        return cur.next;
    }



    private static class TrackerNode {
        Location location;
        Date eta;
        Date actT;
        TrackerNode next;

    }


}

class Item {

}

abstract class Location {

}

class External extends Location {

    Internal getNearestInternalLocation() {
        return null;

    }

}
class Internal extends Location {}

enum Status {
    IN_TRANSIT,
        DELIVERED;
    //more

}

class InternalLocationGraph  {



}