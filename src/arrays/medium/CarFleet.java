package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CarFleet {

    private class Car {
        private int position;
        private int speed;

        private Car(){

        }

        Car(int p, int s){
            this.position = p;
            this.speed = s;

        }
    }

    public int carFleet(int target, int[] position, int[] speed) {

        /**
         * We don't need to check this we will have atleast one entry
         */
//        if(position.length == 0 && speed.length == 0){
//            return 0;
//        }
        List<Car> cars = new ArrayList<Car>();

        for(int i =0; i<position.length; i++){
            Car car = new Car(position[i], speed[i]);
            cars.add(car);
        }

        //Since it is a single lane, position is the bottle neck
        Collections.sort(cars,(Car a, Car b) -> (b.position -a.position));

        /**
         * One car can also contribute to the fleet
         * Also speed can never be 0 as it cannot cross
         */


        int fleet = 1;

        Car car = cars.get(0);
        float carAheadTimeToDestination = calcTimeToDestination(target, car);

        for(int i = 1; i<cars.size(); i++){
            car = cars.get(i);
            float currentCarTimeToDestination = calcTimeToDestination(target, car);

            /**
             * This formula is the key!
             */
            if(currentCarTimeToDestination > carAheadTimeToDestination){
                /**
                 * current car cannot catch to the car in front of it
                 * before reaching the destination
                 */
                fleet++;
                /**
                 * Current time to destination becomes new bottle neck
                 */
                carAheadTimeToDestination =  currentCarTimeToDestination;

            }
        }

        return fleet;
    }


    private float calcTimeToDestination(int targetMiles, Car car){
        return ((float)targetMiles-car.position)/car.speed;
    }



}
