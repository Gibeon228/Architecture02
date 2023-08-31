package store3D.models;

public class Camera {
    private Point3D location;
    private Angle3D angle;

    public Camera(Point3D location, Angle3D angle) {
        this.location = location;
        this.angle = angle;
    }

    public Camera() {
    }

    /**
     * Функция поворота
     *
     * @param angleRotate
     */
    public void rotate(Angle3D angleRotate) {
        this.angle.setRadian(this.angle.getRadian() + angleRotate.getRadian());
    }

    /**
     * Функция перемещения локации
     *
     * @param pointMove
     */
    public void move(Point3D pointMove) {
        this.location.setX(this.location.getX() + pointMove.getX());
        this.location.setY(this.location.getY() + pointMove.getY());
        this.location.setZ(this.location.getZ() + pointMove.getZ());
    }
}
