public class RandomGenerator {
    static String generateRandomName(){
        return "Rahul" + new java.util.Random().nextInt(1000);
    }
     static  String generateRandomEmail(){
        return "rahul" + new java.util.Random().nextInt(1000) + "@gmail.com";
    }

//    static String generateIncorrectRandomName(){
//        return "Rahul" + new java.util.Random().nextInt(1000);
//    }
//    static  String generateIncorrectRandomEmail(){
//        return "rahul" + new java.util.Random().nextInt(1000) + "@gmail.com";
//    }
}
