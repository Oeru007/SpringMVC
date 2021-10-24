package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.DAO.CarDAOImpl;
import web.model.Car;

import java.util.List;
@Component
public class CarServiceImpl implements CarService {
    private final CarDAOImpl carDAO;

    @Autowired
    public CarServiceImpl(CarDAOImpl carDAO) {
        this.carDAO = carDAO;
    }

    @Override
    public void addCar(Car car) {
        carDAO.addCar(car);
    }

    @Override
    public List<Car> findAll() {
        return carDAO.findAll();
    }

    @Override
    public List<Car> findFew(Integer count) {
        return carDAO.findFew(count);
    }
}
