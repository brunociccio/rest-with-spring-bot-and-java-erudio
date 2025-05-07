package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new IllegalArgumentException("Please provide numeric values");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    private double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new IllegalArgumentException("Invalid input");
        String number = strNumber.replace(",", ".");
        return Double.parseDouble(number);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            return false;
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
