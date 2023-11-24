package web.service;

import web.model.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarServiceImp implements CarService {
    @Override
    public List<Car> carList(Integer count) {
        List<Car> carList = new ArrayList<>();
        carList.add(new Car("BMV1", 10, "Black"));
        carList.add(new Car("BMV2", 11, "White"));
        carList.add(new Car("BMV3", 12, "Green"));
        carList.add(new Car("BMV4", 13, "Red"));
        carList.add(new Car("BMV5", 14, "Yellow"));
        return count != null && count >= 0 ? carList.stream().limit(count).collect(Collectors.toList()) : carList;
    }
}
