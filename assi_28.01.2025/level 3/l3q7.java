import java.util.HashSet;
public class l3q7{

    public static int generateOTP() {
        return 100000 + (int) (Math.random() * 900000); 
    }

    public static boolean areOTPsUnique(int[] otps) {
        HashSet<Integer> uniqueOTPs = new HashSet<>();

        for (int otp : otps) {
            if (!uniqueOTPs.add(otp)) {
                return false;
            }
        }

        return true;
    }

    
    public static void main(String[] args) {
        int[] otps = new int[10]; 

       
        for (int i = 0; i < 10; i++) {
            otps[i] = generateOTP();
        }

       
        System.out.println("Generated OTPs:");
        for (int otp : otps) {
            System.out.println(otp);
        }

  
        boolean unique = areOTPsUnique(otps);
        System.out.println("\nAre all OTPs unique? " + unique);
    }
}
