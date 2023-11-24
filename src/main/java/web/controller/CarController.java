package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.Car;
import web.service.CarServiceImp;

import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String getCar(@RequestParam(value = "count", required = false) Integer count, Model model) {
        List<Car> carList = new CarServiceImp().carList(count);
        model.addAttribute("cars", carList);
        return "cars";
    }
}
