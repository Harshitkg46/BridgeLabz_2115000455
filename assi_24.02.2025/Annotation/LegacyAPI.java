class LegacyAPI {
   @Deprecated
   public void oldFeature() {
       System.out.println("old method");
   }
   public void newFeature() {
       System.out.println("new method");
   }
}
public class DeprecatedMethods {
   public static void main(String[]args){
       LegacyAPI api =new LegacyAPI();
       api.oldFeature();//oldFeature() in LegacyAPI has been deprecated
       api.newFeature();
   }
}
