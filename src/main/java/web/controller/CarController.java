package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private CarService carService;

    public CarController(){
    }

    @Autowired
    public void setCarService(CarService carService) {
        carService.addCar(new Car("model 1", 100501, "color 1"));
        carService.addCar(new Car("model 2", 100502, "color 2"));
        carService.addCar(new Car("model 3", 100503, "color 3"));
        carService.addCar(new Car("model 4", 100504, "color 4"));
        carService.addCar(new Car("model 5", 100505, "color 5"));
        this.carService = carService;
    }

    @GetMapping
    public String carGetMap(@RequestParam(value = "count", required = false) Integer count, Model model){
        model.addAttribute("cars", carService.findFew(count));
        return "cars";
    }
}
