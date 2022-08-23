import java.util.Scanner;

public class TaxesCalculator {

        public static void main(String[] args) {
            int myTaxIncome, myTaxIncomeMinusExpenses, economy;
            int myIncomeTotal = 0;
            int myExpensesTotal = 0;
            while (true) {
                menu();
                Scanner scanner = new Scanner(System.in);
                String input = scanner.nextLine();
                if (input.equals("End")) {
                    break;
                }
                if (input.equals("1")) {
                    System.out.print("Введите доход: ");
                    input = scanner.nextLine();
                    myIncomeTotal = calcSum(input, myIncomeTotal);
                } else if (input.equals("2")) {
                    System.out.print("Введите расход: ");
                    input = scanner.nextLine();
                    myExpensesTotal = calcSum(input, myExpensesTotal);
                } else if (input.equals("3")) {
                    if (myIncomeTotal == 0 && myExpensesTotal == 0) {
                        System.out.println("Вы не ввели информацию о расходах и доходах. Повторите ввод.");
                        continue;
                    }
                    myTaxIncome = (int) calcTaxIncome(myIncomeTotal);
                    myTaxIncomeMinusExpenses = (int) calcTaxIncomeMinusExpenses(myIncomeTotal, myExpensesTotal);
                    if (myTaxIncome < myTaxIncomeMinusExpenses) {
                        economy = myTaxIncomeMinusExpenses - myTaxIncome;
                        System.out.println();
                        System.out.println("Мы советуем Вам УСН доходы");
                        System.out.println("Ваш налог составит: " + myTaxIncome);
                        System.out.println("Налог на другой системе: " + myTaxIncomeMinusExpenses);
                        System.out.println("Экономия: " + economy);
                        System.out.println();
                    } else if (myTaxIncome > myTaxIncomeMinusExpenses && (myIncomeTotal - myExpensesTotal) < 0) {
                        economy = myTaxIncome - myTaxIncomeMinusExpenses;
                        System.out.println();
                        System.out.println("Вы в убытке, поэтому мы советуем Вам Вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + myTaxIncomeMinusExpenses);
                        System.out.println("Налог на другой системе: " + myTaxIncome);
                        System.out.println("Экономия: " + economy);
                        System.out.println();
                    } else if (myTaxIncome > myTaxIncomeMinusExpenses && (myIncomeTotal - myExpensesTotal) >= 0) {
                        economy = myTaxIncome - myTaxIncomeMinusExpenses;
                        System.out.println();
                        System.out.println("Мы советуем Вам УСН доходы минус расходы");
                        System.out.println("Ваш налог составит: " + myTaxIncomeMinusExpenses);
                        System.out.println("Налог на другой системе: " + myTaxIncome);
                        System.out.println("Экономия: " + economy);
                        System.out.println();
                    }
                }

            }
            System.out.println("До свидания!");
        }

        public static void menu() {
            System.out.println();
            System.out.println("Выберите операцию и введите её номер:");
            System.out.println("1. Добавить новый доход");
            System.out.println("2. Добавить новый расход");
            System.out.println("3. Выбрать ситему налогооблажения");
            System.out.println("Чтобы закончить, введите End");
            System.out.print("Номер операции: ");
        }

        public static int calcSum(String input, int myTotal) {
            int mySum = Integer.parseInt(input);
            if (mySum < 0) {
                System.out.println("Вводимое число не может быть отрицательным. Повторите ввод.");
            } else {
                myTotal += mySum;
            }
            return myTotal;
        }

        public static double calcTaxIncome(int myIncomeTotal) {
            return myIncomeTotal * 0.06;
        }

        public static double calcTaxIncomeMinusExpenses(int myIncomeTotal, int myExpensesTotal) {
            return (myIncomeTotal < myExpensesTotal) ? 0 : (myIncomeTotal - myExpensesTotal) * 0.15;
        }

    }
