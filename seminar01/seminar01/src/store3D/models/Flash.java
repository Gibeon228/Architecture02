package store3D.models;

import java.util.List;

public class Flash {
    private Point3D location;
    private Angle3D angle;
    private Color color;
    private float power;


    public Flash(Point3D location, Angle3D angle, Color color, float power) {
        this.location = location;
        this.angle = angle;
        this.color = color;
        this.power = power;
    }

    public Flash() {
    }

    /**
     * Функция поворота
     * @param angleRotate
     */
    public void rotate(Angle3D angleRotate) {
        this.angle.setRadian(this.angle.getRadian() + angleRotate.getRadian());
    }

    /**
     * Функция перемещения локации
     * @param pointMove
     */
    public void move(Point3D pointMove) {
        this.location.setX(this.location.getX() + pointMove.getX());
        this.location.setY(this.location.getY() + pointMove.getY());
        this.location.setZ(this.location.getZ() + pointMove.getZ());
    }
}
