import java.awt.*;

public class Harvester extends Car implements Fueling, Wiping {

    private Refueling refueling;

    private Rewiping rewiping;

    public Harvester(String make, String model, Color color) {
        super(make, model, color);
        setWheelsCount(6);
        setFueltype(FuelType.Diesel);
    }

    public void setRewiping(Rewiping rewiping) {
        this.rewiping = rewiping;
    }



    @Override
    public void wipMirrors() {
        if (rewiping != null) {
            wipWindshield();
        }
        this.clearType = true;
    }

    @Override
    public void wipWindshield() {
        wipHeadlights();
    }

    @Override
    public void wipHeadlights() {

    }
    public void setRefuelingStation(Refueling refueling) {
        this.refueling = refueling;
    }

    /**
     * Заправить автомобиль
     */
    @Override
    public void fuel() {
        if (refueling != null) {
            refueling.fuel(fueltype);
        }
    }

    @Override
    public void movement() {

    }

    @Override
    public void maintenance() {

    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadLights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    public void sweepintg() {
        System.out.println("Автомобиль метёт улицу.");
    }






}
