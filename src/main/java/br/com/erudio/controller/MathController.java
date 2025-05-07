package br.com.erudio.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/soma/{numberOne}/{numberTwo}")
    public Double soma(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping("/divisao/{numberOne}/{numberTwo}")
    public Double divisao(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping("/multiplicacao/{numberOne}/{numberTwo}")
    public Double multiplicacao(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/subtracao/{numberOne}/{numberTwo}")
    public Double subtracao(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double media(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");

        return (convertToDouble(numberOne) - convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping("/media/{numberOne}/{numberTwo}")
    public Double raizquadrada(
            @PathVariable("number") String number)
            throws Exception {
        if (!isNumeric("number"))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }

    private double convertToDouble(String strNumber) {
        if (strNumber == null || strNumber.isEmpty())
            throw new UnsupportedMathOperationException("Invalid input");
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
