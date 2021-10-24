package web.DAO;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class CarDAOImpl implements CarDAO {

    private List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        cars.add(car);
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public List<Car> findFew(Integer count) {
        if (count == null || count >= cars.size()){
            return cars;
        } else if (count <= 0){
            return cars.stream().limit(0).collect(Collectors.toList());
        } else {
            return cars.stream().limit(count).collect(Collectors.toList());
        }
    }
}
