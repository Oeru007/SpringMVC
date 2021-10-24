package web.DAO;

import web.model.Car;

import java.util.List;

public interface CarDAO {
    void addCar(Car car);
    List<Car> findAll();
    List<Car> findFew(Integer count);
}
