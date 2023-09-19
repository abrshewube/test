public class Prac {
    public static void main(String[] args) {
        boolean x = testScore(61);
        System.out.println(x);

        int y = testRate(68);
        System.out.println(y);

        String f = grd(99);
        System.out.println(f);

        double a = shipRate(78);
        System.out.println(a);

        double b = calshiprate(62);
        System.out.println(b);

        double c = hotelFee(9);
        System.out.println(c);

        double d = stayTotal(6);
        System.out.println(d);

        boolean e = acceptPkg(87);
        System.out.println(e);

        boolean g = accPkg(39, 56, 76, 32);
        System.out.println(g);


    }
   public static boolean testScore(int score) {
        boolean ts = (score >=70);
        return ts;
   }
   public static int testRate(int rate) {
        if (rate >= 90) {
            return 1;
        } else if (rate >=50) {
            return 2;
        } else if (rate >= 25) {
            return 3;
        } else {
            return 4;
        }
   }

   public static String grd(int guru) {
        if (guru >=90) {
            return "A";
        } else if (guru >=80) {
            return "B";
       } else if (guru >=70) {
            return "C";
        } else if (guru >=60) {
            return "D;";
        } else {
            return "F";
        }
   }
      public static double shipRate(int weight) {
        if (weight <=40) {
            return 0.50;
        } else {
            return 0.75;
        }
      }

      public static double calshiprate(int wei) {
        if (wei <=40 ) {
            return 0.50;
        } else {
            return 0.50 + wei * 0.75;
        }
      }

      public static double hotelFee(int nights) {
        if (nights <=2) {
            return 99.99;
        } else {
            return 89.99;
        }
      }
      public static double stayTotal(int numNights) {
        double dailyRate = 99.99;
        double discRate = 89.99;
        double prkRate = 25.00;
        double ltCkFee = 20.00;
        int minNigForDis = 3;
        if (numNights < 3) {
            return numNights * (dailyRate + prkRate + ltCkFee);
        } else {
            return numNights * (discRate + prkRate + ltCkFee);
        }
      }

      public static boolean acceptPkg(int weigg) {
        boolean pkg = (weigg <=40);
        return pkg;
      }
      public static boolean accPkg(int weiggg, int length, int width, int height) {
        boolean acc = (weiggg <= 40 && (length * width * height <= 6912));
        return acc;

      }
}
