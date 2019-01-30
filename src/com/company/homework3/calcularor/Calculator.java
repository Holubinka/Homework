package com.company.homework3.calcularor;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Calculator {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String expression;
        int type;

        try {
            System.out.println("Введіть тип чисел");
            System.out.println("1 - арабські");
            System.out.println("2 - римські");

            type = Integer.parseInt(bufferedReader.readLine());

            if (type == 1) {
                System.out.println("Введіть вираз для розрахунку");

                expression = bufferedReader.readLine();
                expression = ReversePolishNotation(expression);
                System.out.println(calculate(expression, type));
            } else if (type == 2) {
                System.out.println("Введіть вираз для розрахунку");

                expression = bufferedReader.readLine();
                expression = ReversePolishNotation(expression);
                System.out.println(convertDecimalToRoman(calculate(expression, type)));
            } else {
                System.out.println("Ви ввели неправильний тип чисел");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static String ReversePolishNotation(String expression) throws Exception {
        StringBuilder operatorsStack = new StringBuilder();
        StringBuilder operandsOut = new StringBuilder();

        char symbol;
        char symbolTemp;

        for (int i = 0; i < expression.length(); i++) {
            symbol = expression.charAt(i);
            if (isOperator(symbol)) {
                while (operatorsStack.length() > 0) {
                    symbolTemp = operatorsStack.substring(operatorsStack.length() - 1).charAt(0);
                    if (isOperator(symbolTemp) && (priorOperation(symbol) <= priorOperation(symbolTemp))) {
                        operandsOut.append(" ").append(symbolTemp).append(" ");
                        operatorsStack.setLength(operatorsStack.length() - 1);
                    } else {
                        operandsOut.append(" ");
                        break;
                    }
                }

                if (i == 0 && isOperator(symbol)){
                    operandsOut.append(symbol);
                }else {
                    operandsOut.append(" ");
                    operatorsStack.append(symbol);
                }

            } else if ('(' == symbol) {
                operatorsStack.append(symbol);
            } else if (')' == symbol) {
                symbolTemp = operatorsStack.substring(operatorsStack.length() - 1).charAt(0);
                while ('(' != symbolTemp) {
                    if (operatorsStack.length() < 1) {
                        throw new Exception("Помилка при розкритті дужок");
                    }
                    operandsOut.append(" ").append(symbolTemp);
                    operatorsStack.setLength(operatorsStack.length() - 1);
                    symbolTemp = operatorsStack.substring(operatorsStack.length() - 1).charAt(0);
                }
                operatorsStack.setLength(operatorsStack.length() - 1);
            } else {
                operandsOut.append(symbol);
            }
        }

        while (operatorsStack.length() > 0) {
            operandsOut.append(" ").append(operatorsStack.substring(operatorsStack.length() - 1));
            operatorsStack.setLength(operatorsStack.length() - 1);
        }

        return operandsOut.toString();
    }

    private static boolean isOperator(char symbol) {
        switch (symbol) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '^':
                return true;
        }
        return false;
    }

    private static byte priorOperation(char prior) {
        switch (prior) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%':
                return 2;
        }
        return 1;
    }

    private static double calculate(String expresion, int type) throws Exception {
        String symbolTemp;
        double firstNumber = 0;
        double secondNumber;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(expresion);
        while (st.hasMoreTokens()) {
            try {
                symbolTemp = st.nextToken().trim();
                if (1 == symbolTemp.length() && isOperator(symbolTemp.charAt(0))) {
                    if (stack.size() < 2) {
                        throw new Exception("Неправильна кількість даних в стеці для операцій " + symbolTemp);
                    }
                    secondNumber = stack.pop();
                    firstNumber = stack.pop();
                    switch (symbolTemp.charAt(0)) {
                        case '+':
                            firstNumber += secondNumber;
                            break;
                        case '-':
                            firstNumber -= secondNumber;
                            break;
                        case '/':
                            firstNumber /= secondNumber;
                            break;
                        case '*':
                            firstNumber *= secondNumber;
                            break;
                        case '%':
                            firstNumber %= secondNumber;
                            break;
                        case '^':
                            firstNumber = Math.pow(firstNumber, secondNumber);
                            break;
                        default:
                            throw new Exception("Неможлива операція" + symbolTemp);
                    }
                    stack.push(firstNumber);
                } else {
                    if (type == 1) {
                        firstNumber = Double.parseDouble(symbolTemp);
                        stack.push(firstNumber);
                    } else {
                        firstNumber = convertRomanToDecimal(symbolTemp);
                        stack.push(firstNumber);
                    }
                }
            } catch (Exception e) {
                throw new Exception("Неправильний символ у виразі");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("Кількість операторів не рівна кількость операндів");
        }
        return stack.pop();
    }

    private static int convertRomanToDecimal(String romanNumber) {
        int decimal = 0;
        int lastNumber = 0;

        String romanNumeral = romanNumber.toString().toUpperCase();

        for (int i = romanNumeral.length() - 1; i >= 0; i--) {
            char convertDoDecimal = romanNumeral.charAt(i);

            switch (convertDoDecimal) {
                case 'M':
                    decimal = processDecimal(1000, lastNumber, decimal);
                    lastNumber = 1000;
                    break;
                case 'D':
                    decimal = processDecimal(500, lastNumber, decimal);
                    lastNumber = 500;
                    break;
                case 'C':
                    decimal = processDecimal(100, lastNumber, decimal);
                    lastNumber = 100;
                    break;
                case 'L':
                    decimal = processDecimal(50, lastNumber, decimal);
                    lastNumber = 50;
                    break;
                case 'X':
                    decimal = processDecimal(10, lastNumber, decimal);
                    lastNumber = 10;
                    break;
                case 'V':
                    decimal = processDecimal(5, lastNumber, decimal);
                    lastNumber = 5;
                    break;
                case 'I':
                    decimal = processDecimal(1, lastNumber, decimal);
                    lastNumber = 1;
                    break;
            }
        }
        return decimal;
    }

    private static int processDecimal(int decimal, int lastNumber, int lastDecimal) {
        if (decimal > lastNumber) {
            return lastDecimal + decimal;
        } else {
            return lastDecimal - decimal;
        }
    }

    private static String convertDecimalToRoman(double decimalNumber) {
        String romanDecimal = "";
        double decimal = decimalNumber;
        while (decimal > 0) {
            if (decimal >= 1000) {
                romanDecimal += "M";
                decimal -= 1000;
                continue;
            }
            if (decimal >= 900) {
                romanDecimal += "CM";
                decimal -= 900;
                continue;
            }
            if (decimal >= 500) {
                romanDecimal += "D";
                decimal -= 500;
                continue;
            }
            if (decimal >= 400) {
                romanDecimal += "CD";
                decimal -= 400;
                continue;
            }
            if (decimal >= 100) {
                romanDecimal += "C";
                decimal -= 100;
                continue;
            }
            if (decimal >= 90) {
                romanDecimal += "XC";
                decimal -= 90;
                continue;
            }
            if (decimal >= 50) {
                romanDecimal += "L";
                decimal -= 50;
                continue;
            }
            if (decimal >= 40) {
                romanDecimal += "XL";
                decimal -= 40;
                continue;
            }
            if (decimal >= 10) {
                romanDecimal += "X";
                decimal -= 10;
                continue;
            }
            if (decimal >= 9) {
                romanDecimal += "IX";
                decimal -= 9;
                continue;
            }
            if (decimal >= 5) {
                romanDecimal += "V";
                decimal -= 5;
                continue;
            }
            if (decimal >= 4) {
                romanDecimal += "IV";
                decimal -= 4;
                continue;
            }
            if (decimal >= 1) {
                romanDecimal += "I";
                decimal -= 1;
                continue;
            }
        }
        return romanDecimal;
    }
}

