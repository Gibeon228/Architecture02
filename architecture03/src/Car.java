import java.awt.*;

public abstract class Car {

    //region Constructors

    public Car(String make, String model, Color color) {
        this.make = make;
        this.model = model;
        this.color = color;
    }


    //endregion

    //region Public Methods

    // Движение
    public abstract void movement();

    // Обслуживание
    public abstract void maintenance();

    // Переключение передач
    public abstract boolean gearShifting();

    // Включение фар
    public abstract boolean switchHeadLights();

    // Включение дворников
    public abstract boolean switchWipers();

    public boolean isClearType() {
        if (clearType == true) {
            System.out.println("Автомобиль чистый");
        } else {
            System.out.println("Автомобиль грязный");
        }
        return clearType;
    }

    public boolean switchFogLights() {
        fogLights =!fogLights;
        return fogLights;
    }

    public void setFueltype(FuelType fueltype) {
        this.fueltype = fueltype;
    }

    protected void setWheelsCount(int c) {
        this.wheelsCount = wheelsCount;
    }

    public int getWheelsCount() {
        return wheelsCount;
    }

//endregion

    //region Private Fields

    // Марка автомобиля
    private String make;

    // Модель
    private String model;

    // Цвет
    private Color color;

    // Тип
    protected CarType type;

    // Число колёс
    private int wheelsCount;

    // Тип топлива
    protected FuelType fueltype;


    protected boolean clearType = false;

    // Тип коробки передач
    private GearboxType gearboxType;

    // Объём двигателя
    private double engineCapacity;

    // Состояние противотуманных фар
    private boolean fogLights = false;

    //endregion
}
