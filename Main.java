
import java.util.Scanner;

public class Main {
    // Convert number from any base to decimal
    public static int toDecimal(String number, int base) {
        int decimalValue = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.digit(number.charAt(i), base);
            decimalValue += digit * power(base, power);
            power++;
        }
        return decimalValue;
    }

    // Convert decimal to any base
    public static String fromDecimal(int number, int base) {
        String result = "";
        while (number > 0) {
            int rem = number % base;
            if (rem > 9) {
                result = (char) (rem - 10 + 'A') + result;
            } else {
                result = rem + result;
            }
            number /= base;
        }
        return result;
    }

    // Perform addition of two numbers in any base
    public static void baseAddition() {
        Scanner input = new Scanner(System.in);

        System.out.println(Constants.ENTERFIRSTNUMBER);
        String num1 = input.next();
        System.out.println(Constants.ENTERBASEFIRSTNUMBER);
        int base1 = input.nextInt();

        System.out.println(Constants.ENTERSECONDNUMBER);
        String num2 = input.next();
        System.out.println(Constants.ENTERSECONDBASENUMBER);
        int base2 = input.nextInt();

        System.out.println(Constants.ENTERTARGETBASE);
        int resultBase = input.nextInt();

        // Convert both numbers to decimal
        int decimalNum1 = toDecimal(num1, base1);
        int decimalNum2 = toDecimal(num2, base2);

        // Perform addition in decimal
        int resultDecimal = decimalNum1 + decimalNum2;

        // Convert result to the target base
        String result = fromDecimal(resultDecimal, resultBase);

        System.out.println(Constants.ADDITIONRESUT + result);
    }

    // Perform subtraction of two numbers in any base
    public static void baseSubtraction() {
        Scanner input = new Scanner(System.in);

        System.out.println(Constants.ENTERFIRSTNUMBER);
        String num1 = input.next();
        System.out.println(Constants.ENTERBASEFIRSTNUMBER);
        int base1 = input.nextInt();

        System.out.println(Constants.ENTERSECONDNUMBER);
        String num2 = input.next();
        System.out.println(Constants.ENTERSECONDBASENUMBER);
        int base2 = input.nextInt();

        System.out.println(Constants.ENTERTARGETBASE);
        int resultBase = input.nextInt();

        // Convert both numbers to decimal
        int decimalNum1 = toDecimal(num1, base1);
        int decimalNum2 = toDecimal(num2, base2);

        // Perform subtraction in decimal
        int resultDecimal = decimalNum1 - decimalNum2;

        // Convert result to the target base
        String result = fromDecimal(resultDecimal, resultBase);

        System.out.println(Constants.SUBSTRACTIONRESULT + result);
    }

    // Perform multiplication of two numbers in any base
    public static void baseMultiplication() {
        Scanner input = new Scanner(System.in);

        System.out.println(Constants.ENTERFIRSTNUMBER);
        String num1 = input.next();
        System.out.println(Constants.ENTERBASEFIRSTNUMBER);
        int base1 = input.nextInt();

        System.out.println(Constants.ENTERSECONDNUMBER);
        String num2 = input.next();
        System.out.println(Constants.ENTERSECONDBASENUMBER);
        int base2 = input.nextInt();

        System.out.println(Constants.ENTERTARGETBASE);
        int resultBase = input.nextInt();

        // Convert both numbers to decimal
        int decimalNum1 = toDecimal(num1, base1);
        int decimalNum2 = toDecimal(num2, base2);

        // Perform multiplication in decimal
        int resultDecimal = decimalNum1 * decimalNum2;

        // Convert result to the target base
        String result = fromDecimal(resultDecimal, resultBase);

        System.out.println(Constants.MULTIPLICATIONRESULT + result);
    }

    // Perform division of two numbers in any base
    public static void baseDivision() {
        Scanner input = new Scanner(System.in);

        System.out.println(Constants.ENTERFIRSTNUMBER);
        String num1 = input.next();
        System.out.println(Constants.ENTERBASEFIRSTNUMBER);
        int base1 = input.nextInt();

        System.out.println(Constants.ENTERSECONDNUMBER);
        String num2 = input.next();
        System.out.println(Constants.ENTERSECONDBASENUMBER);
        int base2 = input.nextInt();

        System.out.println(Constants.ENTERTARGETBASE);
        int resultBase = input.nextInt();

        // Convert both numbers to decimal
        int decimalNum1 = toDecimal(num1, base1);
        int decimalNum2 = toDecimal(num2, base2);

        if (decimalNum2 == 0) {
            System.out.println(Constants.ERROR);
            return;
        }

        // Perform division in decimal
        int resultDecimal = decimalNum1 / decimalNum2;

        // Convert result to the target base
        String result = fromDecimal(resultDecimal, resultBase);

        System.out.println(Constants.DIVISIONRESULT + result);
    }



    public static int power(int a,int b){
            int power = 1;
            for(int i=1;i<=b;i++) {
                power = power * a;
            }
            return power;
    }
    public static boolean isValidNumberForBase(String number, int base) {
        for (int i = 0; i < number.length(); i++) {
            char ch = number.charAt(i);
            if (base == 2 && (ch != '0' && ch != '1')) {
                return false;
            }
            if (base == 8 && (ch < '0' || ch > '7')) {
                return false;
            }
            if (base == 10 && (ch < '0' || ch > '9')) {
                return false;
            }
            if (base == 16 && !isHexadecimalChar(ch)) {
                return false;
            }
        }
        return true;
    }

    // to check if a character is valid in hexadecimal
    public static boolean isHexadecimalChar(char ch) {
        return (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'F') || (ch >= 'a' && ch <= 'f');
    }

   public static boolean isNegative(int n){
        if(n<0)
            return true;
        else
            return false;
    }
    public static void convertToDecimal() {
        Scanner input = new Scanner(System.in);
        System.out.println(Constants.ENTERNUMBER);
        String number = input.nextLine();
        System.out.println(Constants.BASENUMBER);
        int base = input.nextInt();
        if(!(isValidNumberForBase( number,  base))){
            System.out.println(Constants.INVALID);
            return;
        };
        int decimalValue = 0;
        int power = 0;

        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.digit(number.charAt(i), base);
            if (digit < 0) {
                throw new IllegalArgumentException(Constants.INVALIDCHARACTER + number.charAt(i));
            }
            decimalValue += digit * power(base, power);
            power++;
        }

        System.out.println(decimalValue);
}
        public static void decimalToOtherConversion() {
       Scanner input = new Scanner(System.in);

            int number = 0 ;
            int base = 0;

                try{
                    System.out.println(Constants.ENTERDECIMALNUMBER);
                    number = input.nextInt();
                    System.out.println(Constants.BASE);
                    base = input.nextInt();

                }
                catch (Exception e){
                    System.out.println(Constants.INVALID);

                }

            String str = "";
            int n = Math.abs(number);
            while(n != 0) {
                int rem = n % base;
                if(rem > 9){
                    rem += 55;
                    str = (char)rem + str;
                }
                else str = rem + str;
                n /= base;
            }
            if(isNegative(number)){
                System.out.println("-"+str);
            }
           else  System.out.println(str);
        }
    public static void baseToBaseConversion() {
        Scanner input = new Scanner(System.in);

        System.out.println(Constants.ENTERNUMBER);
        String number = input.next();

        System.out.println(Constants.BASE1);
        int baseFrom = input.nextInt();

        System.out.println(Constants.BASE2);
        int baseTo = input.nextInt();

        if (!isValidNumberForBase(number, baseFrom)) {
            System.out.println(Constants.INVALIDBASE + baseFrom);
            return;
        }

        // Convert the number from baseFrom to decimal
        int decimalValue = 0;
        int power = 0;
        for (int i = number.length() - 1; i >= 0; i--) {
            int digit = Character.digit(number.charAt(i), baseFrom);
            decimalValue += digit * power(baseFrom, power);
            power++;
        }

        // Convert the decimal value to the target base
        String result = "";
        int n = decimalValue;
        while (n > 0) {
            int rem = n % baseTo;
            if (rem > 9) {
                result = (char) (rem - 10 + 'A') + result;
            } else {
                result = rem + result;
            }
            n /= baseTo;
        }

        System.out.println("Converted number: " + result);
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean quit = true;
        while (quit) {
            System.out.println(Constants.CHOOSEOPERATION);
            System.out.println(Constants.DECIMAL_TO_OTHER);
            System.out.println(Constants.OTHER_TO_DECIMAL);
            System.out.println(Constants.BASE_TO_BASE);
            System.out.println(Constants.BASE_ADDITION);
            System.out.println(Constants.BASE_SUBSTRACTION);
            System.out.println(Constants.BASE_MULTIPLICATION);
            System.out.println(Constants.BASE_DIVISION);
            System.out.println(Constants.QUIT);
            String choice = input.next();
            switch (choice) {
                case "1":
                    decimalToOtherConversion();
                    break;
                case "2":
                   convertToDecimal();
                    break;
                case "3":
                    baseToBaseConversion();
                    break;
                case "4":
                    baseAddition();
                    break;
                case "5":
                    baseSubtraction();
                    break;
                case "6":
                    baseMultiplication();
                    break;
                case "7":
                    baseDivision();
                    break;
                case "8":
                    quit=false;
                    break;
            }
        }
    }
}